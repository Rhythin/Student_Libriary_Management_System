package com.example.Student_Libriary_Management_System.Repository;

import com.example.Student_Libriary_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
