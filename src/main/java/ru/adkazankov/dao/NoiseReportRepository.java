package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.NoiseReport;

public interface NoiseReportRepository extends JpaRepository<NoiseReport, Long> {
}
