package com.Dietary_Catering.Starter.Controller;


import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Factory.FoodFactory;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

@Autowired
UserService userService;

    //Person person = new Person("Jan", "Nowak","nowakwp.pl","798567465", "polska", "bydgoszcz", "87-000", "12345");

    @RequestMapping
    public String mainPage(Model model){

        //userService.createPerson(person);// po odswiezeniu strony dodaje uzytkownika person do bazy danych ( docelowo tutaj mamy przekazywać wartość z pola przy rejestracji)
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/diets")
    public String dietsPage(Model model){
        model.addAttribute("foodList", FoodFactory.getFoodList());
        return "diets";
    }

    @GetMapping("/account")
    public String agd(Model model){
        model.addAttribute("person", new Person());
        //model.addAttribute("productList", FactoryProduct.getProductList());
        return "account";
    }

    @PostMapping("/account")
    public String login(@ModelAttribute Person person){
        System.out.println("email: " + person.getEmail() + " " + person.getPassword());
        if(person.getEmail().equalsIgnoreCase("jan"))
            return "redirect:/account";
        return "index";
    }

    @GetMapping("/registry")
        public String registryPage(Model model){
            model.addAttribute("person", new Person());
            return "registry";
        }


    @PostMapping("/registry")
    public String createPerson(@ModelAttribute Person person){
        System.out.println("imię: "  + person.getName() + " " + person.getSurname());
        if(person.getName().equalsIgnoreCase("Pat")){
            return "account";
        }
        else
            return "redirect:/registry";
    }
    /*@RequestMapping(value = "/rejestracja", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error ->{
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            }
            );
            return "rejestracja";
        }else {
            userService.saveUser(user);
            return "indexLogIn";
        }
    }*/
}
