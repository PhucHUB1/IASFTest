package com.example.iasftest.controller;

import com.example.iasftest.entity.Members;
import com.example.iasftest.repository.MembersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MembersController {

    @Autowired
    private MembersRepository membersRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("username") String membername, @RequestParam("password") String password, HttpSession session) {
        Optional<Members> optionalUser = membersRepository.findByMembersname(membername);
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            session.setAttribute("user", optionalUser.get());
            return "redirect:index";
        } else {
            model.addAttribute("message", "Invalid username or password");
        }
        return "index";

    }

    @PostMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {

        Members members = (Members) session.getAttribute("user");
        if (members != null) {
            model.addAttribute("username", members.getMembername());
            return "result";
        }
        return "redirect:/";
    }




}
