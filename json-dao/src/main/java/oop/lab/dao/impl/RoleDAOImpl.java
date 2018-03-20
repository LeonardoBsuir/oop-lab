package oop.lab.dao.impl;


import oop.lab.users.dao.RoleDAO;
import oop.lab.common.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDAOImpl implements RoleDAO {

    public <S extends Role> S save(S entity) {
        return null;
    }

    public Role findOne(Long primaryKey) {
        return null;
    }

    public Iterable<Role> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(Role entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}
