package entities;
import enums.EventStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDate date;
    private String location;
    @Column(name = "maxParticipants")
    private int maxParticipants;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
    @OneToMany(mappedBy = "event")
    private List<User> listPartecipants ;

}


