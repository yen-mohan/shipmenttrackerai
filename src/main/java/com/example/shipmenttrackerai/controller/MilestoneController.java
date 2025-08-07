package com.example.shipmenttrackerai.controller;

import com.example.shipmenttrackerai.dto.MilestoneDTO;
import com.example.shipmenttrackerai.service.MilestoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
This is the REST controller for Milestone object.
 */
@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

    private final MilestoneService service;

    public MilestoneController(MilestoneService service) {
        this.service = service;
    }

    @GetMapping
    public List<MilestoneDTO> getAllMilestones() {
        return service.getAllMilestone();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilestoneDTO> getMilestone(@PathVariable Long id) {
        return service.getMilestoneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MilestoneDTO> createMilestone(@RequestBody MilestoneDTO milestoneDTO) {
        MilestoneDTO created = service.createMilestone(milestoneDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilestoneDTO> updateMilestone(@PathVariable Long id, @RequestBody MilestoneDTO milestoneDTO) {
        try {
            MilestoneDTO updated = service.updateMilestone(id, milestoneDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMilestone(@PathVariable Long id) {
        service.deleteMilestone(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public List<MilestoneDTO> getActiveMilestones() {
        return service.getAllActiveMilestone();
    }

    @GetMapping("/cat/{category}")
    public List<MilestoneDTO> getMilestonesByCategory(@PathVariable String category) {
        return service.getMilestoneByCategory(category);
    }
}
