package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@ToString

@Entity
@Table(name="house")
public class House {

    @Column(name = "address")
    private String address;

    @Column(name = "street_prefix")
    private String streetPrefix;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "building")
    private String building;

    @Column(name = "year")
    private int year;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Список всех комментариев к дому,
    //Spring JPA сам проинициализирует все поля, включая это
    @JsonProperty
    @OneToMany(mappedBy = "house")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;



    public House(String address, String streetPrefix, String streetName, String building, Area area, int year) {
        this.address = address;
        this.streetPrefix = streetPrefix;
        this.streetName = streetName;
        this.building = building;
        this.area = area;
        this.year = year;
    }

    public House() {

    }
}
