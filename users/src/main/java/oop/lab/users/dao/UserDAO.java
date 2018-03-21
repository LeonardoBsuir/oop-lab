package oop.lab.users.dao;


import oop.lab.common.dao.BaseDAO;
import oop.lab.common.model.User;

import java.util.List;


public interface UserDAO extends BaseDAO<User, Long> {
    List<User> findByTeamByTeamId_TeamId(Long teamId);


}
