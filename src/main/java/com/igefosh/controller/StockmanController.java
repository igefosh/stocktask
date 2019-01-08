package com.igefosh.controller;

import com.igefosh.entity.OrderEntity;
import com.igefosh.service.StockmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class StockmanController {

    @Autowired
    public StockmanService stockmanService;

    @PostMapping("/toStockmanList")
    public String toStockmanList(@ModelAttribute("smnListEntity") OrderEntity orderEntity){
        stockmanService.saveToSorders(orderEntity);
        return "redirect:/allOrders";
    }
    @GetMapping("/deleteFromStockmanList/{id}")
    public String delete(@PathVariable("id") int id){
        stockmanService.deleteFromSorders(id);
        return "redirect:/allOrders";
    }
    //todo finish him!
    @GetMapping("/stockmanList")
    public String getConfirmedList(Model model) {
        stockmanService.save(stockmanService.createSListEntitys());
        model.addAttribute("sorders", stockmanService.findAll());
        return "stockmanList";
    }
    @GetMapping("/finish")
    public String allDone(){
        stockmanService.clearAll();
        return "redirect:/allOrders";
    }

    @GetMapping("/deleteOrder/{order}")
    public String deleteOrder(@PathVariable("order") String order){
        stockmanService.removeOrder(order);
        return "redirect:/allOrders";
    }
}
