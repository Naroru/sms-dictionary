package com.example.sms_dictionary.model.product.service;

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
  private final ModelMapper modelMapper;

  @Override
  public ProductDto findById(Long id) {
    return productRepository.findById(id)
        .map(product -> modelMapper.map(product, ProductDto.class))
        .orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll()
        .stream()
        .map(product -> modelMapper.map(product, ProductDto.class))
        .toList();
  }

  @Override
  public ProductDto save(ProductDto productDto) {
    Product saved = productRepository.save(modelMapper.map(productDto, Product.class));
    return modelMapper.map(saved, ProductDto.class);
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
