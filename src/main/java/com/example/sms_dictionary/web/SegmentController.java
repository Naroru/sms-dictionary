package com.example.sms_dictionary.web;

import com.example.sms_dictionary.model.segment.service.SegmentService;
import com.example.sms_dictionary.model.segment.service.dto.SegmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/segments")
@RequiredArgsConstructor
public class SegmentController {

private final SegmentService segmentService;

  @GetMapping("/{id}")
  public SegmentDto findById(@PathVariable long id) {
    return segmentService.findById(id);
  }

  @PostMapping()
  public SegmentDto save(@RequestBody SegmentDto dto){
    return segmentService.save(dto);
  }

  @GetMapping
  public List<SegmentDto> findAll(){
    return segmentService.findAll();
  }

  @GetMapping("/spec")
  public List<SegmentDto> findAllSpec(@RequestBody Specification<Segment> spec){
    return segmentService.findAll(spec);
  }

  @DeleteMapping("/{id}")
  public void setDeleted(@PathVariable long id){
    segmentService.setDeleted(id);
  }
}
