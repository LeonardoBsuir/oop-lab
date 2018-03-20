package oop.lab.dao.impl;


import oop.lab.users.dao.UserDAO;
import oop.lab.common.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    public List<User> findByTeamByTeamId_TeamId(Long teamId) {
        return null;
    }

    public <S extends User> S save(S entity) {
        return null;
    }

    public User findOne(Long primaryKey) {
        return null;
    }

    public Iterable<User> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(User entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}
