package ru.adkazankov.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.adkazankov.domain.Comment;
import ru.adkazankov.domain.House;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentForm {

    private Long id;
    private Long houseId;
    private String body;
    private int grade;

    public Comment toComment(Long id, House house) {
        Comment comment = new Comment();
        comment.setGrade(grade);
        comment.setHouse(house);
        comment.setId(id);
        comment.setBody(body);
        return comment;
    }
}
