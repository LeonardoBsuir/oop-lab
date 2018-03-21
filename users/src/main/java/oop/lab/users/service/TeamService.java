package oop.lab.users.service;


import oop.lab.common.model.Team;
import oop.lab.common.service.BaseService;

public interface TeamService extends BaseService<Team, Long> {

    Team findByCountry(String country);
}
