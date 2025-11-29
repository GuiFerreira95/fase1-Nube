package com.vehicles.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vehicles.dto.VehicleDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Vehicles", description = "CRUD operations for vehicles")
@RequestMapping("/vehicles")
public interface VehicleControllerInterface {

    @Operation(
            summary = "Get all vehicles",
            description = "Returns a list of all vehicles",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List returned successfully",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = VehicleDTO.class)
                                    )
                            )
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<VehicleDTO>> getAllVehicles();
    
    @Operation(
            summary = "Get vehicle by ID",
            description = "Returns a vehicle by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle found",
                            content = @Content(schema = @Schema(implementation = VehicleDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Vehicle not found"
                    )
            }
    )
    @GetMapping("/{id}")
    ResponseEntity<VehicleDTO> getVehicleById(
            @Parameter(description = "ID of the vehicle", example = "1")
            @PathVariable Long id
    );

    @Operation(
            summary = "Create a new vehicle",
            description = "Creates and returns a new vehicle",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Vehicle created",
                            content = @Content(schema = @Schema(implementation = VehicleDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request"
                    )
            }
    )
    @PostMapping
    ResponseEntity<VehicleDTO> createVehicle(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Vehicle data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = VehicleDTO.class))
            )
            @Valid @RequestBody VehicleDTO vehicleCreateDTO
    );

    @Operation(
            summary = "Update a vehicle",
            description = "Updates an existing vehicle",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Vehicle updated successfully",
                            content = @Content(schema = @Schema(implementation = VehicleDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Vehicle not found"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request"
                    )
            }
    )
    @PutMapping("/{id}")
    ResponseEntity<VehicleDTO> updateVehicle(
            @Parameter(description = "ID of the vehicle", example = "1")
            @PathVariable Long id,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Updated vehicle data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = VehicleDTO.class))
            )
            @Valid @RequestBody VehicleDTO updatedDto
    );

    @Operation(
            summary = "Delete a vehicle",
            description = "Deletes a vehicle by ID",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Vehicle deleted"
                    )
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVehicle(
            @Parameter(description = "ID of the vehicle to delete", example = "1")
            @PathVariable Long id
    );
}
