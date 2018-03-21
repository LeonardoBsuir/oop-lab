package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.common.model.User;
import oop.lab.users.dao.UserDAO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserJsonDAOImpl implements UserDAO {

    public List<User> findByTeamByTeamId_TeamId(Long teamId) {
        List<User> users = new ArrayList<User>(findAll());
        List<User> users1 = new ArrayList<User>();
        for (User user : users) {
            if (teamId.equals(user.getTeamByTeamId().getTeamId())) {
                users1.add(user);
            }
        }
        return users1;
    }

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/users.json";

    public <S extends User> S save(S entity) {
        List<User> users = new ArrayList<User>(findAll());
        users.add(entity);
        saveAll(users);
        return entity;
    }


    public User findOne(Long primaryKey) {
        List<User> users = new ArrayList<User>(findAll());
        for (User user1 : users) {
            if (primaryKey.equals(user1.getUserId())) {
                return user1;
            }
        }
        return null;
    }


    public List<User> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = null;
        try {
            users = Arrays.asList(mapper.readValue(new File(PATH), User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Long count() {
        List<User> users = new ArrayList<User>(findAll());
        return Long.valueOf(Integer.toString(users.size()));
    }


    public void delete(User entity) {
        List<User> users = new ArrayList<User>(findAll());
        users.remove(entity);
        saveAll(users);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<User> users) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
