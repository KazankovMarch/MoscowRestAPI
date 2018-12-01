package ru.adkazankov.domain;

import javax.persistence.*;

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

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getStreetPrefix() {
        return streetPrefix;
    }

    public void setStreetPrefix(String streetPrefix) {
        this.streetPrefix = streetPrefix;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", streetPrefix='" + streetPrefix + '\'' +
                ", streetName='" + streetName + '\'' +
                ", building='" + building + '\'' +
                ", area=" + area +
                ", year=" + year +
                ", id=" + id +
                '}';
    }
}
