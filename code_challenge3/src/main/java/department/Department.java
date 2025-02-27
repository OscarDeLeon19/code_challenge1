package department;

import java.util.HashMap;

public class Department {

    private HashMap<Student, Integer> students = new HashMap<>();

    public Department() {
    }

    public HashMap<Student, Integer> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Student, Integer> students) {
        this.students = students;
    }

    /**
     * method to print each student and his mark
     */
    public void printStudents() {
        for (Student s : students.keySet()) {
            System.out.println(s.getName() + " " + s.getLastName() + ", Mark: " + students.get(s));
        }
    }

    /**
     * method to add a new student or replace one
     * @param s student to add
     * @param mark mark for the student to add
     */
    public void addStudent(Student s, Integer mark) {
        Student foundStudent = null;
        for (Student student : students.keySet()) {
            if (student.getLastName().equals(s.getLastName())) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            students.remove(foundStudent);
            students.put(s, mark);
        } else {
            students.put(s, mark);
        }

    }
}
