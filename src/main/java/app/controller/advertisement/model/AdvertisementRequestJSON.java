package app.controller.advertisement.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementRequestJSON {
    private String pov;
    private PagedJSON paged;
}
