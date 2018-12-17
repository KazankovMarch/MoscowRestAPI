package ru.adkazankov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "house")

@Entity
@Table(name = "comment")
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;


    @Column(name = "grade_id")
    private int grade;

    @Column(name = "body")
    private String body;

}
