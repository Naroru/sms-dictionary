package com.example.sms_dictionary.model.segment.service;

import com.example.sms_dictionary.model.segment.entity.Segment;
import com.example.sms_dictionary.repository.SegmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SegmentServiceImpl implements SegmentService {

  private final SegmentRepository repository;
private final ModelMapper

  @Override
  public Optional<Segment> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Segment> findAll() {
    return repository.findAll();
  }

  @Override
  public Segment save(Segment segment) {
    return repository.save(segment);
  }

  @Override
  @Transactional
  public void setDeleted(Long id) {
     repository.findById(id).ifPresent(segment -> {
       segment.setDeleted(!segment.isDeleted());
       repository.save(segment);
     });
  }
}
