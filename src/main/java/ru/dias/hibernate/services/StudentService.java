package ru.dias.hibernate.services;

import lombok.NoArgsConstructor;
import ru.dias.hibernate.dao.StudentDao;
import ru.dias.hibernate.dao.impl.StudentDaoImpl;
import ru.dias.hibernate.exception.CBaseDAOException;
import ru.dias.hibernate.persistence.entities.Student;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
public class StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    public Student findStudent(UUID id) throws CBaseDAOException {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) throws CBaseDAOException {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) throws CBaseDAOException {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) throws CBaseDAOException {
        studentDao.update(student);
    }

    public List<Student> findAllStudents() throws CBaseDAOException {
        return studentDao.findAll();
    }

    public Student findStudent(String name) throws CBaseDAOException {
        return studentDao.findByName(name);
    }
}
