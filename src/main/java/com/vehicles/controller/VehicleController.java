package com.vehicles.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vehicles.dto.VehicleDTO;
import com.vehicles.interfaces.VehicleControllerInterface;
import com.vehicles.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController implements VehicleControllerInterface {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }
    
    @Override
    public ResponseEntity<VehicleDTO> getVehicleById(Long id) {
        return vehicleService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @Override
    public ResponseEntity<VehicleDTO> createVehicle(VehicleDTO vehicleDTO) {
        VehicleDTO createDTO = vehicleService.save(vehicleDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vehicleDTO.getId())
                .toUri();
        
        return ResponseEntity.created(location).body(vehicleDTO);
    }

    public ResponseEntity<VehicleDTO> updateVehicle(Long id, VehicleDTO updatedDto) {
        VehicleDTO updated = vehicleService.update(id, updatedDto);

        if (updated == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteVehicle(Long id) {
        return vehicleService.findById(id)
                .map(v -> {
                    vehicleService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
