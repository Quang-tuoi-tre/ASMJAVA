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

import java.time.LocalDateTime;

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
//    @NotEmpty(message = "Tên trợ giảng không được để trống")
    private String lectureName;
//    @NotEmpty(message = "Nơi học không được để trống")
    private String place;
//    @NotEmpty(message = "Start date is required")
    private LocalDateTime startDate;



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



