package com.Dietary_Catering.Starter.Controller;

import com.Dietary_Catering.Starter.Config.SingUpMailer;
import com.Dietary_Catering.Starter.Config.UserAuthentication;
import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Services.FoodService;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private SingUpMailer mailer;

    @Autowired
    UserAuthentication userAuthentication;


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

        Person person = userService.getPersonById(48);
        Food food = foodService.getFoodById(37);
        userService.saveOrderHistory(new OrderHistory(person, food));


        return "diets";
    }

    @GetMapping("/price-list")
    public String priceList(Model model) {
        return "price-list";
    }

    @GetMapping("/registry")
    public String registryPage(Model model) {
        model.addAttribute("person", new Person());
        return "registry";
    }

    @PostMapping("/registry")
    public String createPerson(@ModelAttribute Person person) {
        System.out.println(person);
        userService.createPerson(person);
        return "redirect:/login";
    }

    @GetMapping("/kontakt")
    public String KontaktForm(Model model) {
        model.addAttribute("contact", new ContactForm());
        String login = (String) userAuthentication.getUserName();
        System.out.println(login);
        System.out.println(userService.getPersonByLogin(login));
        return "kontakt";
    }

    @PostMapping("/kontakt")
    public String WyslijKontakt(@ModelAttribute ContactForm contactForm) {
        System.out.println(contactForm);
        userService.createContactForm(contactForm);

        return "redirect:/kontakt";

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

        @RequestMapping(value = "/send_mail", method = RequestMethod.GET)
        public String sendMail () {
            mailer.sendMessage("kdietetyczny@gmail.com", "Temat maila", "Dzień dobry");
            return "index";
        }

    }
