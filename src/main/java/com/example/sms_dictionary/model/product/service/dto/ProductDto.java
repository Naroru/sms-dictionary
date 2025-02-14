package com.example.sms_dictionary.model.product.service.dto;

import com.example.sms_dictionary.enums.NdsPositions;
import com.example.sms_dictionary.model.segment.service.dto.SegmentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
  private long id;
  private String name;
  private SegmentDto segment;
  private NdsPositions nds;
  private boolean isDeleted;
}
