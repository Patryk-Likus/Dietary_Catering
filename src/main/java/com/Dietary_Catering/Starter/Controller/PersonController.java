package com.Dietary_Catering.Starter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @RequestMapping
    public String mainPage(Model model){
        return "index";
    }
}
