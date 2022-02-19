package app.controller.advertisement.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagedJSON {
    private Integer current;
    private Integer size;
}
