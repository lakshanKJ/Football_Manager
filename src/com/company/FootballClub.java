package com.company;

import java.util.Objects;

public abstract class FootballClub extends SportsClub{

    private String wins;
    private String draws;
    private String defeats;
    private int goalsScored;
    private int points;
    private int matchesPlayed;

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getDefeats() {
        return defeats;
    }

    public void setDefeats(String defeats) {
        this.defeats = defeats;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return goalsScored == that.goalsScored &&
                points == that.points &&
                matchesPlayed == that.matchesPlayed &&
                wins.equals(that.wins) &&
                draws.equals(that.draws) &&
                defeats.equals(that.defeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, draws, defeats, goalsScored, points, matchesPlayed);
    }

    public int compareTo(FootballClub footballClub){
        return this.points-footballClub.points;
    }
}
