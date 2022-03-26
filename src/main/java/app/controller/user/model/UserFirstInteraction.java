package app.controller.user.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserFirstInteraction {
    private String firstname;
    private String username;
}
