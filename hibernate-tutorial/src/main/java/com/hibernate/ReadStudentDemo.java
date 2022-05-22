package com.hibernate;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffu", "Wall", "test@test.test");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(student);

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("\nGetting the student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete: " + myStudent);

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
