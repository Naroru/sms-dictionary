package com.example.sms_dictionary.model.supplier.service.dto;

import com.example.sms_dictionary.model.common.entity.ContactInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
  private Long id;
  private String name;
  private String inn;
  private ContactInfo contactInfo;
}
