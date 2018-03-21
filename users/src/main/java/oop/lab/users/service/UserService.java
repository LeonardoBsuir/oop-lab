package oop.lab.users.service;


import oop.lab.common.model.User;
import oop.lab.common.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findAll(Long teamId);

    void addPlayerToUser(Long playerId, Long userId);

    void delPlayerToUser(Long playerId, Long userId);

}
