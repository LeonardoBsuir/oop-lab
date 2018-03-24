package oop.lab.users.service.impl;


import oop.lab.common.model.Player;
import oop.lab.common.model.User;
import oop.lab.users.dao.PlayerDAO;
import oop.lab.users.dao.UserDAO;
import oop.lab.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PlayerDAO playerDAO;


    public void delete(Long id) {
        User user = userDAO.findOne(id);
        userDAO.delete(user);
    }


    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }


    public List<User> findAll(Long teamId) {
        List<User> users;
        if (teamId != null) {
            users = userDAO.findByTeamByTeamId_TeamId(teamId);
        } else users = findAll();
        return users;
    }

    public void addPlayerToUser(Long playerId, Long userId) {
        Player player = playerDAO.findOne(playerId);
        User user = userDAO.findOne(userId);
        user.getPlayers().add(player);
        //player.getUsers().add(user);
        userDAO.save(user);
        //playerDAO.save(player);
    }


    public void delPlayerToUser(Long playerId, Long userId) {
        Player player = playerDAO.findOne(playerId);
        User user = userDAO.findOne(userId);
        user.getPlayers().remove(player);
        //player.getUsers().remove(user);
        userDAO.save(user);
        //playerDAO.save(player);
    }


    public User findOne(Long id) {
        return userDAO.findOne(id);
    }


    public User save(User entity) {
        return userDAO.save(entity);
    }

}
