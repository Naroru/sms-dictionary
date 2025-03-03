package com.example.sms_dictionary.repository;

import com.example.sms_dictionary.model.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierReposiory extends JpaRepository<Supplier, Long> {
}
