package entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Event;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"password", "authorities", "enabled", "credentialsNonExpired", "accountNonExpired", "accountNonLocked"})
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    @ManyToMany
    @JoinTable(name = "userEvents",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "eventId"))
    private List<Event> events;

}
