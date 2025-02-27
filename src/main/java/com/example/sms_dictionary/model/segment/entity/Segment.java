package com.example.sms_dictionary.model.segment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "segments")
@Setter
@Getter
@NoArgsConstructor
public class Segment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  @NotBlank
  private String name;

  @Column(name = "is_deleted")
  private boolean isDeleted;

}
