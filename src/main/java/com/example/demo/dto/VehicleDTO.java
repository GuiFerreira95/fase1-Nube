package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VehicleDTO {

    private Long id;

    @NotBlank(message = "brand é obrigatório")
    private String brand;

    @NotBlank(message = "model é obrigatório")
    private String model;

    @NotNull(message = "vehicleYear é obrigatório")
    @Positive(message = "vehicleYear deve ser positivo")
    private Integer vehicleYear;

    @NotNull(message = "price é obrigatório")
    @Positive(message = "price deve ser positivo")
    private Double price;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getVehicleYear() { return vehicleYear; }
    public void setVehicleYear(Integer vehicleYear) { this.vehicleYear = vehicleYear; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}