package part1;

import java.io.*;
import java.util.Scanner;

public class Manager {
    private CompetitorList competitorList;

    private Name n;

    public Manager(String filePath) {
        competitorList = new CompetitorList();
        createCompetitorList(filePath);
    }

    private void createCompetitorList(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int competitorNumber = Integer.parseInt(data[0].trim());
                String firstName = data[1].trim();
                String lastName = data[2].trim();
                int age = Integer.parseInt(data[3].trim());
                Name competitorName = new Name(firstName, lastName,age);
                String level = data[4].trim();
                String country = data[5].trim();
                int[] scores = new int[data.length - 6];
                for (int i = 0; i < scores.length; i++) {
                    scores[i] = Integer.parseInt(data[i + 6].trim());
                }
                EgameCompetitor competitor = new EgameCompetitor(competitorNumber, competitorName, level, country, scores);
                competitorList.addCompetitor(competitor);
//System.out.println(competitorList.getCompetitor(10).getOverallScore());
                //System.out.println(competitor);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void produceFinalReport(String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(" ------- part1.Competitor Level Scores Overall:  --------");
            writer.newLine();
            for (EgameCompetitor competitor : competitorList.getCompetitorList()) {
                writer.write(competitor.getFullDetails());
                writer.newLine();
            }
            EgameCompetitor highestScoreCompetitor = competitorList.getHighestScoreCompetitor();
            writer.write("\nThe person with the highest score is "+highestScoreCompetitor.getCompetitorName().getFullName()  + " with a score of " + highestScoreCompetitor.getOverallScore());
            writer.newLine();
            writer.write("\nTotal competitors: " + competitorList.getCompetitorList().size());
            writer.newLine();
            writer.write("\nAverage score: " + competitorList.getAverageScore());
            writer.newLine();
            writer.write("\nMinimum score: " + competitorList.getMinimumScore());
            writer.newLine();
            writer.write("\nMaximum score: " + competitorList.getMaximumScore());
            writer.newLine();
            int[] scoreFrequency = competitorList.getScoreFrequency();
            writer.write("\nScore frequency: ");
            for (int i = 0; i < scoreFrequency.length; i++) {
                writer.write(i + ":" + scoreFrequency[i] + " ");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void displayCompetitorDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter competitor number: ");
        int competitorNumber = input.nextInt();
        EgameCompetitor competitor = competitorList.getCompetitor(competitorNumber);
        if (competitor != null) {
            System.out.println(competitor.getShortDetails());
        } else {
            System.out.println("Invalid competitor number.");
        }
    }

}