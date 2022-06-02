package app.repository.user.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "person_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private PersonEntity person;
//    TODO add annotations
//    private List<NotificationEntity> notifications;
}
