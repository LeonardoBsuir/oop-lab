package oop.lab.dao.impl;


import oop.lab.users.dao.CommentDAO;
import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDAOImpl implements CommentDAO {


    public List<Comment> findByPlayerByPlayerIdOrderByCommentIdDesc(Player player) {
        return null;
    }

    public <S extends Comment> S save(S entity) {
        return null;
    }

    public Comment findOne(Long primaryKey) {
        return null;
    }

    public Iterable<Comment> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(Comment entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}
