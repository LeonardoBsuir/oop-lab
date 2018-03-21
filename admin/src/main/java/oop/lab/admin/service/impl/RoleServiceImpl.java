package oop.lab.admin.service.impl;

import oop.lab.admin.dao.RoleDAO;
import oop.lab.admin.service.RoleService;
import oop.lab.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public void delete(Long id) {
        Role role = roleDAO.findOne(id);
        roleDAO.delete(role);
    }

    public List<Role> findAll() {
        return (List<Role>) roleDAO.findAll();
    }

    public Role findOne(Long id) {
        return roleDAO.findOne(id);
    }

    public Role save(Role entity) {
        return roleDAO.save(entity);
    }

}
