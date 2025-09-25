package edu.cit.diva.justinandry.campusequipmentloan.repository;

import edu.cit.diva.justinandry.campusequipmentloan.model.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {
}