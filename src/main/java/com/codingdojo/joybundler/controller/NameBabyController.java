package com.codingdojo.joybundler.controller;

import com.codingdojo.joybundler.model.BabyName;
import com.codingdojo.joybundler.model.User_BabyName;
import com.codingdojo.joybundler.service.UserBabyNameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.metamodel.Bindable;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NameBabyController {

    private final UserBabyNameService userBabyNameService;

    public NameBabyController(UserBabyNameService userBabyNameService) {
        this.userBabyNameService = userBabyNameService;
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model, @ModelAttribute("vote_user_babyname") User_BabyName user_babyName) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("babyNames", userBabyNameService.allBabyNames());
        return "home.jsp";
    }

    @PostMapping("/vote")
    public String vote(HttpSession session, @ModelAttribute("vote_user_babyname") User_BabyName user_babyName) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        userBabyNameService.createUserBabyName(user_babyName);
        userBabyNameService.LikeUsertoBabyName(user_babyName);
        return "redirect:/home";
    }

    @GetMapping("/names/{id}")
    public String show(HttpSession session, Model model, @PathVariable("id") Long id) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        BabyName babyName = userBabyNameService.singleBabyName(id);
        model.addAttribute("usercreated", userBabyNameService.findUserBabyName(babyName));
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("babyName", babyName);
        return "show.jsp";
    }

    @GetMapping("/names/new")
    public String newName(HttpSession session, Model model, @ModelAttribute("new_baby_name") BabyName babyName) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("user"));
        return "new.jsp";
    }

    @PostMapping("/create")
    public String create(HttpSession session, @Valid @ModelAttribute("new_baby_name") BabyName babyName, BindingResult result) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        if(result.hasErrors()) {
            return "new.jsp";
        }
        userBabyNameService.addBabyName(babyName);
        return "redirect:/home";
    }

    @GetMapping("/names/{id}/edit")
    public String edit(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("edit_baby_name") BabyName babyName, Model model) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        BabyName findbabyName = userBabyNameService.singleBabyName(id);
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("babyName", findbabyName);
        return "update.jsp";
    }

    @PostMapping("/update")
    public String update(HttpSession session, @Valid @ModelAttribute("edit_baby_name") BabyName babyName, BindingResult result) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        if(result.hasErrors()) {
            return "update.jsp";
        }
        userBabyNameService.updateBabyName(babyName);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(HttpSession session, @PathVariable("id") Long id) {
        if(session.getAttribute("user") == null) {
            return "redirect:/";
        }
        userBabyNameService.deleteBabyName(id);
        return "redirect:/home";
    }

}
