package com.example.demo.service;

import com.example.demo.entity.ShoppingItem;
import com.example.demo.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; // für List
import org.springframework.http.HttpStatus; // für HttpStatus
import org.springframework.web.server.ResponseStatusException; // für ResponseStatusException


@Service
public class ShoppingItemService {

    private final ShoppingItemRepository shoppingItemRepository;

    @Autowired
    public ShoppingItemService(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    public ShoppingItem saveItem(ShoppingItem item) {
        return shoppingItemRepository.save(item);
    }

    public ShoppingItem updateItem(Long id, ShoppingItem updatedItem) {
        ShoppingItem existingItem = shoppingItemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
        existingItem.setQuantity(updatedItem.getQuantity());
        existingItem.setName(updatedItem.getName());
        return shoppingItemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        shoppingItemRepository.deleteById(id);
    }

    public List<ShoppingItem> getAllItems() {
        return shoppingItemRepository.findAll();
    }
}
