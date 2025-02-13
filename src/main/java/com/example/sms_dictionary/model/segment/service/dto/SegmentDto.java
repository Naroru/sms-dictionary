package com.example.sms_dictionary.model.segment.service.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SegmentDto {
  private Long id;
  private String name;
  private boolean isDeleted;
}
