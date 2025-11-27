package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.entity.Vehicle;
import com.example.demo.mapper.VehicleMapper;
import com.example.demo.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<Vehicle> entities = service.findAll();
        List<VehicleDTO> dtos = entities.stream()
                .map(VehicleMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        return service.findById(id)
                .map(VehicleMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody VehicleDTO vehicleDto) {
        Vehicle entity = VehicleMapper.toEntity(vehicleDto);
        Vehicle saved = service.save(entity);
        VehicleDTO resultDto = VehicleMapper.toDto(saved);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(resultDto);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long id,
                                                    @Valid @RequestBody VehicleDTO updatedDto) {

        return service.findById(id)
                .map(existing -> {
                    VehicleMapper.updateEntityFromDto(updatedDto, existing);
                    Vehicle saved = service.save(existing);
                    return ResponseEntity.ok(VehicleMapper.toDto(saved));
                }).orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        return service.findById(id)
                .map(v -> {
                    service.delete(id);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("home");
    }
    
}