package com.example.sms_dictionary.model.product.entity;

import com.example.sms_dictionary.enums.NdsPositions;
import com.example.sms_dictionary.model.segment.entity.Segment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @ManyToOne()
  @JoinColumn(name = "segment_id", nullable = false)
  private Segment segment;

  @Enumerated(EnumType.STRING)
  @Column(name = "nds")
  private NdsPositions nds;

  @Column(name = "is_deleted")
  private boolean isDeleted;
}
