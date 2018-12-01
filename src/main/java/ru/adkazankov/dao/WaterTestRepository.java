package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.WaterTest;

public interface WaterTestRepository extends JpaRepository<WaterTest, Long> {
}
