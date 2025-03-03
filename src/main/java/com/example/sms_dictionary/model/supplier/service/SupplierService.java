package com.example.sms_dictionary.model.supplier.service;

import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.supplier.service.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

  SupplierDto findById(Long id);

  List<SupplierDto> findAll();

  List<SupplierDto> findBySearchCriteria(SearchCriteria searchCriteria);

  SupplierDto save(SupplierDto supplierDto);

  void setDeleted(Long id);
}
