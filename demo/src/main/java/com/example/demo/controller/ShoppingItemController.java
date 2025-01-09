package com.example.demo.controller;

import com.example.demo.entity.ShoppingItem;
import com.example.demo.service.ShoppingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShoppingItemController {

    private final ShoppingItemService service;

    // Injektion des Services statt des Repositories
    @Autowired
    public ShoppingItemController(ShoppingItemService service) {
        this.service = service;
    }

    // Gibt alle Artikel zurück
    @GetMapping
    public List<ShoppingItem> getAllItems() {
        return service.getAllItems();
    }

    // Fügt einen neuen Artikel hinzu
    @PostMapping
    public ShoppingItem addItem(@RequestBody ShoppingItem item) {
     // Beispiel: Zugriff auf die Menge (quantity)
        int quantity = item.getQuantity(); // Wenn die Menge benötigt wird
        return service.saveItem(item);
    }
    // Löscht einen Artikel basierend auf der ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Gibt einen 204 HTTP-Status zurück, wenn gelöscht wurde
    public void deleteItem(@PathVariable Long id) {
        try {
            service.deleteItem(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found", e);
        }
    }

    // Aktualisiert einen Artikel basierend auf der ID
    @PutMapping("/{id}")
    public ShoppingItem updateItem(@PathVariable Long id, @RequestBody ShoppingItem updatedItem) {
      // Beispiel: Zugriff auf die Menge (quantity)
      int quantity = updatedItem.getQuantity(); // Wenn die Menge benötigt wird
      return service.updateItem(id, updatedItem);
    }
}
