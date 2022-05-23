package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // print the instructor details
            System.out.println("tempInstructor: " + tempInstructor);

            // print the courses
            System.out.println("tempInstructor's Courses: ");
            for (Course tempCourse : tempInstructor.getCourses()) {
                System.out.println(" * " + tempCourse);
            }

            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }
    }

}





