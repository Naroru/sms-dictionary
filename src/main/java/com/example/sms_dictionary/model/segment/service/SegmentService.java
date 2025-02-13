package com.example.sms_dictionary.model.segment.service;

import com.example.sms_dictionary.model.segment.service.dto.SegmentDto;

import java.util.List;

public interface SegmentService {

  SegmentDto findById(Long id);

  List<SegmentDto> findAll();

  SegmentDto save(SegmentDto dto);

  void setDeleted(Long id);
}
