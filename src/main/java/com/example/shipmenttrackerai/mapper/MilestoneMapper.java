package com.example.shipmenttrackerai.mapper;

import com.example.shipmenttrackerai.dto.MilestoneDTO;
import com.example.shipmenttrackerai.dto.ShipmentDTO;
import com.example.shipmenttrackerai.model.Milestone;
import com.example.shipmenttrackerai.model.Shipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MilestoneMapper {

    MilestoneMapper INSTANCE = Mappers.getMapper(MilestoneMapper.class);

    MilestoneDTO toDTO(Milestone milestone);

    Milestone toEntity(MilestoneDTO dto);
}
