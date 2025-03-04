package com.example.sms_dictionary.web;

import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.supplier.service.SupplierService;
import com.example.sms_dictionary.model.supplier.service.dto.SupplierDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {

  private final SupplierService service;

  @GetMapping("/{id}")
  public SupplierDto findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @GetMapping
  public List<SupplierDto> findAll() {
    return service.findAll();
  }

  @PostMapping("/criteria")
  public List<SupplierDto> findByCriteria(@RequestBody SearchCriteria criteria) {
    return service.findBySearchCriteria(criteria);
  }

  @PostMapping
  public SupplierDto save(@RequestBody SupplierDto dto) {
    return service.save(dto);
  }

  @DeleteMapping
  public void delete(@RequestParam Long id) {
    service.setDeleted(id);
  }
}
