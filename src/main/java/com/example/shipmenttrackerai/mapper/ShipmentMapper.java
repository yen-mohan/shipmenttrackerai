package com.example.shipmenttrackerai.mapper;

import com.example.shipmenttrackerai.dto.ShipmentDTO;
import com.example.shipmenttrackerai.model.Shipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    ShipmentDTO toDTO(Shipment shipment);

    Shipment toEntity(ShipmentDTO dto);
}
