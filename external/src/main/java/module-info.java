module external {
        requires java.sql;
        requires java.xml.bind;
        requires spring.beans;

        exports oop.lab.external.dao;
        exports oop.lab.external.model;
        }