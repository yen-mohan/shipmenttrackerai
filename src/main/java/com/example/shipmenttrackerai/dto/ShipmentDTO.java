package com.example.shipmenttrackerai.dto;

import java.time.LocalDateTime;

public class ShipmentDTO {

    private Long id;
    private String origin;
    private String destination;
    private String status;
    private String trackingNumber;
    private LocalDateTime estimatedDelivery;

    // Constructors
    public ShipmentDTO() {}

    public ShipmentDTO(Long id, String origin, String destination, String status, String trackingNumber, LocalDateTime estimatedDelivery) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.trackingNumber = trackingNumber;
        this.estimatedDelivery = estimatedDelivery;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public LocalDateTime getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDateTime estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
}
