package mu.ronaldo.lienquan.Asm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Id
    @NotBlank(message="Attendee ID is required")
    private String attendeeId;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public @NotBlank(message = "Attendee ID is required") String getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(@NotBlank(message = "Attendee ID is required") String attendeeId) {
        this.attendeeId = attendeeId;
    }

    // Getters, setters, and other methods omitted for brevity
}
