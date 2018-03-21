package oop.lab.users.service;


import oop.lab.common.model.Skills;
import oop.lab.common.service.BaseService;

public interface SkillsService extends BaseService<Skills, Long> {
    Skills update(Skills skills);
}
