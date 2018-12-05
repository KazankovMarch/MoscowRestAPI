package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "area")
@Entity
@Table(name = "noise")
public class NoiseReport {

    @Column(name = "source")
    private String source;
    @Column(name = "results")
    private String results;
    @Column(name = "address")
    private String address;
    @Column(name = "checkdate")
    private String checkdate;
    @Column(name = "numrequests")
    private int requestsCount;
    @Column(name = "changes")
    private String changes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;


}
