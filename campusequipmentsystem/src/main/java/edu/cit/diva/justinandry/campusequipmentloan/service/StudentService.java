package edu.cit.diva.justinandry.campusequipmentloan.service;

import edu.cit.diva.justinandry.campusequipmentloan.repository.StudentRepository;
import edu.cit.diva.justinandry.campusequipmentloan.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentModel getById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    public void save(StudentModel student) {
        if (studentRepository.findByStudentNo(student.getStudentNo()) != null) {
            throw new IllegalStateException("Student already exists with student number: " + student.getStudentNo());
        }
        studentRepository.save(student);
    }

    public StudentModel getByStudentNo(String studentNo) {
        return studentRepository.findByStudentNo(studentNo);
    }
}