package app.repository.activation.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVATIONS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ActivationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "token", nullable = false, unique = true)
    private String token;
}
