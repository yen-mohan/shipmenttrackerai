package com.example.shipmenttrackerai.controller;

import com.example.shipmenttrackerai.dto.ShipmentDTO;
import com.example.shipmenttrackerai.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    // GET all shipments
    @GetMapping
    public List<ShipmentDTO> getAllShipments() {
        return service.getAllShipments();
    }

    // GET shipment by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShipmentDTO> getShipment(@PathVariable Long id) {
        return service.getShipmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE a new shipment
    @PostMapping
    public ResponseEntity<ShipmentDTO> createShipment(@RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO created = service.createShipment(shipmentDTO);
        return ResponseEntity.ok(created);
    }

    // UPDATE an existing shipment
    @PutMapping("/{id}")
    public ResponseEntity<ShipmentDTO> updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDTO) {
        ShipmentDTO updated = service.updateShipment(id, shipmentDTO);
        return ResponseEntity.ok(updated);
    }

    // DELETE shipment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        service.deleteShipment(id);
        return ResponseEntity.noContent().build();
    }
}
