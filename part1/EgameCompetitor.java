package part1;

import java.util.ArrayList;
import java.util.Arrays;

public class EgameCompetitor {
    private int competitorNumber;
    private Name competitorName;
    private String level;
    private String country;
    private int[] scores;

    public EgameCompetitor(int competitorNumber, Name competitorName, String level, String country, int [] scores) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.level = level;
        this.country = country;
        this.scores = new int[scores.length];
        System.arraycopy(scores, 0, this.scores, 0, scores.length);

        //System.out.println(getOverallScore());
        //part1.CompetitorList com = new part1.CompetitorList();
       // System.out.println(com.);

    }
    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public Name getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(Name competitorName) {
        this.competitorName = competitorName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    public int[] getScoreArray(){
        return scores;
    }

    public ArrayList<Integer> scoreArrayList(){
        ArrayList<Integer> scoresList = new ArrayList<Integer>();
        for(int score: scores){
            scoresList.add(score);
        }
        return scoresList;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getOverallScore() {
        // Calculate the overall score for the competitor by averaging their individual scores
        int levelNumber = 0;
        if (this.level.equalsIgnoreCase("Novice")) {
            levelNumber = 1;
        } else if (this.level.equalsIgnoreCase("Intermediate")) {
            levelNumber = 3;
        } else if (this.level.equalsIgnoreCase("Expert")) {
            levelNumber = 5;
        }
        // some logic to calculate overall score based on level number
        //for example:
        double sum = 0;
        for (int score : scores) {
            sum += score * levelNumber;
        }
        return sum / scores.length;
    }

    public String getShortDetails() {
        String initials = competitorName.getFirstName().substring(0,1) + competitorName.getLastName().substring(0,1);
        return "CN " + competitorNumber + " (" + initials + ") has overall score " + getOverallScore() + ".";
    }

    public String getFullDetails() {
        String scoresString = Arrays.toString(scores);
        return "part1.Competitor number " + competitorNumber + ", name " + competitorName.getFullName() + ", " + "aged "+competitorName.getAge() + ". " +
                competitorName.getFirstName() + " is a " + level + " and received these scores: " + scoresString +
                "This gives him an overall score of " + getOverallScore() + ".";
    }

}

