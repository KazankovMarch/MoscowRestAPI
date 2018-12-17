package ru.adkazankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.adkazankov.domain.Comment;
import ru.adkazankov.domain.House;

import java.util.List;
import java.util.Optional;

//Spring JPA Сам реализует основные методы, такие как getById(Long id)
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //Не основные методы достаточно указать в соответствии
    //с правилами названий методов Spring JPA
    //JPA сам поймет, что от него требуется
    Optional<Comment> findByIdAndHouse(Long id, House house);
    Optional<Comment> findByIdAndHouse_id(Long id, Long houseId);
    List<Comment> findByHouse_Id(Long houseId);
}
