package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.WaterTest;

import java.util.List;
import java.util.Optional;

public interface WaterTestRepository extends JpaRepository<WaterTest, Long> {

    List<WaterTest> findAllByArea_id(Long areaId);

    Optional<WaterTest> findByIdAndArea_id(Long id, Long areaId);

}
