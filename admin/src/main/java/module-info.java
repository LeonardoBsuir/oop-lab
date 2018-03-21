module admin {
    requires spring.web;
    requires spring.beans;
    requires spring.context;
    requires spring.tx;
    requires common;

    exports oop.lab.admin.dao;
    exports oop.lab.admin.service;
    exports oop.lab.admin.api;
}