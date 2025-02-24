package com.example.sms_dictionary.repository;

import com.example.sms_dictionary.model.segment.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SegmentRepository extends JpaRepository<Segment, Long>, JpaSpecificationExecutor<Segment> {
}
