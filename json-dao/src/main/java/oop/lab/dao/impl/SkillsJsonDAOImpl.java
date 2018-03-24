package oop.lab.dao.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import oop.lab.common.model.Skills;
import oop.lab.users.dao.SkillsDAO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SkillsJsonDAOImpl implements SkillsDAO {


    public void updateSkills(Long shooting, Long passing, Long dribbling, Long defence, Long speed, Long energy, Long stamina, Long skillsId) {
        Skills skills = findOne(skillsId);
        delete(skills);
        skills.setShooting(shooting);
        skills.setPassing(passing);
        skills.setDribbling(dribbling);
        skills.setDefence(defence);
        skills.setSpeed(speed);
        skills.setEnergy(energy);
        skills.setStamina(stamina);
        skills.setSkillsId(skillsId);
        save(skills);
    }

    private static final String PATH = "D:/Univer/oop-lab/json-dao/src/main/resources/json/skills.json";

    public <S extends Skills> S save(S entity) {
        List<Skills> skillses = new ArrayList<Skills>(findAll());
        List<Skills> skillsDel = new ArrayList<Skills>();
        for (Skills skills : skillses) {
            if (skills.getSkillsId() == entity.getSkillsId()) {
                skillsDel.add(skills);
            }
        }
        skillses.removeAll(skillsDel);
        skillses.add(entity);
        saveAll(skillses);
        return entity;
    }


    public Skills findOne(Long primaryKey) {
        List<Skills> skills = new ArrayList<Skills>(findAll());
        for (Skills skills1 : skills) {
            if (primaryKey.equals(skills1.getSkillsId())) {
                return skills1;
            }
        }
        return null;
    }


    public List<Skills> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Skills> skills = null;
        try {
            skills = Arrays.asList(mapper.readValue(new File(PATH), Skills[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    }

    public Long count() {
        List<Skills> skills = new ArrayList<Skills>(findAll());
        return Long.valueOf(Integer.toString(skills.size()));
    }


    public void delete(Skills entity) {
        List<Skills> skills = new ArrayList<Skills>(findAll());
        skills.remove(entity);
        saveAll(skills);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Skills> skills) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(PATH), skills);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
