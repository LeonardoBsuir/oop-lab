package oop.lab.users.service;


import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;
import oop.lab.common.service.BaseService;

import java.util.List;

public interface CommentService extends BaseService<Comment, Long> {

    List<Comment> findAllCommentsByPlayer(Player player);

}
