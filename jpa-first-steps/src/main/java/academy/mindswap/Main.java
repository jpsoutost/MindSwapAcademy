package academy.mindswap;

import academy.mindswap.services.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.createOrUpdateStudent(2, "OLIVEIRA", 4);
        studentService.createOrUpdateStudent(3, "OLIVEIRA", 4);
        studentService.printStudentById(1);
        studentService.printAllStudents();
    }
}
