module users {
        requires spring.web;
        requires spring.tx;
        requires java.sql;
        requires common;

        exports oop.lab.users.dao;
        exports oop.lab.users.service;
        exports oop.lab.users.api;
}