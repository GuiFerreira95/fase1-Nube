package com.vehicles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vehicles.dto.VehicleDTO;
import com.vehicles.entity.Vehicle;
import com.vehicles.mapper.VehicleMapper;
import com.vehicles.repository.VehicleRepository;


@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<VehicleDTO> findAll() {
        List<Vehicle> entitieVehicle = repository.findAll();
        return entitieVehicle.stream()
                .map(VehicleMapper::toDto)
                .toList();
    }

    public Optional<VehicleDTO> findById(Long id) {
    	return repository.findById(id).map(VehicleMapper::toDto);
        
    }

    public VehicleDTO save(VehicleDTO vehicleDTO) {
        Vehicle entitieVehicle = VehicleMapper.toEntity(vehicleDTO);
        Vehicle vehicleSaved = repository.save(entitieVehicle);
        return VehicleMapper.toDto(vehicleSaved);
    }
    
    public VehicleDTO update(Long id, VehicleDTO vehicleDTO) {
        return repository.findById(id)
                .map(existing -> {
                    VehicleMapper.updateEntityFromDto(vehicleDTO, existing);
                    Vehicle vehicleSaved = repository.save(existing);
                    return VehicleMapper.toDto(vehicleSaved);
                })
                .orElse(null);
    }

    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}