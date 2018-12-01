package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public WaterTest(String name, Area area, String resVal) {
        this.name = name;
        this.area = area;
        this.resVal = resVal;
    }

    public WaterTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResVal() {
        return resVal;
    }

    public void setResVal(String resVal) {
        this.resVal = resVal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "WaterTest{" +
                "name='" + name + '\'' +
                ", resVal='" + resVal + '\'' +
                ", id=" + id +
                '}';
    }
}
