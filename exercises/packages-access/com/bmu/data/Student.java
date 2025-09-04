package com.bmu.data;

public class Student {
  public String name;
  public int studentID;
  public String major;

  public Student(String name, int studentID, String major) {
    this.name = name;
    this.studentID = studentID;
    this.major = major;
  }

  public void displayStudentInfo() {
    System.out.println("Student: " + name + ", ID: " + studentID + ", Major: " + major);
  }
}
