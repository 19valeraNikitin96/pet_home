package app.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementRequestJSON {
    @JsonProperty("user-id")
    private Integer userId;
    private String pov;
    private PagedJSON paged;
}
