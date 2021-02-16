package com.Dietary_Catering.Starter.Controller;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Factory.FoodFactory;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {

@Autowired
UserService userService;


    @RequestMapping
    public String mainPage(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/diets")
    public String dietsPage(Model model){
        model.addAttribute("foodList", FoodFactory.getFoodList());
        return "diets";
    }

    @GetMapping("/price-list")
    public String priceList(Model model){
        return "price-list";
    }

    @GetMapping("/registry")
        public String registryPage(Model model){
            model.addAttribute("person", new Person());
            return "registry";
        }

    @PostMapping("/registry")
    public String createPerson(@ModelAttribute Person person){
        System.out.println(person);
        userService.createPerson(person);

        return "redirect:/account";
    }

    @GetMapping("/kontakt")
    public String KontaktForm(Model model){
        model.addAttribute("contact", new ContactForm());
        return "kontakt";
    }

    @PostMapping("/kontakt")
    public String WyslijKontakt(@ModelAttribute ContactForm contactForm){
        System.out.println(contactForm);
        return "index";

    }

    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("foodList", FoodFactory.getFoodList());
        return "admin";
    }

    @GetMapping("/user_panel")
    public String afterLogin(Model model){
        model.addAttribute("foodList", FoodFactory.getFoodList());
        return "/user_panel";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }
}
