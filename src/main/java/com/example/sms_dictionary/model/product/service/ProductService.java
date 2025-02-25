package com.example.sms_dictionary.model.product.service;

import com.example.sms_dictionary.model.product.service.dto.ProductDto;

import java.util.List;

public interface ProductService {

  ProductDto findById(Long id);

  List<ProductDto> findAll();

  ProductDto save(ProductDto productDto);

  void setDeleted(Long id);
}
