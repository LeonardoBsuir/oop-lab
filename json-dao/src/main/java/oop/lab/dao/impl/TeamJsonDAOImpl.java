package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.common.model.Team;
import oop.lab.users.dao.TeamDAO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TeamJsonDAOImpl implements TeamDAO {

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/teams.json";

    public Team findByCountryOrderByNameAsc(String country) {
        List<Team> teams = new ArrayList<Team>(findAll());
        for (Team team1 : teams) {
            if (country.equals(team1.getCountry())) {
                return team1;
            }
        }
        return null;
    }


    public <S extends Team> S save(S entity) {
        List<Team> teams = new ArrayList<Team>(findAll());
        List<Team> teamsDel = new ArrayList<Team>();
        for (Team team : teams) {
            if (team.getTeamId() == entity.getTeamId()) {
                teamsDel.add(team);
            }
        }
        teams.removeAll(teamsDel);
        teams.add(entity);
        saveAll(teams);
        return entity;
    }


    public Team findOne(Long primaryKey) {
        List<Team> teams = new ArrayList<Team>(findAll());
        for (Team team1 : teams) {
            if (primaryKey.equals(team1.getTeamId())) {
                return team1;
            }
        }
        return null;
    }


    public List<Team> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Team> teams = null;
        try {
            teams = Arrays.asList(mapper.readValue(new File(PATH), Team[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public Long count() {
        List<Team> teams = new ArrayList<Team>(findAll());
        return Long.valueOf(Integer.toString(teams.size()));
    }


    public void delete(Team entity) {
        List<Team> teams = new ArrayList<Team>(findAll());
        teams.remove(entity);
        saveAll(teams);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Team> teams) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), teams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
