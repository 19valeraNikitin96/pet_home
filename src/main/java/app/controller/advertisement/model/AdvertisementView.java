package app.controller.advertisement.model;

import app.controller.user.model.UserFirstInteraction;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AdvertisementView {
    private String petName;
    private LocationJSON location;
    private DateJSON date;
    private UserFirstInteraction user;
}
