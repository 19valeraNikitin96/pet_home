package app.repository.user.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private PersonEntity personEntity;
    private List<NotificationEntity> notifications;
}
