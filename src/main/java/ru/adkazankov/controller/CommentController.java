package ru.adkazankov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.dao.CommentRepository;
import ru.adkazankov.dao.HouseRepository;
import ru.adkazankov.domain.Comment;
import ru.adkazankov.domain.House;
import ru.adkazankov.form.CommentForm;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private HouseRepository houseRepository;


    @GetMapping
    public List<Comment> getAllComments(@PathVariable(name = "houseid") Long houseId) {
        return commentRepository.findByHouse_Id(houseId);
    }

    @GetMapping("/{id}")
    public Optional<Comment> getComment(@PathVariable(name = "id") Long id){
        return commentRepository.findById(id);
    }

    @PostMapping
    public Long postComment(@RequestBody CommentForm commentForm){
        Optional<House> house = houseRepository.findById(commentForm.getHouseId());
        if(house.isPresent()) {
            Comment comment = commentForm.toComment(null, house.get());
            commentRepository.save(comment);
            return comment.getId();
        }
        else {
            return null;
        }
    }

    @PutMapping("{id}")
    public boolean putComment(@PathVariable(name = "id") Long id, @RequestBody CommentForm commentForm){
        Optional<House> house = houseRepository.findById(commentForm.getHouseId());
        if(house.isPresent()) {
            Comment comment = commentForm.toComment(id, house.get());
            commentRepository.save(comment);
            return true;
        }
        else {
            return false;
        }
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable(name = "id") Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            commentRepository.delete(comment.get());
        }
    }

}
