package part2;

import javax.swing.*;

public class Competitor{
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        Manager manager = new Manager("input.csv");
       manager.produceFinalReport("output.csv");
       //for gui
        competitorList.readEgameCompetitorData("input.csv");
        JFrame gui = new CompetitorGUI(competitorList);
        gui.setVisible(true);


    }
}


