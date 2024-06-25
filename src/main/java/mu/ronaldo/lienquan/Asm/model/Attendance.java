/*
package mu.ronaldo.lienquan.Asm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendance")
@IdClass(AttendancePK.class)
public class Attendance {

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


    @Id
    @ManyToOne
    @JoinColumn(name = "attendee", nullable = false)
    private User attendee;


}
*/
