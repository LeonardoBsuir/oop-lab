package oop.lab.users.service.impl;


import oop.lab.common.model.Skills;
import oop.lab.users.dao.SkillsDAO;
import oop.lab.users.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsDAO skillsDAO;

    public void delete(Long id) {
        Skills skills = skillsDAO.findOne(id);
        skillsDAO.delete(skills);
    }

    public List<Skills> findAll() {
        return (List<Skills>) skillsDAO.findAll();
    }


    public Skills findOne(Long id) {
        return skillsDAO.findOne(id);
    }


    public Skills save(Skills entity) {
        return skillsDAO.save(entity);
    }



    public Skills update(Skills skills) {
        skillsDAO.updateSkills(skills.getShooting(), skills.getPassing(), skills.getDribbling(), skills.getDefence(), skills.getSpeed(), skills.getEnergy(), skills.getStamina(), skills.getSkillsId());
        return skills;
    }
}
