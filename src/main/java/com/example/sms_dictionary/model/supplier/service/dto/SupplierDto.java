package com.example.sms_dictionary.model.supplier.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
  private Long id;
  private String name;
  private String inn;
  private SupplierContactInfoDto contactInfo;
}
