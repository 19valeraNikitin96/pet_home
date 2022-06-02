package app.repository.advertisement.model;

import app.repository.date.model.DateEntity;
import app.repository.location.model.LocationEntity;
import app.repository.user.model.UserEntity;
import lombok.*;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import java.util.List;

@Entity
@Table(name = "ADVERTISEMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AdvertisementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "pet_name")
    private String petName;
    @ElementCollection
    @CollectionTable(name = "ANIMAL_SIGNS", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "sign") // 3
    private List<String> signs;
    @Column(name = "age")
    private Integer age;
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "location_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private LocationEntity location;
    @JoinColumn(name = "date_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private DateEntity date;
    @JoinColumn(name = "owner_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity owner;
}
