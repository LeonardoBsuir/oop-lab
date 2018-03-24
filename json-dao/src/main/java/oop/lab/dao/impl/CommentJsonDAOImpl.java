package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.common.model.Comment;
import oop.lab.common.model.Player;
import oop.lab.users.dao.CommentDAO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CommentJsonDAOImpl implements CommentDAO {


    public List<Comment> findByPlayerByPlayerIdOrderByCommentIdDesc(Player player) {
        List<Comment> comments = new ArrayList<Comment>(findAll());
        List<Comment> comments1 = new ArrayList<Comment>();
        for (Comment comment : comments) {
            if (player.getPlayerId() == comment.getPlayerByPlayerId().getPlayerId()) {
                comments1.add(comment);
            }
        }
        return comments1;
    }

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/comments.json";

    public <S extends Comment> S save(S entity) {
        List<Comment> comments = new ArrayList<Comment>(findAll());
        List<Comment> commentsDel = new ArrayList<Comment>();
        for (Comment comment : comments) {
            if (comment.getCommentId() == entity.getCommentId()) {
                commentsDel.add(comment);
            }
        }
        comments.removeAll(commentsDel);
        comments.add(entity);
        saveAll(comments);
        return entity;
    }


    public Comment findOne(Long primaryKey) {
        List<Comment> comments = new ArrayList<Comment>(findAll());
        for (Comment comment1 : comments) {
            if (primaryKey.equals(comment1.getCommentId())) {
                return comment1;
            }
        }
        return null;
    }


    public List<Comment> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Comment> comments = null;
        try {
            comments = Arrays.asList(mapper.readValue(new File(PATH), Comment[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public Long count() {
        List<Comment> comments = new ArrayList<Comment>(findAll());
        return Long.valueOf(Integer.toString(comments.size()));
    }


    public void delete(Comment entity) {
        List<Comment> comments = new ArrayList<Comment>(findAll());
        comments.remove(entity);
        saveAll(comments);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Comment> comments) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), comments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
