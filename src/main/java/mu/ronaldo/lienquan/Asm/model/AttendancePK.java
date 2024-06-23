package mu.ronaldo.lienquan.Asm.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


public class AttendancePK implements Serializable {

    private int course;
    private int attendee;

    // Constructors, getters, setters, equals, and hashCode methods
    public AttendancePK() {
    }

    public AttendancePK(int course, int attendee) {
        this.course = course;
        this.attendee = attendee;
    }

    // Equals and hashCode (required for @IdClass)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendancePK that = (AttendancePK) o;
        return course == that.course &&
                attendee == that.attendee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, attendee);
    }
}