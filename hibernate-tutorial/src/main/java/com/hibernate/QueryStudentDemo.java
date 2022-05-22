package com.hibernate;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List theStudents = session.createQuery("from Student").getResultList();

//            extracted(theStudents);

            theStudents = session.createQuery("from Student where id = :studentId").setParameter("studentId", 6).getResultList();

//            extracted(theStudents);

            theStudents = session.createQuery("from Student where id > :studentId").setParameter("studentId", 5).getResultList();

            extracted(theStudents);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void extracted(List theStudents) {
        for (Object tempStudent : theStudents) {
            System.out.println("Student: " + tempStudent);
        }
    }
}
