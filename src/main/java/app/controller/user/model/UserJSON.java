package app.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJSON {
    private String firstname;
    private String lastname;
    @JsonProperty("phone-numbers")
    private List<String> phoneNumbers;
    @JsonProperty("email-addresses")
    private List<String> emailAddresses;
    private String username;
    private String password;
    private List<NotificationJSON> notifications;
    @JsonProperty("location-id")
    private Integer locationId;
}
