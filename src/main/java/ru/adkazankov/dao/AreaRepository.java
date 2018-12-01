package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
}
