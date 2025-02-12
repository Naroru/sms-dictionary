package com.example.sms_dictionary.model.segment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "segments")
@Setter
@Getter
public class Segment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "is_deleted")
  private boolean isDeleted;
}
