package com.example.sms_dictionary.model.product.service;

import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.product.service.dto.ProductDto;

import java.util.List;

public interface ProductService {

  ProductDto findById(Long id);

  List<ProductDto> findAll();

  List<ProductDto> findByCriteria(SearchCriteria searchCriteria);

  ProductDto save(ProductDto productDto);

  void setDeleted(Long id);
}
