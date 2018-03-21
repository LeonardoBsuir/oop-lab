package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.common.model.Player;
import oop.lab.common.model.Team;
import oop.lab.users.dao.PlayerDAO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayerJsonDAOImpl implements PlayerDAO {


    public List<Player> findByTeamByTeamId_TeamId(Long teamId) {
        List<Player> players = new ArrayList<Player>(findAll());
        List<Player> players1 = new ArrayList<Player>();
        for (Player player : players) {
            if (teamId.equals(player.getTeamByTeamId().getTeamId())) {
                players1.add(player);
            }
        }
        return players1;
    }

    public void updatePlayer(String firstName, String lastName, String position, String photo, Timestamp birthdate, Long weight, Long height, Long salary, Long cost, Team team, String foot, Long playerId) {
        Player player = findOne(playerId);
        delete(player);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPosition(position);
        player.setPhoto(photo);
        player.setBirthdate(birthdate);
        player.setWeight(weight);
        player.setHeight(height);
        player.setSalary(salary);
        player.setCost(cost);
        player.setTeamByTeamId(team);
        player.setFoot(foot);
        player.setPlayerId(playerId);
        save(player);
    }

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/players.json";

    public <S extends Player> S save(S entity) {
        List<Player> players = new ArrayList<Player>(findAll());
        players.add(entity);
        saveAll(players);
        return entity;
    }


    public Player findOne(Long primaryKey) {
        List<Player> players = new ArrayList<Player>(findAll());
        for (Player player1 : players) {
            if (primaryKey.equals(player1.getPlayerId())) {
                return player1;
            }
        }
        return null;
    }


    public List<Player> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Player> players = null;
        try {
            players = Arrays.asList(mapper.readValue(new File(PATH), Player[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    public Long count() {
        List<Player> players = new ArrayList<Player>(findAll());
        return Long.valueOf(Integer.toString(players.size()));
    }


    public void delete(Player entity) {
        List<Player> players = new ArrayList<Player>(findAll());
        players.remove(entity);
        saveAll(players);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Player> players) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

