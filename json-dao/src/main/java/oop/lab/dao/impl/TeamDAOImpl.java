package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.users.dao.TeamDAO;
import oop.lab.common.model.Team;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class TeamDAOImpl implements TeamDAO {

    public Team findByCountryOrderByNameAsc(String country) {
        return null;
    }


    public <S extends Team> S save(S entity) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("/json/teams.json"), entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }


    public Team findOne(Long primaryKey) {
        ObjectMapper mapper = new ObjectMapper();
        Team team = null;
        try {
            team =  mapper.readValue(new File("D:/Univer/test/src/main/resources/json/team.json"),Team.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return team;
    }


    public Iterable<Team> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Team> teams = null;
        try {
            teams = Arrays.asList(mapper.readValue(new File("D:/Univer/oop-lab/json-dao/src/main/resources/json/teams.json"),Team[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public Long count() {
        return null;
    }


    public void delete(Team entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}
