package com.example.sms_dictionary.repository;

import com.example.sms_dictionary.model.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
