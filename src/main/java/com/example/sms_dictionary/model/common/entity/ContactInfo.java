package com.example.sms_dictionary.model.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class ContactInfo {

  @Column(name = "phone")
  private String phone;

  @Column(name = "street")
  private String street;

  @Column(name = "building_number")
  private String buildingNumber;
}
