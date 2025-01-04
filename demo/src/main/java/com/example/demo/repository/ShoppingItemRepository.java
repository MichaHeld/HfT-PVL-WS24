package com.example.demo.repository;

import com.example.demo.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
    List<ShoppingItem> findByNameContainingIgnoreCase(String name);
}
