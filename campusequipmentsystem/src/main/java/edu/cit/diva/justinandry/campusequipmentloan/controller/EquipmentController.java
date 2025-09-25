package edu.cit.diva.justinandry.campusequipmentloan.controller;

import edu.cit.diva.justinandry.campusequipmentloan.service.EquipmentService;
import edu.cit.diva.justinandry.campusequipmentloan.model.EquipmentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public ResponseEntity<?> addEquipment(@RequestBody EquipmentModel equipment) {
        try {
            equipmentService.save(equipment);
            return ResponseEntity.ok(Map.of(
                    "message", "Equipment added successfully.",
                    "id", equipment.getId(),
                    "name", equipment.getName(),
                    "type", equipment.getType(),
                    "serialNumber", equipment.getSerialNumber(),
                    "availability", equipment.isAvailability()
            ));
        } catch (IllegalStateException e) {
            return ResponseEntity.ok(Map.of(
                    "error", e.getMessage(),
                    "name", equipment.getName(),
                    "type", equipment.getType(),
                    "serialNumber", equipment.getSerialNumber()
            ));
        }
    }


    @GetMapping
    public ResponseEntity<List<EquipmentModel>> getAllEquipment() {
        return ResponseEntity.ok(equipmentService.getAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<EquipmentModel>> getAvailableEquipment() {
        List<EquipmentModel> available = equipmentService.getAll().stream()
                .filter(EquipmentModel::isAvailability)
                .collect(Collectors.toList());

        return ResponseEntity.ok(available);
    }
}
