package edu.cit.diva.justinandry.campusequipmentloan.repository;

import edu.cit.diva.justinandry.campusequipmentloan.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    StudentModel findByStudentNo(String studentNo);
}