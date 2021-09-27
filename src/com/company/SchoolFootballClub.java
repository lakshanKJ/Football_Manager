package com.company;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub {

    private String schoolName;
    private int sFCWins;
    private int sFCDraws;
    private int sFCDefeats;
    private int sFCGoalsReceived;
    private int sFCGoalsScored;
    private int sFCPoints;
    private int sFCMatchesPlayed;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getsFCWins() {
        return sFCWins;
    }

    public void setsFCWins(int sFCWins) {
        this.sFCWins = sFCWins;
    }

    public int getsFCDraws() {
        return sFCDraws;
    }

    public void setsFCDraws(int sFCDraws) {
        this.sFCDraws = sFCDraws;
    }

    public int getsFCDefeats() {
        return sFCDefeats;
    }

    public void setsFCDefeats(int sFCDefeats) {
        this.sFCDefeats = sFCDefeats;
    }

    public int getsFCGoalsReceived() {
        return sFCGoalsReceived;
    }

    public void setsFCGoalsReceived(int sFCGoalsReceived) {
        this.sFCGoalsReceived = sFCGoalsReceived;
    }

    public int getsFCGoalsScored() {
        return sFCGoalsScored;
    }

    public void setsFCGoalsScored(int sFCGoalsScored) {
        this.sFCGoalsScored = sFCGoalsScored;
    }

    public int getsFCPoints() {
        return sFCPoints;
    }

    public void setsFCPoints(int sFCPoints) {
        this.sFCPoints = sFCPoints;
    }

    public int getsFCMatchesPlayed() {
        return sFCMatchesPlayed;
    }

    public void setsFCMatchesPlayed(int sFCMatchesPlayed) {
        this.sFCMatchesPlayed = sFCMatchesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return sFCWins == that.sFCWins &&
                sFCDraws == that.sFCDraws &&
                sFCDefeats == that.sFCDefeats &&
                sFCGoalsReceived == that.sFCGoalsReceived &&
                sFCGoalsScored == that.sFCGoalsScored &&
                sFCPoints == that.sFCPoints &&
                sFCMatchesPlayed == that.sFCMatchesPlayed &&
                schoolName.equals(that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName, sFCWins, sFCDraws, sFCDefeats, sFCGoalsReceived, sFCGoalsScored, sFCPoints, sFCMatchesPlayed);
    }

    public int compareTo(SchoolFootballClub schoolFootballClub){
        return this.sFCPoints-schoolFootballClub.sFCPoints;
    }
}
