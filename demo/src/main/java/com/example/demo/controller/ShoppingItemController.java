package com.example.demo.controller;

import com.example.demo.entity.ShoppingItem;
import com.example.demo.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShoppingItemController {

    private final ShoppingItemRepository repository;

    @Autowired
    public ShoppingItemController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ShoppingItem> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public ShoppingItem addItem(@RequestBody ShoppingItem item) {
        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ShoppingItem updateItem(@PathVariable Long id, @RequestBody ShoppingItem updatedItem) {
        return repository.findById(id)
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setQuantity(updatedItem.getQuantity());
                    return repository.save(item);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
