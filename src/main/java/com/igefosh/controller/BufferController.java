package com.igefosh.controller;

import com.igefosh.entity.BufferEntity;
import com.igefosh.service.BufferService;
import com.igefosh.service.ProductService;
import com.igefosh.service.StockmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BufferController {

    @Autowired
    public BufferService bufferService;
    @Autowired
    public ProductService productService;
    @Autowired
    public StockmanService stockmanService;

    @GetMapping("/bufferList")
    public String getBufferList(Model model){
        model.addAttribute("bufferEntitys", bufferService.findAll());
        return "bufferList";
    }

    @GetMapping("/toBuffer/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "addProductToOrder";
    }
    @PostMapping("/toBuffer/addToOrder")
    public String toBuffer(@ModelAttribute("bufferEntity") BufferEntity bufferEntity){
        bufferService.save(bufferEntity);
        return "redirect:/bufferList";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute("orderNumber") String orderNumber){
        bufferService.cloneAll(orderNumber);
        bufferService.clearAll();
        return "redirect:/products";
    }

    @GetMapping("/allOrders")
    public String getAllOrders(Model model){
        model.addAttribute("orders", bufferService.findOrders());
        model.addAttribute("sorders", stockmanService.findAllSorders());
        return "allOrdersList";
    }

    @GetMapping("/orderDetails/{order}")
    public String getOrderDetails(@PathVariable("order") String order, Model model){
        model.addAttribute("orderdetails", bufferService.findInTable(order));
        return "orderDetails";
    }
}
