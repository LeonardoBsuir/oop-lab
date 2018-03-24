package oop.lab.external.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Rights")
public class Rights {
    @XmlElement(name = "Right", type = Right.class)
    private List<Right> rights = new ArrayList<Right>();

    public Rights() {
    }

    public Rights(List<Right> rights) {
        this.rights = rights;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }
}
