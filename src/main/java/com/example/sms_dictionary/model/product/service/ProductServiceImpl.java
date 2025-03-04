package com.example.sms_dictionary.model.product.service;

import com.example.sms_dictionary.common.SpecificationBuilder;
import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.product.entity.Product;
import com.example.sms_dictionary.model.product.service.dto.ProductDto;
import com.example.sms_dictionary.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final ModelMapper mapper;
  private final SpecificationBuilder<Product> specificationBuilder;

  @Override
  public ProductDto findById(Long id) {
    return productRepository.findById(id)
        .map(product -> mapper.map(product, ProductDto.class))
        .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll()
        .stream()
        .map(product -> mapper.map(product, ProductDto.class))
        .toList();
  }

  @Override
  public List<ProductDto> findByCriteria(SearchCriteria searchCriteria) {
    return productRepository.findAll(specificationBuilder.createSpecification(searchCriteria))
        .stream()
        .map(product -> mapper.map(product, ProductDto.class))
        .toList();
  }

  @Override
  public ProductDto save(ProductDto productDto) {
    Product saved = productRepository.save(mapper.map(productDto, Product.class));
    return mapper.map(saved, ProductDto.class);
  }

  @Override
  public void setDeleted(Long id) {
    productRepository.findById(id)
        .ifPresent(product -> {
          product.setDeleted(!product.isDeleted());
          productRepository.save(product);
        });
  }
}
