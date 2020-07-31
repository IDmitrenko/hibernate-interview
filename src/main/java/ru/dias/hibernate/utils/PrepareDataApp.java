package ru.dias.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareDataApp {

    private static final String NAME_PREPARATION_FILE = "prepareData.sql";
    public static void forcePrepareData() {

        SessionFactory factory = HibernateSession.getSessionFactory();

        Session session = null;
        try {
            String sql = Files.lines(Paths.get(NAME_PREPARATION_FILE))
                    .collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        forcePrepareData();
    }
}