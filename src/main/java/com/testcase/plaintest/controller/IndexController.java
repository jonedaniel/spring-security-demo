package com.testcase.plaintest.controller;

import com.testcase.plaintest.util.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
@Slf4j
public class IndexController {
    @Value("${server.context-path}")
    private String ctx;

    @ModelAttribute
    public void init(Model model) {
        model.addAttribute("ctx", ctx);
        model.addAttribute("now", new Date());
    }


    @GetMapping("/index")
    public String index()throws Exception {
        return "index";
    }

    @GetMapping("/login")
    public String login() throws Exception{
        return "login";
    }

    @GetMapping("/home/{username}")
    public String home(@PathVariable("username") String username)throws Exception {
        return "home";
    }

    @GetMapping("/page1")
    @PreAuthorize("hasAuthority('g1')")
    public String page1(Model model)throws Exception {
        model.addAttribute("username", UserContext.getUsername());
        return "page1";
    }

    @GetMapping("/logout")
    public String logoutPage() throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(UserContext.getRequest(), UserContext.getResponse(), auth);
        }
        return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
