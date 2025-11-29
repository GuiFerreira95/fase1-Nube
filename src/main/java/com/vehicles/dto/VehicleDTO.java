package com.vehicles.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(
    name = "VehicleDTO",
    description = "Representa os dados de um veículo utilizados nas operações da API."
)
public class VehicleDTO {

    @Schema(
        description = "Identificador único do veículo",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Marca do veículo",
        example = "Toyota",
        required = true
    )
    @NotBlank(message = "brand é obrigatório")
    private String brand;

    @Schema(
        description = "Modelo do veículo",
        example = "Corolla",
        required = true
    )
    @NotBlank(message = "model é obrigatório")
    private String model;

    @Schema(
        description = "Ano do veículo",
        example = "2020",
        required = true
    )
    @NotNull(message = "vehicleYear é obrigatório")
    @Positive(message = "vehicleYear deve ser positivo")
    private Integer vehicleYear;

    @Schema(
        description = "Preço do veículo",
        example = "85000.00",
        required = true
    )
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
