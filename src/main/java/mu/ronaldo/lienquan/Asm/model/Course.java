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
    @NotEmpty(message = "Tên trợ giảng không được để trống")
    private String lectureName;
    @NotEmpty(message = "Nơi học không được để trống")
    private String place;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime startDate;
    @Transient
    @NotEmpty(message = "Start date is required")
    private String startDateStr;

    @OneToMany(mappedBy = "course")
    private List<Attendance> attendees;

   /* @OneToOne
    @JoinColumn(name = "lecture_id")
    private User lecture;
    public List<Attendance> getAttendees() {
        return attendees;
    }*/

   /* public void setAttendees(List<Attendance> attendees) {
        this.attendees = attendees;
    }*/

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    @ManyToOne
    @JoinColumn(name="category_id")
    @NotNull(message = "Category is required")
    @Valid
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Tên trợ giảng không được để trống") String getLectureName() {
        return lectureName;
    }

    public void setLectureName(@NotEmpty(message = "Tên trợ giảng không được để trống") String lectureName) {
        this.lectureName = lectureName;
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
}



