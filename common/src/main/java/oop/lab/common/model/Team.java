package oop.lab.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Team implements Serializable {
    private long teamId;
    private String name;
    private Set<Player> playersByTeamId = new HashSet<Player>(0);
    private Skills skillsBySkillsId;
    private Set<User> usersByTeamId = new HashSet<User>(0);
    private String country;
    private String photo;


    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != team.teamId) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamId ^ (teamId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    public Set<Player> getPlayersByTeamId() {
        return playersByTeamId;
    }

    public void setPlayersByTeamId(Set<Player> playersByTeamId) {
        this.playersByTeamId = playersByTeamId;
    }

    public Skills getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(Skills skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }

    @JsonIgnore
    public Set<User> getUsersByTeamId() {
        return usersByTeamId;
    }

    public void setUsersByTeamId(Set<User> usersByTeamId) {
        this.usersByTeamId = usersByTeamId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", name='" + name + '\'' +
                ", playersByTeamId=" + playersByTeamId +
                ", skillsBySkillsId=" + skillsBySkillsId +
                ", usersByTeamId=" + usersByTeamId +
                ", country='" + country + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
