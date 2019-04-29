package ru.adkazankov.dao;

import ru.adkazankov.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> getTop10ByArea_NameContainsAndStreetNameContainsAndBuildingContains(String area, String streetName, String building);
}
