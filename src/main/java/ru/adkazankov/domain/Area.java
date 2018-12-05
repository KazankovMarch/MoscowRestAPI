package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "area")
public class Area {

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonProperty
    @OneToMany(mappedBy = "area")
    private List<WaterTest> tests;

    @JsonProperty
    @OneToMany(mappedBy = "area")
    private List<NoiseReport> reports;

}
