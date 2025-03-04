package com.example.sms_dictionary.model.supplier.service;

import com.example.sms_dictionary.common.SpecificationBuilder;
import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.supplier.entity.Supplier;
import com.example.sms_dictionary.model.supplier.service.dto.SupplierDto;
import com.example.sms_dictionary.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

  private final SupplierRepository repository;
  private final ModelMapper mapper;
  private final SpecificationBuilder<Supplier> specificationBuilder;


  @Override
  public SupplierDto findById(Long id) {
    return repository.findById(id)
        .map(supplier -> mapper.map(supplier, SupplierDto.class))
        .orElseThrow(() -> new EntityNotFoundException("Supplier with id " + id + " not found"));
  }

  @Override
  public List<SupplierDto> findAll() {
    return repository.findAll()
        .stream()
        .map((element) -> mapper.map(element, SupplierDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<SupplierDto> findBySearchCriteria(SearchCriteria searchCriteria) {

    return repository.findAll(specificationBuilder.createSpecification(searchCriteria))
        .stream()
        .map((element) -> mapper.map(element, SupplierDto.class))
        .collect(Collectors.toList());

  }

  @Override
  public SupplierDto save(SupplierDto supplierDto) {
    Supplier entity = mapper.map(supplierDto, Supplier.class);
    return mapper.map(repository.save(entity), SupplierDto.class);
  }

  @Override
  public void setDeleted(Long id) {
    repository.findById(id).ifPresent(supplier -> {
      supplier.setDeleted(!supplier.isDeleted());
      repository.save(supplier);
    });
  }
}
