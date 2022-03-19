package app.repository.user.model;

import app.repository.location.model.LocationEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONS")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @ElementCollection
    @CollectionTable(name = "PHONE_NUMBERS", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "phone_number") // 3
    private List<String> phoneNumbers;
    @ElementCollection
    @CollectionTable(name = "EMAIL_ADDRESSES", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "email_address") // 3
    private List<String> emailAddresses;
    @JoinColumn(name = "location_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private LocationEntity location;
}
