package com.example.calculatorapp.controller;

import com.example.calculatorapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", user.getUsername());
        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String op, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        double result = 0;
        String error = null;
        switch (op) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/":
                if (num2 == 0) error = "Cannot divide by zero";
                else result = num1 / num2;
                break;
            default: error = "Invalid operation";
        }
        model.addAttribute("username", user.getUsername());
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("op", op);
        if (error != null) {
            model.addAttribute("error", error);
        } else {
            model.addAttribute("result", result);
        }
        return "dashboard";
    }
} 