module xml.dao {
        requires java.sql;
        requires java.xml.bind;
        requires spring.beans;
        requires admin;
        requires common;
        requires external;

        exports oop.lab.dao.xml;
}