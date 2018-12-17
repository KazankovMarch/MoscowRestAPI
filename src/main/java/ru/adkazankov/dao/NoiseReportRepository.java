package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.NoiseReport;

import java.util.List;
import java.util.Optional;

public interface NoiseReportRepository extends JpaRepository<NoiseReport, Long> {

    List<NoiseReport> findAllByArea_id(Long id);

    Optional<NoiseReport> findByArea_idAndId(Long areaId, Long id);

}
