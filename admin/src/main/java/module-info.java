module admin {
    requires spring.web;
    requires spring.beans;
    requires spring.context;
    requires common;

    exports oop.lab.admin.model;
    exports oop.lab.admin.service;
    exports oop.lab.admin.api;
}