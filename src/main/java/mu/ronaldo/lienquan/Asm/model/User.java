package mu.ronaldo.lienquan.Asm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Username is required")
    private String userName;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public @NotEmpty(message = "Username is required") String getUserName() {
        return userName;
    }

    public void setUserName(@NotEmpty(message = "Username is required") String userName) {
        this.userName = userName;
    }

    public @NotEmpty(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password is required") String password) {
        this.password = password;
    }
}
