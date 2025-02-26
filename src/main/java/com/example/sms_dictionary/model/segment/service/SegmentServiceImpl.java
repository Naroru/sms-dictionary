package com.example.sms_dictionary.model.segment.service;

import com.example.sms_dictionary.common.SpecificationBuilder;
import com.example.sms_dictionary.common.searchcriteria.SearchCriteria;
import com.example.sms_dictionary.model.segment.entity.Segment;
import com.example.sms_dictionary.model.segment.service.dto.SegmentDto;
import com.example.sms_dictionary.repository.SegmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SegmentServiceImpl implements SegmentService {

  private final SegmentRepository repository;
  private final ModelMapper modelMapper;
  private final SpecificationBuilder<Segment> specificationBuilder;

  @Override
  public SegmentDto findById(Long id) {
    return repository.findById(id)
        .map(segment -> modelMapper.map(segment, SegmentDto.class))
        .orElseThrow(() -> new EntityNotFoundException("Segment with id " + id + " not found"));
  }

  @Override
  public List<SegmentDto> findAll() {
    return repository.findAll()
        .stream()
        .map(segment -> modelMapper.map(segment,SegmentDto.class))
        .toList();
  }

  @Override
  public List<SegmentDto> findBySearchCriteria(SearchCriteria searchCriteria) {
    return repository.findAll(specificationBuilder.createSpecification(searchCriteria))
        .stream()
        .map(segment -> modelMapper.map(segment, SegmentDto.class))
        .toList();
  }

  @Override
  public SegmentDto save(SegmentDto dto) {
    Segment segment = modelMapper.map(dto, Segment.class);
    return modelMapper.map(repository.save(segment),SegmentDto.class);

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
