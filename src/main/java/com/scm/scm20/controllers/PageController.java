package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");

        //sending data the view
        model.addAttribute("name", "SubString Technologies");
        model.addAttribute("YoutubeChannel", "Tech Freak");
        model.addAttribute("githubRepo", "https://start.spring.io/");
        return "home";
    }

    //about route 
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("About Page Loading");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Service Page Loading");
        return "services";
    }
}
