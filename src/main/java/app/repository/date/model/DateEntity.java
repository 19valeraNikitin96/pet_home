package app.repository.date.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DATES")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "day")
    private Integer day;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
}
