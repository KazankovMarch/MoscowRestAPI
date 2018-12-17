package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@ToString

@Entity
@Table(name = "water")
public class WaterTest {

    @Column(name = "type_name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "res_val")
    private String resVal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public WaterTest(String name, Area area, String resVal) {
        this.name = name;
        this.area = area;
        this.resVal = resVal;
    }

    public WaterTest() {
    }
}
