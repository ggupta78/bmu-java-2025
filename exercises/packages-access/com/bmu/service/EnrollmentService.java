package com.bmu.service;

import com.bmu.data.Student;

public class EnrollmentService {
  public void enrollStudent(Student student) {
    System.out.println("Attempting to enroll " + student.name);
    student.displayStudentInfo();
  }
}
