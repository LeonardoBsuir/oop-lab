package oop.lab.users.service;


import oop.lab.common.model.Team;

public interface TeamService extends BaseService<Team, Long> {

    Team findByCountry(String country);
}
