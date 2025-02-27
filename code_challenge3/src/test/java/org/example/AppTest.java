package org.example;

import department.Department;
import department.Student;
import org.junit.jupiter.api.*;

import java.util.HashMap;


public class AppTest {

    @Test
    public void addStudentAddedPrevoiusly() {

        // Create department and map for test
        Department d = new Department();
        HashMap<Student, Integer> students = new HashMap<>();

        Student s1 = new Student("John", "Doe");
        Student s2 = new Student("Oscar", "de Leon");
        Student s3 = new Student("Jose", "Perez");

        students.put(s1, 98);
        students.put(s2, 61);
        students.put(s3, 75);

        d.setStudents(students);

        // Create new student for test
        Student newStudent = new Student("John", "Doe");

        // Call method
        d.addStudent(newStudent, 100);

        // Asert
        Assertions.assertEquals(3, students.size());
    }

    @Test
    public void addStudentSuccess() {
        // Create department and map for test
        Department d = new Department();
        HashMap<Student, Integer> students = new HashMap<>();

        Student s1 = new Student("John", "Doe");
        Student s2 = new Student("Oscar", "de Leon");
        Student s3 = new Student("Jose", "Perez");

        students.put(s1, 98);
        students.put(s2, 61);
        students.put(s3, 75);

        d.setStudents(students);

        // Create a new student for thest
        Student newStudent = new Student("John", "Marston");

        // Call method
        d.addStudent(newStudent, 100);

        // Asert
        Assertions.assertEquals(4, students.size());
    }
}
