package oop.lab.users.service.impl;


import oop.lab.users.dao.PlayerDAO;
import oop.lab.users.dao.SkillsDAO;
import oop.lab.users.dao.TeamDAO;
import oop.lab.common.model.Player;
import oop.lab.common.model.Team;
import oop.lab.users.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private static final Long DEFAULT_SKILL = 99L;
    private static final Long DEFAULT_VALUE = 0L;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private SkillsDAO skillsDAO;

    @Autowired
    private PlayerDAO playerDAO;



    public void delete(Long id) {
        Team team = teamDAO.findOne(id);
        teamDAO.delete(team);
    }


    public List<Team> findAll() {
        List<Team> teams = (List<Team>) teamDAO.findAll();
        for (Team team : teams) {
            //recalculateTeamSkills(team);
        }
        return (List<Team>) teamDAO.findAll();
    }


    public Team findOne(Long id) {
        return teamDAO.findOne(id);
    }


    public Team save(Team entity) {
        if (entity.getSkillsBySkillsId() == null) {
            entity.setSkillsBySkillsId(skillsDAO.findOne(DEFAULT_SKILL));
        }
        return teamDAO.save(entity);
    }

    private void recalculateTeamSkills(Team team) {
        List<Player> players = playerDAO.findByTeamByTeamId_TeamId(team.getTeamId());
        Integer playersCount = players.size();
        Long teamSkillsId = team.getSkillsBySkillsId().getSkillsId();
        Long shooting = DEFAULT_VALUE;
        Long passing = DEFAULT_VALUE;
        Long dribbling = DEFAULT_VALUE;
        Long defence = DEFAULT_VALUE;
        Long speed = DEFAULT_VALUE;
        Long energy = DEFAULT_VALUE;
        Long stamina = DEFAULT_VALUE;
        if (playersCount != 0) {
            for (Player player1 : players) {
                shooting += player1.getSkillsBySkillsId().getShooting();
                passing += player1.getSkillsBySkillsId().getPassing();
                dribbling += player1.getSkillsBySkillsId().getDribbling();
                defence += player1.getSkillsBySkillsId().getDefence();
                speed += player1.getSkillsBySkillsId().getSpeed();
                energy += player1.getSkillsBySkillsId().getEnergy();
                stamina += player1.getSkillsBySkillsId().getStamina();
            }
            shooting = shooting / playersCount;
            passing = passing / playersCount;
            dribbling = dribbling / playersCount;
            defence = defence / playersCount;
            speed = speed / playersCount;
            energy = energy / playersCount;
            stamina = stamina / playersCount;
        }
        skillsDAO.updateSkills(shooting, passing, dribbling, defence, speed, energy, stamina, teamSkillsId);

    }

    public Team findByCountry(String country) {
        return teamDAO.findByCountryOrderByNameAsc(country);
    }
}
