package syksy26.hello_world.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/index")
    @ResponseBody
    public String mainPage() 
    {
        return "This is the main page"; 
    }

    @GetMapping("/contact")
    @ResponseBody
    public String contactPage() 
    {
        return "This is the contact page"; 
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String returnHello(@RequestParam String name, @RequestParam String location) 
    {
        return "Welcome to the " + location + " " + name + "!";
    }


}
