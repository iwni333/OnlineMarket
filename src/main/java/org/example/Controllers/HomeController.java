package org.example.Controllers;

import org.example.Models.Product;
import org.example.Service.ProductService;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/market")
public class HomeController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public HomeController(UserService userService,  ProductService productService) {
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
}
