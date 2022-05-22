package com.hibernate;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("John", "Doe", "a@a.a");
            Student student2 = new Student("Mary", "Public", "aasd@afgh.acvb");
            Student student3 = new Student("Bonita", "Applebaum", "asd@avbn.adfg");

            session.beginTransaction();

            System.out.println("Saving the student...");

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
