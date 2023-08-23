package com.example.app.repository;

import com.example.app.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<Product, Long> {
    // Add custom queries if needed
}
