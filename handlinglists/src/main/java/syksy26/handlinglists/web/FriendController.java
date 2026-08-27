package syksy26.handlinglists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import syksy26.handlinglists.domain.Friend;

@Controller
public class FriendController {

     
    public static final List<Friend> kaverit = new ArrayList<>();

  


    @GetMapping("/friend")
    public String showFriends(Model model) {
        model.addAttribute("friends", kaverit);
        model.addAttribute("friend", new Friend());
        return "friends";
    }

    @PostMapping("/saveFriend")
    public String saveFriendToList(@ModelAttribute Friend kaveri) {
        kaverit.add(kaveri);
        return "redirect:/friend";
    }


}
