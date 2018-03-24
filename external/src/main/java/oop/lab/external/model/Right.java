package oop.lab.external.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Right")
public class Right implements Serializable {
    private long rightId;
    private String type;

    public long getRightId() {
        return rightId;
    }

    public void setRightId(long rightId) {
        this.rightId = rightId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Right right = (Right) o;

        if (rightId != right.rightId) return false;
        if (type != null ? !type.equals(right.type) : right.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rightId ^ (rightId >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Right{" +
                "rightId=" + rightId +
                ", type='" + type + '\'' +
                '}';
    }
}
