package syksy26.hellothymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getMethodName(@RequestParam String name, @RequestParam String age, Model model) 
    {
        model.addAttribute("nimi", name);
        model.addAttribute("ika", age);
        return "hello"; // hello.html
    }

}
