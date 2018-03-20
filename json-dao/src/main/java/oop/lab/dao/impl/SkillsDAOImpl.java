package oop.lab.dao.impl;


import oop.lab.users.dao.SkillsDAO;
import oop.lab.common.model.Skills;
import org.springframework.stereotype.Component;

@Component
public class SkillsDAOImpl implements SkillsDAO {


    public void updateSkills(Long shooting, Long passing, Long dribbling, Long defence, Long speed, Long energy, Long stamina, Long skillsId) {

    }

    public <S extends Skills> S save(S entity) {
        return null;
    }

    public Skills findOne(Long primaryKey) {
        return null;
    }

    public Iterable<Skills> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(Skills entity) {

    }

    public boolean exists(Long primaryKey) {
        return false;
    }
}
