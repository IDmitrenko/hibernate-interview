package ru.dias.hibernate.dao;

import ru.dias.hibernate.exception.CBaseDAOException;
import ru.dias.hibernate.persistence.entities.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    Student findById(UUID id) throws CBaseDAOException;

    void save(Student student) throws CBaseDAOException;

    void update(Student student) throws CBaseDAOException;

    void delete(Student student) throws CBaseDAOException;

    List<Student> findAll() throws CBaseDAOException;

    Student findByName(String name) throws CBaseDAOException;
}
