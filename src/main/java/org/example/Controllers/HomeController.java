package org.example.Controllers;

import jakarta.validation.Valid;
import org.example.Models.Product;
import org.example.Models.User;
import org.example.Service.ProductService;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/market")
public class HomeController {


    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }
    @GetMapping("/home")
    public String home(Model model) {
        List<Product> products;
        products = productService.getAllProducts();
        model.addAttribute("messages", "Добро пожаловать в наш магазин!");
        model.addAttribute("product", products);
        return "home";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:home";
    }
}
