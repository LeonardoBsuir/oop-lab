package oop.lab.dao.impl;


import oop.lab.users.dao.PlayerDAO;
import oop.lab.common.model.Player;
import oop.lab.common.model.Team;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class PlayerDAOImpl implements PlayerDAO {


    public List<Player> findByTeamByTeamId_TeamId(Long teamId) {
        return null;
    }

    public void updatePlayer(String firstName, String lastName, String position, String photo, Timestamp birthdate, Long weight, Long height, Long salary, Long cost, Team team, String foot, Long playerId) {

    }

    public <S extends Player> S save(S entity) {
        return null;
    }

    public Player findOne(Long primaryKey) {
        return null;
    }

    public Iterable<Player> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(Player entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}

