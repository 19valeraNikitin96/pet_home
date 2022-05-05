package app.repository.messenger.model;

import app.repository.user.model.UserEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "seen")
    private Boolean seen;
    @JoinColumn(name = "sender_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity sender;
    @JoinColumn(name = "receiver_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity receiver;
}
