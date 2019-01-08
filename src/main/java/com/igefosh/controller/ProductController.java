package com.igefosh.controller;

import com.igefosh.entity.Product;
import com.igefosh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// stocktask_war/
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public ProductService productService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "productList";
    }

    @GetMapping("/product/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "showProduct";
    }

    @GetMapping("/addProduct")
    public String createProductPage(){
        return "createProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("user", productService.getById(id));
        return "editProduct";
    }

    @PostMapping("/update/updateProduct")
    public String updateUser(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/products";
    }
}
