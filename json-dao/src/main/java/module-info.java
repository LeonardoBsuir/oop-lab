module json.dao {
        requires spring.beans;
        requires spring.context;
        requires java.sql;
        requires users;
        requires common;

        exports oop.lab.dao.impl;
}