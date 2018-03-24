package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.admin.dao.RoleDAO;
import oop.lab.common.model.Role;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleJsonDAOImpl implements RoleDAO {

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/roles.json";
    
    public <S extends Role> S save(S entity) {
        List<Role> roles = new ArrayList<Role>(findAll());
        List<Role> rolesDel = new ArrayList<Role>();
        for (Role role : roles) {
            if (role.getRoleId() == entity.getRoleId()) {
                rolesDel.add(role);
            }
        }
        roles.removeAll(rolesDel);
        roles.add(entity);
        saveAll(roles);
        return entity;
    }


    public Role findOne(Long primaryKey) {
        List<Role> roles = new ArrayList<Role>(findAll());
        for (Role role1 : roles) {
            if (primaryKey.equals(role1.getRoleId())) {
                return role1;
            }
        }
        return null;
    }


    public List<Role> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Role> roles = null;
        try {
            roles = Arrays.asList(mapper.readValue(new File(PATH), Role[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Long count() {
        List<Role> roles = new ArrayList<Role>(findAll());
        return Long.valueOf(Integer.toString(roles.size()));
    }


    public void delete(Role entity) {
        List<Role> roles = new ArrayList<Role>(findAll());
        roles.remove(entity);
        saveAll(roles);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Role> roles) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), roles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
