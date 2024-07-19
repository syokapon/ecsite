package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.ProductRepository;



@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "productList";
    }
    
    @GetMapping("/home")
    public String gethome(Model model) {
		return "home";
    }
    
 
    
   
}
