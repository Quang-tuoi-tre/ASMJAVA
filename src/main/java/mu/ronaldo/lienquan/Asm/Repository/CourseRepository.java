package mu.ronaldo.lienquan.Asm.Repository;

import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
//    List<Course> findByLectureNameContaining(String lectureName);
    List<Course> findByStartDateAfter(LocalDateTime startDate);
/*Cannot resolve symbol 'LocalDateTime'
    Lỗi trong CourseRepository*/
}
