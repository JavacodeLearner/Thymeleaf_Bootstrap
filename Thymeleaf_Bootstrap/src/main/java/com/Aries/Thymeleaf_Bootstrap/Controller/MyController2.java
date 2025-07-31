package com.Aries.Thymeleaf_Bootstrap.Controller;

import com.Aries.Thymeleaf_Bootstrap.Entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController2 {

    @GetMapping("/")
    public String demo(){

        return "home";
    }


    @GetMapping("/book")
    public String home(Model model){
       model.addAttribute("modelbook",new Book());
        return "index2";
    }


}
