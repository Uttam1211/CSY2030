package part2;

import java.io.File;
import java.io.FileNotFoundException;
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

    public Object[][] getTableData() {
        Object[][] data = new Object[competitorList.size()][6];
        for (int i = 0; i < competitorList.size(); i++) {
            EgameCompetitor competitor = competitorList.get(i);
            data[i][0] = competitor.getCompetitorNumber();
            data[i][1] = competitor.getCompetitorName().getFullName();
            data[i][2]=competitor.getCompetitorName().getAge();
            data[i][3] = competitor.getLevel();
            data[i][4] = competitor.getCountry();
            data[i][5] = competitor.getOverallScore();
        }
        return data;
    }

    public void readEgameCompetitorData(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int competitorNumber = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                int age = Integer.parseInt(data[3]);
                String level = data[4];
                String country = data[5];
                int[] scores = new int[data.length - 6];
                for (int i = 6; i < data.length; i++) {
                    scores[i - 6] = Integer.parseInt(data[i]);
                }
                Name competitorName = new Name(firstName, lastName, age);
                EgameCompetitor competitor = new EgameCompetitor(competitorNumber, competitorName, level, country, scores);
                addCompetitor(competitor);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public double getHighestScore() {
        // Initialize the highestScore to the first competitor's overall score
        double highestScore = competitorList.get(0).getOverallScore();
        for (EgameCompetitor competitor : competitorList) {
            if (competitor.getOverallScore() > highestScore) {
                highestScore = competitor.getOverallScore();
            }
        }
        return highestScore;
    }

}
