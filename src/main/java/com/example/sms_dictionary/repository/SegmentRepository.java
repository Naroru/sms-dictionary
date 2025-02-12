package com.example.sms_dictionary.repository;

import com.example.sms_dictionary.model.segment.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
}
