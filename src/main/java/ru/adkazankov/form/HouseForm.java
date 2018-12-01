package ru.adkazankov.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.adkazankov.HouseController;
import ru.adkazankov.dao.AreaRepository;
import ru.adkazankov.dao.HouseRepository;
import ru.adkazankov.domain.Area;
import ru.adkazankov.domain.House;

public class HouseForm {

    private AreaRepository areaRepository;

    private String address;

    private String streetPrefix;

    private String streetName;

    private String building;

    private Long area_id;

    private int year;

    private Long id = null;

    public HouseForm() {
    }

    public HouseForm(String address, String streetPrefix, String streetName, String building, Long area_id, int year) {
        this.address = address;
        this.streetPrefix = streetPrefix;
        this.streetName = streetName;
        this.building = building;
        this.area_id = area_id;
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
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
        return "HouseForm{" +
                "address='" + address + '\'' +
                ", streetPrefix='" + streetPrefix + '\'' +
                ", streetName='" + streetName + '\'' +
                ", building='" + building + '\'' +
                ", area_id=" + area_id +
                ", year=" + year +
                ", id=" + id +
                '}';
    }

    public House toHouse() {
        House house = new House();
        Area area = areaRepository.findById(area_id).get();
        house.setArea(area);
        house.setAdress(address);
        house.setBuilding(building);
        house.setStreetName(streetName);
        house.setStreetPrefix(streetPrefix);
        house.setYear(year);
        house.setId(id);
        return house;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
}