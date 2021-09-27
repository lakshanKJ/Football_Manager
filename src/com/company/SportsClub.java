package com.company;

import java.util.Objects;

public abstract class SportsClub implements Comparable<SportsClub> {
    private String name;
    private String location;
    private int numberOfSports;
    private int titlesWon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfClubs() {
        return numberOfSports;
    }

    public void setNumberOfClubs(int numberOfClubs) {
        this.numberOfSports = numberOfClubs;
    }

    public int getTitlesWon() {
        return titlesWon;
    }

    public void setTitlesWon(int titlesWon) {
        this.titlesWon = titlesWon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return numberOfSports == that.numberOfSports &&
                titlesWon == that.titlesWon &&
                name.equals(that.name) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, numberOfSports, titlesWon);
    }

    @Override
    public int compareTo(SportsClub sportsClub){
        return this.numberOfSports-sportsClub.numberOfSports;
    }

}

