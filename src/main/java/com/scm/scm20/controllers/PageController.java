package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.helpers.MessageType;
import com.scm.scm20.helpers.Mesage;
import com.scm.scm20.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService UserService;

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");

        // sending data the view
        model.addAttribute("name", "SubString Technologies");
        model.addAttribute("YoutubeChannel", "Tech Freak");
        model.addAttribute("githubRepo", "https://start.spring.io/");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About Page Loading");
        return "about";
    }

    // services
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Service Page Loading");
        return "services";
    }

    // contact page
    @GetMapping("/contact")
    public String contact() {
        System.out.println("Conatct Page Loading");
        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Himanshu");
        // userForm.setAbout("This is About : Write Something about Yourself");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register - do register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("processing form");
        // fetch form data
        // user form

        System.out.println(userForm);
        // validate form data
        // TODO :: validate userform

        // save to database

        // userservice
        // userForm --> user

        /*
         * User user = User.builder()
         * .name(userForm.getName())
         * .email(userForm.getEmail())
         * .password(userForm.getPassword())
         * .about(userForm.getAbout())
         * .phoneNumber(userForm.getPhoneNumber())
         * .profilePic(
         * "")
         * .build();
         */

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://www.freepik.com/free-psd/3d-illustration-person-with-sunglasses_27470334.htm#query=default%20user&position=11&from_view=keyword&track=ais_hybrid&uuid=55a3c8c3-a549-4f63-88c6-b9a6776372f3");

        User savedUser = UserService.saveUser(user);
        System.out.println("User Saved:");

        // message = "registeration successfull"
        // add the message:
        Mesage message = Mesage.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);
        // redirect to login page
        return "redirect:/register";
    }
}
