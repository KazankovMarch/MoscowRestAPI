package ru.adkazankov.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "year")
    private int year;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
