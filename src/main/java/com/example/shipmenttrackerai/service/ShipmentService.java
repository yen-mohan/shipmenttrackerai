package com.example.shipmenttrackerai.service;

import com.example.shipmenttrackerai.dto.ShipmentDTO;
import com.example.shipmenttrackerai.mapper.ShipmentMapper;
import com.example.shipmenttrackerai.model.Shipment;
import com.example.shipmenttrackerai.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class handling business logic for Shipments.
 * Uses ShipmentDTO for clean API data transfer and decoupling.
 */
@Service
public class ShipmentService {

    private final ShipmentRepository repository;
    private final ShipmentMapper shipmentMapper;

    @Autowired
    public ShipmentService(ShipmentRepository repository, ShipmentMapper shipmentMapper) {
        this.repository = repository;
        this.shipmentMapper = shipmentMapper;
    }

    // Fetch all shipments and map them to DTOs
    public List<ShipmentDTO> getAllShipments() {
        return repository.findAll()
                .stream()
                .map(shipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get shipment by ID and map to DTO
    public Optional<ShipmentDTO> getShipmentById(Long id) {
        return repository.findById(id)
                .map(shipmentMapper::toDTO);
    }

    // Create a new shipment from DTO
    public ShipmentDTO createShipment(ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentMapper.toEntity(shipmentDTO);
        Shipment saved = repository.save(shipment);
        return shipmentMapper.toDTO(saved);
    }

    // Update an existing shipment
    public ShipmentDTO updateShipment(Long id, ShipmentDTO updatedDTO) {
        return repository.findById(id).map(existing -> {
            existing.setTrackingNumber(updatedDTO.getTrackingNumber());
            existing.setOrigin(updatedDTO.getOrigin());
            existing.setDestination(updatedDTO.getDestination());
            existing.setStatus(updatedDTO.getStatus());
            existing.setEstimatedDelivery(updatedDTO.getEstimatedDelivery());
            return shipmentMapper.toDTO(repository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Shipment not found with id " + id));
    }

    // Delete shipment by ID
    public void deleteShipment(Long id) {
        repository.deleteById(id);
    }
}
