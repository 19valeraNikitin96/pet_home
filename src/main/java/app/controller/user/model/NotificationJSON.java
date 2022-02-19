package app.controller.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationJSON {
    @JsonProperty("app")
    private String appName;
    private Integer frequency;
}
