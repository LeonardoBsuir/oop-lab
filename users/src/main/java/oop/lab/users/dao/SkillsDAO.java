package oop.lab.users.dao;


import oop.lab.common.model.Skills;

public interface SkillsDAO extends BaseDAO<Skills, Long> {

    void updateSkills(Long shooting, Long passing, Long dribbling, Long defence, Long speed, Long energy, Long stamina, Long skillsId);

}
