package part1;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitorList {
    private ArrayList<EgameCompetitor> competitorList;

    public CompetitorList() {
        competitorList = new ArrayList<EgameCompetitor>();
    }

    public void addCompetitor(EgameCompetitor competitor) {
        competitorList.add(competitor);
    }

    public ArrayList<EgameCompetitor> getCompetitorList() {
        return competitorList;
    }
    public int countCompetitors(){
        return competitorList.size();
    }

    public EgameCompetitor getHighestScoreCompetitor() {
        EgameCompetitor highestScoreCompetitor = competitorList.get(0);
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getOverallScore() > highestScoreCompetitor.getOverallScore()) {
                highestScoreCompetitor = competitor;
            }
        }
        return highestScoreCompetitor;
    }

    public double getAverageScore() {
        double totalScore = 0;
        for (EgameCompetitor competitor : competitorList) {
            totalScore += competitor.getOverallScore();
        }
        double avg= totalScore / competitorList.size();
        return avg;
    }

    public double getMinimumScore() {
        double minScore = competitorList.get(0).getOverallScore();
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getOverallScore() < minScore) {
                minScore = competitor.getOverallScore();
            }
        }
        return minScore;
    }

    public double getMaximumScore() {
        double maxScore = competitorList.get(0).getOverallScore();
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getOverallScore() > maxScore) {
                maxScore = competitor.getOverallScore();
            }
        }
        return maxScore;
    }

    public int[] getScoreFrequency() {
        int[] scoreFrequency = new int[6];
        for (EgameCompetitor competitor : competitorList) {
            for (int score : competitor.getScoreArray()) {
                scoreFrequency[score]++;
            }
        }
        return scoreFrequency;
    }

    public EgameCompetitor getCompetitorName(int competitorNum) {
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getCompetitorNumber() == competitorNum) {
                return competitor;}
            
    }
        return null;
    }

    public EgameCompetitor getCompetitor(int competitorNumber) {
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

}
