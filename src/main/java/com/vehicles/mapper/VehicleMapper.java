package com.vehicles.mapper;

import com.vehicles.dto.VehicleDTO;
import com.vehicles.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDto(Vehicle entity) {
        if (entity == null) return null;
        VehicleDTO dto = new VehicleDTO();
        dto.setId(entity.getId());
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setVehicleYear(entity.getVehicleYear());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) return null;
        Vehicle entity = new Vehicle();
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setVehicleYear(dto.getVehicleYear());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public static void updateEntityFromDto(VehicleDTO dto, Vehicle entity) {
        if (dto == null || entity == null) return;
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setVehicleYear(dto.getVehicleYear());
        entity.setPrice(dto.getPrice());
    }
}