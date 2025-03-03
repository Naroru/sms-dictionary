package com.example.sms_dictionary.model.supplier.entity;

import com.example.sms_dictionary.model.common.entity.ContactInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
public class Supplier {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  @NotBlank
  private String name;

  @Column
  @NotBlank
  @Size(min = 10, max = 10)
  private String inn;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "phone", column = @Column(name = "contact_person_phone"))})
  private ContactInfo contactInfo;

}
