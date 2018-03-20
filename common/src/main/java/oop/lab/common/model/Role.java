package oop.lab.common.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private long roleId;
    private String type;
    private Set<User> usersByRoleId = new HashSet<>(0);

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

        Role role = (Role) o;

        if (roleId != role.roleId) return false;
        if (type != null ? !type.equals(role.type) : role.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public Set<User> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Set<User> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", type='" + type + '\'' +
                ", usersByRoleId=" + usersByRoleId +
                '}';
    }
}
