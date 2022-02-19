package app.repository.user.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {
    private Integer id;
    private UserEntity userEntity;
    private String appName;
    private Integer frequency;
}
