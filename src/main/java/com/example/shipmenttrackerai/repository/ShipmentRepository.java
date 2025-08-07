package com.example.shipmenttrackerai.repository;

import com.example.shipmenttrackerai.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;


/*
This layer abstracts database operations.
We use Spring Data JPA to interact with PostgreSQL, so the ShipmentRepository extends JpaRepository, allowing us to perform
CRUD operations (create, read, update, delete) on the Shipment entity without writing boilerplate SQL.
 */
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
