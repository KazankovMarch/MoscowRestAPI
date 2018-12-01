package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.List;

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

    public Area(String name) {
        this.name = name;
    }

    public Area() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", tests=" + tests +
                '}';
    }
}
