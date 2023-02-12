package org.example;

import org.example.ParsingClasses.*;
import org.example.Tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /*new branch*/

        String[] listStudent = ReadDump.getLineDump("data/dump.sql", "Students");
        for (String str : listStudent) {
            Student st = new Student();
            StudentsDump.doStudents(session, st, str);
        }

        String[] listSubscriptions = ReadDump.getLineDump("data/dump.sql", "Subscription");
        for (String str : listSubscriptions) {
            SubscriptionsDump.doSubscriptions(session, str);
        }

        String[] listPurchaseList = ReadDump.getLineDump("data/dump.sql", "PurchaseList");
        for (String str : listPurchaseList) {
            PurchaseListDump.doPurchaseList(session, str);
        }

        String[] listTeachers = ReadDump.getLineDump("data/dump.sql", "Teachers");
        for (String str : listTeachers) {
            Teacher st = new Teacher();
            TeachersDump.doTeachers(session, st, str);
        }

        String[] listCourses = ReadDump.getLineDump("data/dump.sql", "Courses");
        for (String str : listCourses) {
            Course st = new Course();
            CoursesDump.doCourse(session, st, str);
        }

        session.getTransaction().commit();
        sessionFactory.close();
    }
}
