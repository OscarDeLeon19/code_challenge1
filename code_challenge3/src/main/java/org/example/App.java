package org.example;

import department.Department;
import department.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Department d = new Department();
        Student s = new Student("John", "Doe");
        Student s2 = new Student("Jane", "Does");
        Student s3 = new Student("Jack", "Doe");

        d.addStudent(s, 10);
        d.addStudent(s2, 10);
        d.addStudent(s3, 25);

        d.printStudents();

    }
}
