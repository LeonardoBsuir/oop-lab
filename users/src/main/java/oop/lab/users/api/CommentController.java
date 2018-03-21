package oop.lab.users.api;


import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;
import oop.lab.users.service.CommentService;
import oop.lab.users.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/scouting/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{playerId}")
    public List<Comment> findAll(@PathVariable Long playerId) {
        Player player = playerService.findOne(playerId);
        return commentService.findAllCommentsByPlayer(player);
    }

    @GetMapping("/{playerId}/{id}")
    public Comment findOne(@PathVariable Long id) {
        return commentService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@RequestBody @Valid Comment comment) {
        return commentService.save(comment);
    }

    @DeleteMapping("/{playerId}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}
