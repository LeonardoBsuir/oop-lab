package oop.lab.users.service.impl;


import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;
import oop.lab.users.dao.CommentDAO;
import oop.lab.users.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    public void delete(Long id) {
        Comment comment = commentDAO.findOne(id);
        commentDAO.delete(comment);
    }

    public List<Comment> findAll() {
        return (List<Comment>) commentDAO.findAll();
    }

    public Comment findOne(Long id) {
        return commentDAO.findOne(id);
    }

    public Comment save(Comment entity) {
        return commentDAO.save(entity);
    }


    public List<Comment> findAllCommentsByPlayer(Player player) {
        return commentDAO.findByPlayerByPlayerIdOrderByCommentIdDesc(player);
    }
}
