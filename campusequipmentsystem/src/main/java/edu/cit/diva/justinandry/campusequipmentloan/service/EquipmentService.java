package edu.cit.diva.justinandry.campusequipmentloan.service;

import edu.cit.diva.justinandry.campusequipmentloan.repository.EquipmentRepository;
import edu.cit.diva.justinandry.campusequipmentloan.model.EquipmentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentModel getById(Long id) {
        return equipmentRepository.findById(id).orElseThrow();
    }

    public List<EquipmentModel> getAll() {
        return equipmentRepository.findAll();
    }

    public void save(EquipmentModel equipment) {
        boolean exists = equipmentRepository.findAll().stream()
                .anyMatch(e -> e.getSerialNumber().equalsIgnoreCase(equipment.getSerialNumber()));
        if (exists) {
            throw new IllegalStateException("Equipment already exists with serial number: " + equipment.getSerialNumber());
        }
        equipmentRepository.save(equipment);
    }


    public void updateAvailability(Long id, boolean available) {
        EquipmentModel eq = getById(id);
        eq.setAvailability(available);
        equipmentRepository.save(eq);
    }
}