package com.syslgpd.springboot.controller;

import com.syslgpd.springboot.model.User;
import com.syslgpd.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@SpringBootApplication
@RestController
public class UserController {

    private IUserService service;

    @GetMapping("/")
    public String Home(){
        return "HomePage";
    }

    @GetMapping("/register")
    public String ShowRegistration(){

        return "RegisterUserPage";
    }


    @GetMapping("/save")
    public String SaveUser(@ModelAttribute User user, Model model){
        service.adduser(user);
        int id= service.adduser(user).getId();
        String message= "Adicionado com id " + id;
        model.addAttribute("message",message);
        return "RegisterUserPage";
    }

    @GetMapping("/getallusers")
    public String GetAllUsers(@RequestParam(value = "message", required = false) String message,
                              Model model
    ) {
        List<User> users= service.getallusers();
        model.addAttribute("list",users);
        model.addAttribute("message",message);
        return "AllUsersPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam int id){
        String page=null;
        try{
            User user= service.getuserbyid(id);
            model.addAttribute("user",user);
            page="EditUserPage";
        }
        catch (Exception e){
            e.printStackTrace();
            attributes.addAttribute("message",e.getMessage());
            page="Redirect:AllUsersPage";
        }
        return page;
    }

   @PostMapping("/update")
   public String updateUser(@ModelAttribute User user, RedirectAttributes attributes){
        service.updateuser(user);
        int id= user.getId();
        attributes.addAttribute("message","User with id: " + id +"is updated successfully!");
       return "Redirect:AllUsersPage";
   }

   @GetMapping("/delete")
    public String deleteUser(@RequestParam int id, RedirectAttributes attributes){
        try{
            service.deleteuserbyid(id);
            attributes.addAttribute("message","User with id" + id + "was updated successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            attributes.addAttribute("message",e.getMessage());
        }
        return "Redirect:AllUsersPage";
   }

   public static void main(String[] args){
        SpringApplication.run(UserController.class,args);
   }
}


