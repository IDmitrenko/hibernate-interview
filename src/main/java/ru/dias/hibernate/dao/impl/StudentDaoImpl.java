package ru.dias.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.dias.hibernate.dao.StudentDao;
import ru.dias.hibernate.exception.CBaseDAOException;
import ru.dias.hibernate.persistence.entities.Student;
import ru.dias.hibernate.utils.HibernateSession;

import java.util.List;
import java.util.UUID;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student findById(UUID id) throws CBaseDAOException {
        Session session = null;
        Transaction tx = null;
        Student student = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            student = session.get(Student.class, id);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public void save(Student student) throws CBaseDAOException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Student student) throws CBaseDAOException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Student student) throws CBaseDAOException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.delete(student);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Student> findAll() throws CBaseDAOException {
        List<Student> students = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            students = (List<Student>) session
                    .createQuery("From Student ").list();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }

    @Override
    public Student findByName(String name) throws CBaseDAOException {
        Session session = null;
        Transaction tx = null;
        Student student = null;
        try {
            session = HibernateSession.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            student = session
                    .createQuery("SELECT s FROM Student s WHERE s.name = :nameStudent",
                            Student.class)
                    .setParameter("nameStudent", name)
                    .getSingleResult();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw new CBaseDAOException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }

}
