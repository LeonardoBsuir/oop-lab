package oop.lab.common.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


public class Player implements Serializable {
    private long playerId;
    private String firstName;
    private String lastName;
    private String position;
    private Timestamp birthdate;
    private Set<Comment> commentsByPlayerId = new HashSet<>(0);
    private Skills skillsBySkillsId;
    private Team teamByTeamId;
    private Set<User> users = new HashSet<>(0);
    private Long weight;
    private Long height;
    private Long salary;
    private Long cost;
    private String foot;
    private String photo;


    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerId != player.playerId) return false;
        if (firstName != null ? !firstName.equals(player.firstName) : player.firstName != null) return false;
        if (lastName != null ? !lastName.equals(player.lastName) : player.lastName != null) return false;
        if (position != null ? !position.equals(player.position) : player.position != null) return false;
        if (birthdate != null ? !birthdate.equals(player.birthdate) : player.birthdate != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (playerId ^ (playerId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }

    public Set<Comment> getCommentsByPlayerId() {
        return commentsByPlayerId;
    }

    public void setCommentsByPlayerId(Set<Comment> commentsByPlayerId) {
        this.commentsByPlayerId = commentsByPlayerId;
    }

    public Skills getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(Skills skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }

    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", birthdate=" + birthdate +
                ", commentsByPlayerId=" + commentsByPlayerId +
                ", skillsBySkillsId=" + skillsBySkillsId +
                ", teamByTeamId=" + teamByTeamId +
                ", users=" + users +
                ", weight=" + weight +
                ", height=" + height +
                ", salary=" + salary +
                ", cost=" + cost +
                ", foot='" + foot + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
