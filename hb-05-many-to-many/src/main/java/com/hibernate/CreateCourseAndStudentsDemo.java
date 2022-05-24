package com.hibernate;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            System.out.println("\n --- Creating new course and students ---");

            // create new course
            Course tempCourse = new Course("Java 101");

            System.out.println("\n Saving course: " + tempCourse);

            session.save(tempCourse);
            System.out.println("\n Course saved: " + tempCourse);

            Student tempStudent1 = new Student("John", "Smith", "test@test.test");
            Student tempStudent2 = new Student("Mary", "Public", "asd@asd.test");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("\n Saving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("\n Students saved: " + tempStudent1 + " " + tempStudent2);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }
    }

}





