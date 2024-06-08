package mu.ronaldo.lienquan.Asm.Service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mu.ronaldo.lienquan.Asm.Repository.CourseRepository;
import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;
    public List<Course> getAllCourse() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    // Retrieve a Course by its id
    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    // Add a new Course to the database
    public Course addCourse(Course Course) {
        return courseRepository.save(Course);
    }

    public Course updateCourse(@NotNull Course course) {
        Course existingCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new IllegalStateException("Course with ID " +
                        course.getId() + " does not exist."));

        existingCourse.setLectureName(course.getLectureName());
        existingCourse.setPlace(course.getPlace());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setStartDate(course.getStartDate());
        return courseRepository.save(existingCourse);
    }
    public void deleteProductById(Integer id) {
        Course product = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with ID " + id + " does not exist."));

        courseRepository.deleteById(id);
    }
}