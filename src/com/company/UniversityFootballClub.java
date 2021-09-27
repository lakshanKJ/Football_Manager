package com.company;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {

    private String uniName;
    private int uFCWins;
    private int uFCDraws;
    private int uFCDefeats;
    private int uFCGoalsReceived;
    private int uFCGoalsScored;
    private int uFCPoints;
    private int uFCMatchesPlayed;

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public int getuFCWins() {
        return uFCWins;
    }

    public void setuFCWins(int uFCWins) {
        this.uFCWins = uFCWins;
    }

    public int getuFCDraws() {
        return uFCDraws;
    }

    public void setuFCDraws(int uFCDraws) {
        this.uFCDraws = uFCDraws;
    }

    public int getuFCDefeats() {
        return uFCDefeats;
    }

    public void setuFCDefeats(int uFCDefeats) {
        this.uFCDefeats = uFCDefeats;
    }

    public int getuFCGoalsReceived() {
        return uFCGoalsReceived;
    }

    public void setuFCGoalsReceived(int uFCGoalsReceived) {
        this.uFCGoalsReceived = uFCGoalsReceived;
    }

    public int getuFCGoalsScored() {
        return uFCGoalsScored;
    }

    public void setuFCGoalsScored(int uFCGoalsScored) {
        this.uFCGoalsScored = uFCGoalsScored;
    }

    public int getuFCPoints() {
        return uFCPoints;
    }

    public void setuFCPoints(int uFCPoints) {
        this.uFCPoints = uFCPoints;
    }

    public int getuFCMatchesPlayed() {
        return uFCMatchesPlayed;
    }

    public void setuFCMatchesPlayed(int uFCMatchesPlayed) {
        this.uFCMatchesPlayed = uFCMatchesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return uFCWins == that.uFCWins &&
                uFCDraws == that.uFCDraws &&
                uFCDefeats == that.uFCDefeats &&
                uFCGoalsReceived == that.uFCGoalsReceived &&
                uFCGoalsScored == that.uFCGoalsScored &&
                uFCPoints == that.uFCPoints &&
                uFCMatchesPlayed == that.uFCMatchesPlayed &&
                uniName.equals(that.uniName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniName, uFCWins, uFCDraws, uFCDefeats, uFCGoalsReceived, uFCGoalsScored, uFCPoints, uFCMatchesPlayed);
    }

    public int compareTo(UniversityFootballClub universityFootballClub){
        return this.uFCPoints-universityFootballClub.uFCPoints;
    }
}
