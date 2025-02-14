package com.example.sms_dictionary.web;

import com.example.sms_dictionary.model.product.service.ProductService;
import com.example.sms_dictionary.model.product.service.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  public ProductDto findById(@PathVariable Long id) {
    return productService.findById(id);
  }

  @GetMapping
  public List<ProductDto> findAll() {
    return productService.findAll();
  }

  @PostMapping
  public ProductDto save(@RequestBody ProductDto productDto) {
    return productService.save(productDto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productService.setDeleted(id);
  }
}
