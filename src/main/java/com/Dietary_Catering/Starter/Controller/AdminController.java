package com.Dietary_Catering.Starter.Controller;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.Services.FoodService;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;


    @GetMapping("/admin")
    public String adminPage(Model model) {

        model.addAttribute("foodList", foodService.getFoodList());
        model.addAttribute("personsList", userService.getPersons());
        model.addAttribute("orderHistory", userService.getAllOrderHistory());
        model.addAttribute("contactList", userService.getAllContactForms());
        return "admin";
    }
    @GetMapping("/admin/showNewFoodForm")
    public String showNewFoodForm(Model model){
        Food food = new Food();
        model.addAttribute("food", food);
        return "new_food";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute("food") Food food){
        foodService.savefood(food);
        return "redirect:/admin";
    }

    @GetMapping("/admin/showUpdateFoodForm/{id}")
    public String showUpdateFoodForm(@PathVariable(value = "id") int id, Model model){
        Food food = foodService.getFoodById(id);
        model.addAttribute("food", food);
        return "update_food";
    }

    @PostMapping("/updateFood")
    public String updateFood(@ModelAttribute("food") Food food){
        foodService.updateFood(food);
        return "redirect:/admin";
    }

    @GetMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable(value = "id") int id, Model model){
        Food food = foodService.getFoodById(id);
        foodService.deleteFood(food);
        return "redirect:/admin";
    }

//    @PostMapping("/deleteFood")
//    public String deleteFood(@ModelAttribute("food") Food food){
//        foodService.deleteFood(food);
//        return "redirect:/admin";
//    }

    //kontakt form
    @GetMapping("/admin/showUpdateContact/{id}")
    public String showUpdateContact(@PathVariable(value = "id") int id, Model model){
        ContactForm contactForm = userService.getContactById(id);
        model.addAttribute("contact", contactForm);
        return "update_kontakt";
    }

    @PostMapping("/updateContact")
    public String updateContact(@ModelAttribute("contact")ContactForm contactForm){
        userService.updateContact(contactForm);
        return "redirect:/admin";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable(value = "id") int id, Model model){
        ContactForm contactForm = userService.getContactById(id);
        userService.deleteContact(contactForm);
        return "redirect:/admin";
    }

}
