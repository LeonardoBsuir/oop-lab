package oop.lab.users.dao;


import oop.lab.common.model.Team;

public interface TeamDAO extends BaseDAO<Team, Long> {
    Team findByCountryOrderByNameAsc(String country);
}
