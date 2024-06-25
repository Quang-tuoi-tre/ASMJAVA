package mu.ronaldo.lienquan.Asm.Service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import mu.ronaldo.lienquan.Asm.Repository.CourseRepository;
import mu.ronaldo.lienquan.Asm.Repository.UserRepository;
import mu.ronaldo.lienquan.Asm.model.Course;
import mu.ronaldo.lienquan.Asm.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.*;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository; // Add the UserRepository

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    // Retrieve a Course by its id
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }/*
    public List<Course> findByLectureNameContaining(String lectureName) {
        return courseRepository.findByLectureNameContaining(lectureName);
    }*/
    public List<Course> getUpcomingCourses() {
        return courseRepository.findByStartDateAfter(LocalDateTime.now());
    }

    // Add a new Course to the database
    public Course addCourse(Course Course) {
        return courseRepository.save(Course);
    }

    public Course updateCourse(@NotNull Course course) {
        Course existingCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new IllegalStateException("Course with ID " +
                        course.getId() + " does not exist."));

        existingCourse.setPlace(course.getPlace());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setStartDateStr(course.getStartDateStr());
        /*User lecture = userRepository.findById(course.getLecture().getId())
                .orElseThrow(() -> new IllegalStateException("Lecture with ID " +
                        course.getLecture().getId() + " does not exist."));
        existingCourse.setLecture(lecture);*/
        return courseRepository.save(course);
    }
    public void deleteProductById(Long id) {
        Course product = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with ID " + id + " does not exist."));

        courseRepository.deleteById(id);
    }


}