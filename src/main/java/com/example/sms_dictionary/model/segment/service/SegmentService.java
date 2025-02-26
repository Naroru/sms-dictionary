package com.example.sms_dictionary.model.segment.service;

import com.example.sms_dictionary.model.segment.entity.Segment;
import com.example.sms_dictionary.model.segment.service.dto.SegmentDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SegmentService {

  SegmentDto findById(Long id);

  List<SegmentDto> findAll();

  List<SegmentDto> findBySpecification(Specification<Segment> specification);

  SegmentDto save(SegmentDto dto);

  void setDeleted(Long id);
}
