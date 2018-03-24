package oop.lab.dao.xml;

import oop.lab.admin.dao.RoleDAO;
import oop.lab.common.model.Role;
import oop.lab.common.model.Roles;
import oop.lab.common.util.MyQualifier;
import oop.lab.external.dao.XmlReader;
import oop.lab.external.model.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений on 22.03.2018.
 */
@Component
@MyQualifier
public class RoleXmlDAOImplAdapter implements RoleDAO{

    @Autowired
    XmlReader xmlReader;

    private static final String PATH = "D:/Univer/oop-lab/external/src/main/resources/xml/rights.xml";

    public <S extends Role> S save(S entity) {
        List<Role> roles = new ArrayList<Role>(findAll());
        List<Role> rolesDel = new ArrayList<Role>();
        for (Role role : roles) {
            if (role.getRoleId() == entity.getRoleId()) {
                rolesDel.add(role);
            }
        }
        roles.removeAll(rolesDel);
        roles.add(entity);
        saveAll(roles);
        return entity;
    }


    public Role findOne(Long primaryKey) {
        List<Role> roles = new ArrayList<Role>(findAll());
        for (Role role1 : roles) {
            if (primaryKey.equals(role1.getRoleId())) {
                return role1;
            }
        }
        return null;
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            Rights rights = xmlReader.readFromFile(new File(PATH));
            roles = UtilTransformer.rightsToRoles(rights);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Long count() {
        List<Role> roles = new ArrayList<Role>(findAll());
        return Long.valueOf(Integer.toString(roles.size()));
    }


    public void delete(Role entity) {
        List<Role> roles = new ArrayList<Role>(findAll());
        roles.remove(entity);
        saveAll(roles);
    }

    public boolean exists(Long primaryKey) {
        return findOne(primaryKey) != null;
    }

    private void saveAll(List<Role> roles) {
        Roles roles1 = new Roles();
        roles1.setRoles(roles);
        try {
            Rights rights = UtilTransformer.rolesToRights(roles1);
            xmlReader.writeToFile(new File(PATH), rights);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
