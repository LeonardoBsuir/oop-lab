package oop.lab.users.dao;


import oop.lab.common.dao.BaseDAO;
import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;

import java.util.List;

public interface CommentDAO extends BaseDAO<Comment, Long> {
    List<Comment> findByPlayerByPlayerIdOrderByCommentIdDesc(Player player);
}
