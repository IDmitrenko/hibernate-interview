package ru.dias.hibernate;

import ru.dias.hibernate.exception.CBaseDAOException;
import ru.dias.hibernate.persistence.entities.Student;
import ru.dias.hibernate.services.StudentService;
import ru.dias.hibernate.utils.HibernateSession;

import java.util.List;
import java.util.UUID;

public class HibernateApp {

    public static void main(String[] args) throws CBaseDAOException {

        StudentService studentService = new StudentService();

        int mark;
        for (int i = 1; i < 1001; i++) {
            mark = i % 5;
            if (mark == 0) {
                mark = 5;
            } else {
                mark += 1;
            }
           Student student = new Student("Bob" + i, mark);
            studentService.saveStudent(student);
        }

        List<Student> allStudents = studentService.findAllStudents();

        Student student = allStudents.get(25);
        UUID id = student.getId();

        Student studentId = studentService.findStudent(id);

        studentId.setName("Bob Fisher");
        studentService.updateStudent(studentId);

        Student studentUpdate = studentService.findStudent(id);

        studentService.deleteStudent(studentUpdate);

        Student studentDelete = studentService.findStudent(id);
        if (studentDelete == null) {
            System.out.printf("Студент с id = %s удален из базы данных.%n", id);
        }

        String nameStudent = "Bob64";
        Student studentName = studentService.findStudent(nameStudent);

        nameStudent = "Bob2000";
        studentName.setName(nameStudent);
        studentService.updateStudent(studentName);

        Student studentNameUpdate = studentService.findStudent(nameStudent);

        HibernateSession.closeSessionFactory();

    }
}
