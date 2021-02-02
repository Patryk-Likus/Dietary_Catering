package com.Dietary_Catering.Starter.Controller;


import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

@Autowired
UserService userService;

    //Person person = new Person("Jan", "Nowak","nowakwp.pl","798567465", "polska", "bydgoszcz", "87-000", "12345");

    @RequestMapping
    public String mainPage(Model model){
        //userService.createPerson(person); po odswiezeniu strony dodaje uzytkownika person do bazy danych ( docelowo tutaj mamy przekazywać wartość z pola przy rejestracji)
        return "main";
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
