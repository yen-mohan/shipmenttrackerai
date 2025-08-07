package com.example.shipmenttrackerai.service;

import com.example.shipmenttrackerai.dto.MilestoneDTO;
import com.example.shipmenttrackerai.mapper.MilestoneMapper;
import com.example.shipmenttrackerai.model.Milestone;
import com.example.shipmenttrackerai.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MilestoneService {

    private final MilestoneRepository repo;
    private final MilestoneMapper milestoneMapper;

    public MilestoneService(MilestoneRepository repo, MilestoneMapper milestoneMapper) {
        this.repo = repo;
        this.milestoneMapper = milestoneMapper;
    }

    public List<MilestoneDTO> getAllMilestone() {
        return repo.findAll().stream()
                .map(milestoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MilestoneDTO> getAllActiveMilestone() {
        return repo.findAll().stream()
                .filter(ms -> ms.getStatus().equalsIgnoreCase("InActive"))
                .map(milestoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<MilestoneDTO> getMilestoneByCategory(String category) {
        return repo.findAll().stream()
                .filter(ms -> ms.getCategory().equalsIgnoreCase(category))
                .map(milestoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MilestoneDTO createMilestone(MilestoneDTO milestoneDTO) {
        Milestone milestone = milestoneMapper.toEntity(milestoneDTO);
        return milestoneMapper.toDTO(repo.save(milestone));
    }

    public MilestoneDTO updateMilestone(Long id, MilestoneDTO updatedDTO) {
        return repo.findById(id).map(existing -> {
            existing.setMilestoneName(updatedDTO.getMilestoneName());
            existing.setCategory(updatedDTO.getCategory());
            existing.setStatus(updatedDTO.getStatus());
            return milestoneMapper.toDTO(repo.save(existing));
        }).orElseThrow(() -> new RuntimeException("Milestone not found"));
    }

    public void deleteMilestone(Long id) {
        repo.deleteById(id);
    }

    public Optional<MilestoneDTO> getMilestoneById(Long id) {
        return repo.findById(id)
                .map(milestoneMapper::toDTO);
    }
}
