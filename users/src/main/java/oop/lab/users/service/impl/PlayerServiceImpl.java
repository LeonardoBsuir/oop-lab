package oop.lab.users.service.impl;


import oop.lab.common.model.Player;
import oop.lab.users.dao.PlayerDAO;
import oop.lab.users.dao.SkillsDAO;
import oop.lab.users.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private static final Long DEFAULT_VALUE = 0L;

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private SkillsDAO skillsDAO;

    public void delete(Long id) {
        Player player = findOne(id);
        playerDAO.delete(player);
        skillsDAO.delete(player.getSkillsBySkillsId());
    }

    public List<Player> findAll() {
        return (List<Player>) playerDAO.findAll();
    }
    
    public Player findOne(Long id) {
        return playerDAO.findOne(id);
    }

    public Player save(Player entity) {
        if (entity.getSkillsBySkillsId().getSkillsId() == DEFAULT_VALUE) {
            skillsDAO.save(entity.getSkillsBySkillsId());
        }
        return playerDAO.save(entity);
    }

    public List<Player> findAll(Long teamId) {
        List<Player> players;
        if (teamId != null) {
            players = playerDAO.findByTeamByTeamId_TeamId(teamId);
        } else players = findAll();
        return players;
    }

    public Player updatePlayer(Player player, Long id) {
        if (player.getSkillsBySkillsId().getSkillsId() == DEFAULT_VALUE) {
            skillsDAO.save(player.getSkillsBySkillsId());
        }
        return updatePlayerFromPlayer(player);
    }


    private Player updatePlayerFromPlayer(Player player) {
        playerDAO.updatePlayer(player.getFirstName(), player.getLastName(), player.getPosition(), player.getPhoto(), player.getBirthdate(), player.getWeight(), player.getHeight(), player.getSalary(), player.getCost(), player.getTeamByTeamId(), player.getFoot(), player.getPlayerId());
        return player;
    }

}
