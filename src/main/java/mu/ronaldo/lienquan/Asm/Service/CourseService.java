package mu.ronaldo.lienquan.Asm.Service;

import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.stereotype.Service;
import java.util.Arrays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> listCourse =new ArrayList<>();

    public void add(Course course) {
        listCourse.add(course);
    }

    public List<Course> GetAll() {
        return listCourse;
    }
    public String getMonthName(int monthValue){
        String[] monthNames = {"", "January", "February", "March","June","July","August","September","Octocber", "November","December" };
        return monthNames[monthValue];
    }
}