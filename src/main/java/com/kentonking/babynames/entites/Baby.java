package com.kentonking.babynames.entites;

import javax.persistence.*;

@Entity
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int birthYear;
    private String gender;
    private String name;
    private int totalBirths;
    private int ranking;
    private int decade;

    public Baby() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBirthYear() { return birthYear; }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalBirths() {
        return totalBirths;
    }

    public void setTotalBirths(int totalBirths) {
        this.totalBirths = totalBirths;
    }

    public int getRanking() { return ranking; }

    public void setRanking(int ranking) { this.ranking = ranking; }

    public int getDecade() { return decade; }

    public void setDecade(int decade) { this.decade = decade; }

    @Override
    public String toString() {
        return "Baby{" +
                "id=" + id +
                ", birthYear=" + birthYear +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", totalBirths=" + totalBirths +
                ", ranking=" + ranking +
                ", decade=" + decade +
                '}';
    }
}
