package org.example.ParsingClasses;

import org.example.Tables.Course;
import org.example.Tables.CourseType;
import org.example.Tables.Student;
import org.example.Tables.Teacher;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoursesDump {
    public static void doStudents(Session session, Course st, String data) throws ParseException {
        String[] w = data.split(",");
        st.setName(w[1]);
        st.setDuration(Integer.parseInt(w[2]));
        CourseType courseType = CourseType.valueOf(w[3]);
        st.setType(courseType);
        st.setDescription(w[4]);
        Teacher teacher = new Teacher();
        st.setTeacher(teacher);
        if(w[6] == null) {
            st.setPrice(Integer.parseInt("0"));
        }else {
            st.setPrice(Integer.parseInt(w[7]));
        }
        st.setStudentsCount(Integer.parseInt(w[7]));
        st.setPricePerHour(Float.parseFloat(w[8]));



        session.persist(st);
    }
}

//(id, name, duration, type, description, teacher_id, students_count, price, price_per_hour)









//(id, description, duration, name, price, price_per_hour, students_count,type, teacher_id )
















