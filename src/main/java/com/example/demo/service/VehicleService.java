package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    
    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id);
    }

    
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

   
    public void delete(Long id) {
        repository.deleteById(id);
    }
        
}

