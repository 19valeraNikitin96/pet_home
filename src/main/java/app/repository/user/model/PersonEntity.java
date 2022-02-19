package app.repository.user.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    private Integer id;
    private String firstname;
    private String lastname;
    private List<String> phoneNumbers;
    private List<String> emailAddresses;
    private Integer locationId;
}
