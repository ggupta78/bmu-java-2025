package com.bmu.app;

import com.bmu.data.Student;
import com.bmu.service.EnrollmentService;

public class Main {
  public static void main(String[] args) {
    Student student1 = new Student("Alice", 101, "Computer Science");
    EnrollmentService service = new EnrollmentService();
    service.enrollStudent(student1);

    // Accessing the fields directly from another package
    System.out.println("Main: The student's major is " + student1.major);
  }
}
