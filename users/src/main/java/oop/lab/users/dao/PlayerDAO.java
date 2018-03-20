package oop.lab.users.dao;


import oop.lab.common.model.Team;
import oop.lab.common.model.Player;

import java.sql.Timestamp;
import java.util.List;

public interface PlayerDAO extends BaseDAO<Player, Long> {
    List<Player> findByTeamByTeamId_TeamId(Long teamId);

     void updatePlayer(String firstName, String lastName, String position, String photo, Timestamp birthdate, Long weight, Long height, Long salary, Long cost, Team team, String foot, Long playerId);

}

