package com.example.shipmenttrackerai.dto;

public class MilestoneDTO {

    private Long id;
    private String milestoneName;
    private String category;
    private String status;

    // Constructors
    public MilestoneDTO() {}

    public MilestoneDTO(Long id, String milestoneName, String category, String status) {
        this.id = id;
        this.milestoneName = milestoneName;
        this.category = category;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
