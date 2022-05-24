package com.hibernate;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {

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

           int studentId = 2;
           Student tempStudent = session.get(Student.class, studentId);

           System.out.println("\n\nStudent: " + tempStudent);
           System.out.println("Courses: " + tempStudent.getCourses());

           Course tempCourse1 = new Course("Java asdasd");
           Course tempCourse2 = new Course("Java asdasdxbc");

           tempCourse1.addStudent(tempStudent);
           tempCourse2.addStudent(tempStudent);

            System.out.println("Save the courses");

            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }
    }

}





