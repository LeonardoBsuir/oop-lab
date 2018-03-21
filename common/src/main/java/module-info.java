module common {
        requires java.sql;
        requires jackson.annotations;

        exports oop.lab.common.model;
        exports oop.lab.common.dao;
        exports oop.lab.common.service;
}