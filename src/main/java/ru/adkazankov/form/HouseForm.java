package ru.adkazankov.form;

import lombok.Data;
import ru.adkazankov.dao.AreaRepository;
import ru.adkazankov.domain.Area;
import ru.adkazankov.domain.House;


@Data
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
        house.setAddress(address);
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
