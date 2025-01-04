package com.example.demo.controller;

import com.example.demo.entity.ShoppingItem;
import com.example.demo.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ShoppingListController {

    private final ShoppingItemRepository repository;

    @Autowired
    public ShoppingListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String showShoppingList(Model model) {
        model.addAttribute("items", repository.findAll());
        return "shopping-list";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String name, @RequestParam int quantity) {
        ShoppingItem item = new ShoppingItem();
        item.setName(name);
        item.setQuantity(quantity);
        repository.save(item);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable Long id, @RequestParam int quantity) {
        repository.findById(id).ifPresent(item -> {
            item.setQuantity(quantity);
            repository.save(item);
        });
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
