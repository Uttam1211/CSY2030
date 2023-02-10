package part1;

import java.util.ArrayList;
import java.util.Arrays;

public class Competitor{
    public static void main(String[] args) {
        var com = new CompetitorList();
        Manager manager = new Manager("input.csv");
        manager.displayCompetitorDetails();
       manager.produceFinalReport("output.csv");

    }


    }


