package com.example.sms_dictionary.model.segment.service;

import com.example.sms_dictionary.model.segment.entity.Segment;

import java.util.List;
import java.util.Optional;

public interface SegmentService {

  Optional<Segment> findById(Long id);

  List<Segment> findAll();

  Segment save(Segment segment);

  void setDeleted(Long id);
}
