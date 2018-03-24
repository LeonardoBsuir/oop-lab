module common {
        requires java.sql;
        requires jackson.annotations;
        requires java.xml.bind;

        exports oop.lab.common.model;
        exports oop.lab.common.dao;
        exports oop.lab.common.service;
        exports oop.lab.common.util;
}