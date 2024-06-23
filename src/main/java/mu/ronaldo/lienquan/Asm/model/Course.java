package mu.ronaldo.lienquan.Asm.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @NotEmpty(message = "Nơi học không được để trống")
    private String place;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime startDate;

    @Transient
    @NotEmpty(message = "Start date is required")
    private String startDateStr;

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Category is required")
    @Valid
    private Category category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    @NotNull(message = "Lecture ID is required")
    private User lecture;

    public @NotNull(message = "Lecture ID is required") User getLecture() {
        return lecture;
    }

    public void setLecture(@NotNull(message = "Lecture ID is required") User lecture) {
        this.lecture = lecture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public @NotEmpty(message = "Nơi học không được để trống") String getPlace() {
        return place;
    }

    public void setPlace(@NotEmpty(message = "Nơi học không được để trống") String place) {
        this.place = place;
    }

    public @NotNull(message = "Category is required") @Valid Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull(message = "Category is required") @Valid Category category) {
        this.category = category;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
