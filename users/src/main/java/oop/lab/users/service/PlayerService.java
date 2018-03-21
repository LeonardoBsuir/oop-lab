package oop.lab.users.service;


import oop.lab.common.model.Player;
import oop.lab.common.service.BaseService;

import java.util.List;

public interface PlayerService extends BaseService<Player, Long> {

    List<Player> findAll(Long teamId);

    Player updatePlayer(Player player, Long id);

}


