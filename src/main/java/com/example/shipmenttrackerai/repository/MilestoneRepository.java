package com.example.shipmenttrackerai.repository;

import com.example.shipmenttrackerai.model.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
