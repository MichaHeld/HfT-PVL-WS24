// ShoppingItemViewController.java

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.ShoppingItemService;
import com.example.demo.entity.ShoppingItem;

@Controller
public class ShoppingItemViewController {

    @Autowired
    private ShoppingItemService shoppingItemService;

    @GetMapping("/shopping-list")
    public String getShoppingList(Model model) {
        model.addAttribute("shoppingItems", shoppingItemService.getAllItems());
        return "shopping-list"; // Thymeleaf Template
    }

    // Weitere Methoden...
}
