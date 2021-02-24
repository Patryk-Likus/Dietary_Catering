package com.Dietary_Catering.Starter.Controller;

import com.Dietary_Catering.Starter.Config.RandomTokenFactory;
import com.Dietary_Catering.Starter.Config.SingUpMailer;
import com.Dietary_Catering.Starter.Config.UserAuthentication;
import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Services.FoodService;
import com.Dietary_Catering.Starter.Services.HistoryService;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private SingUpMailer mailer;

    @Autowired
    HistoryService historyService;

    @Autowired
    UserAuthentication userAuthentication;

    ArrayList<Food> listFood = new ArrayList<Food>();

    private static final int TOKEN_LENGHT = 15;

    private static String busyLogin = "Podany login jest już zajęty";

    @RequestMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/diets")
    public String dietsPage(Model model) {
        model.addAttribute("foodList", foodService.getFoodList());
//        List<Food> foodList = FoodFactory.getFoodList();
       /* for (Food f : foodList) {   // <- zmienia foodfactory do DataBase
            foodService.savefood(f);
        }*/

/*
        Person person = userService.getPersonById(48);
        Food food = foodService.getFoodById(37);

        userService.saveOrderHistory(new OrderHistory(person, food));*/
        return "diets";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @GetMapping("/registry")
    public String registryPage(Model model) {
        model.addAttribute("person", new Person());
        return "registry";
    }

    @PostMapping("/registry")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        Person foundPerson = userService.getPersonByLogin(person.getLogin());
        if(!(foundPerson == null)){
            model.addAttribute("busyLogin", busyLogin);
            return "registry";
        }
        else if (bindingResult.hasErrors()) {
            System.out.println("error");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "registry";
        } else {
            String token = RandomTokenFactory.getRandomString(TOKEN_LENGHT);
            person.setConfirmationToken(token);
            mailer.sendConfirmationLink(person.getEmail(), token);
            userService.createPerson(person);
            return "redirect:/login";
        }
    }

    @GetMapping("/kontakt")
    public String KontaktForm(Model model) {
        model.addAttribute("contact", new ContactForm());
        return "kontakt";
    }

    @RequestMapping(value = "/kontakt", method = RequestMethod.POST)
    public String WyslijKontakt(@Valid @ModelAttribute("contact") ContactForm contactForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "kontakt";
        } else {
            userService.createContactForm(contactForm);
            return "index";
        }
    }

    @GetMapping("/user_panel")
    public String afterLogin(Model model) {
        model.addAttribute("foodList", foodService.getFoodList());
        return "/user_panel";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/diets/cart")
    public String showCart(@RequestParam("id") Integer id, Model model) {
        Food food = foodService.getFoodById(id);
        listFood.add(food);
        return "redirect:/diets";
    }

    @RequestMapping("/diets/cart/delete")
    public String deleteCart(@RequestParam("id") int id, Model model) {
        listFood.remove(id - 1);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/send_mail", method = RequestMethod.GET)
    public String sendMail() {
        return "index";
    }

    @GetMapping("cart")
    public String showCart(Model model) {
        model.addAttribute("foodList", listFood);
        int summaryPrice = 0;
        for (int i = 0; i < listFood.size() ; i++){
            summaryPrice += listFood.get(i).getPrice();
        }
        model.addAttribute("summary", summaryPrice);
        return "cart";
    }

    @GetMapping("order")
    public String order() {
        String allFood = "";
        String login = (String) userAuthentication.getUserName();
        Person person = userService.getPersonByLogin(login);
        for (Food food : listFood) {
            allFood += " " + food.toString1() + "\n";
            historyService.saveOrderHistory(new OrderHistory(person, food));
        }
        mailer.sendMessage("kdietetyczny@gmail.com", "Zamówienie użytkownika " + person.getLogin(), "Zamówione diety: \n" + allFood);
        listFood.clear();
        return "order";
    }

    @GetMapping("cancel")
    public String cancel(){
        listFood.clear();
        return "redirect:/cart";
    }

    @RequestMapping("/confirm_email")
    public String confirmEmail(@RequestParam(name = "token") String token) {
        Person person = userService.getPersonByToken(token);
        if (!person.equals(null)) {
            person.setEnabled(true);
            userService.createPerson(person);
            mailer.sendMessage(person.getEmail(), "Rejestracja Katering Dietetyczny", "Witaj " + person.getName() + ".\n"
                    + "Dziękujemy za założenie konta w naszym serwisie internetowym do zamawiania diet.");

            mailer.sendMessage("kdietetyczny@gmail.com", "Nowy użytkownik w bazie", "Imię: " + "" + person.getName() + "\n" +
                    "Nazwisko: " + "" + person.getSurname() + "\n" + "Login: " + "" + person.getLogin());
            return "login";
        } else {
            return "Nie ma takiego tokena";
        }
    }
}
