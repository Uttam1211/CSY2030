package part2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CompetitorGUI extends JFrame {
    private CompetitorList competitorList;
    private JPanel mainPanel;
    private JPanel viewScoresPanel;
    private JPanel viewTablePanel;
    private JPanel viewDetailsPanel;

    private JTextField competitorNumberField;
    private JTextField scoreField;
    private JButton updateScoreButton;
    private JTable competitorTable;

    public CompetitorGUI(CompetitorList competitorList) {
        this.competitorList = competitorList;

        setTitle("Competitor List");
        JLabel headingLabel = new JLabel("Competitors");
        headingLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Competitor Number", "Name", "Age", "Level", "Country", "Overall Score"};
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headingLabel);
        //ScoreField Update
        viewScoresPanel = new JPanel();
        viewScoresPanel.setLayout(new FlowLayout());
        competitorNumberField = new JTextField(5);
        scoreField = new JTextField(5);
        updateScoreButton = new JButton("Update Score");
        updateScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int competitorNumber = Integer.parseInt(competitorNumberField.getText());
                int newScore = Integer.parseInt(scoreField.getText());
                EgameCompetitor competitor = competitorList.getCompetitor(competitorNumber);
                competitor.updateScore(newScore);
                JOptionPane.showMessageDialog(null, "Overall score for competitor " + competitorNumber + " is now " + competitor.getOverallScore());
            }
        });
        // Add a statistics button to the viewTablePanel
        JPanel viewTablePanel1 = new JPanel();
        JButton statisticsButton = new JButton("View Statistics");
        statisticsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the statistics from the CompetitorList
                double highestScore = competitorList.getHighestScore();
                double averageScore = competitorList.getAverageScore();
                double minimumScore = competitorList.getMinimumScore();
                double maximumScore = competitorList.getMaximumScore();
                int[] scoreFrequency = competitorList.getScoreFrequency();
                EgameCompetitor highestScoreCompetitor = competitorList.getHighestScoreCompetitor();

                // Show the statistics in a message dialog
                JOptionPane.showMessageDialog(null, "Highest Score: " + highestScore +
                        "\nAverage Score: " + averageScore +
                        "\nMinimum Score: " + minimumScore +
                        "\nMaximum Score: " + maximumScore +
                        "\nScore Frequency: " + Arrays.toString(scoreFrequency) +
                        "\nHighest Score Competitor: " + highestScoreCompetitor.getCompetitorName().getFullName(),"Statistics",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        viewTablePanel=new JPanel();
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //update the data in the JTable
                competitorTable.setModel(new DefaultTableModel(competitorList.getTableData(), columnNames));
            }
        });
        viewTablePanel.add(refreshButton);
        mainPanel.add(viewTablePanel);
       // mainPanel.add(viewDetailsPanel);
        viewScoresPanel.add(new JLabel("Enter competitor number: "));
        viewScoresPanel.add(competitorNumberField);
        viewScoresPanel.add(new JLabel("Enter new score: "));
        viewScoresPanel.add(scoreField);
        viewScoresPanel.add(updateScoreButton);
        viewTablePanel = new JPanel();

        Object[][] data = competitorList.getTableData();
        competitorTable = new JTable(data, columnNames);
       // viewTablePanel.add("")
        viewTablePanel.add(new JScrollPane(competitorTable));

        viewDetailsPanel = new JPanel();
        viewDetailsPanel.setLayout(new FlowLayout());
        JTextField competitorNumberField2 = new JTextField(6);
        JButton viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int competitorNumber = Integer.parseInt(competitorNumberField2.getText());
                EgameCompetitor competitor = competitorList.getCompetitor(competitorNumber);
                JOptionPane.showMessageDialog(null, competitor.getFullDetails());
            }
        });

        viewDetailsPanel.add(new JLabel("Enter competitor number: "));
        viewDetailsPanel.add(competitorNumberField2);
        viewDetailsPanel.add(viewDetailsButton);
        mainPanel.add(viewScoresPanel);
        mainPanel.add(viewTablePanel);
        mainPanel.add(viewDetailsPanel);

        add(mainPanel);

       viewTablePanel.add(statisticsButton);

        //choose

        JComboBox<String> filterByComboBox = new JComboBox<>(new String[] {"Competitor Number", "Level", "Country", "AGE"});
        JTextField filterValueField = new JTextField(10);
        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterBy = (String) filterByComboBox.getSelectedItem();
                String filterValue = filterValueField.getText();
                ArrayList<EgameCompetitor> filteredCompetitors = new ArrayList<>();
                for (EgameCompetitor competitor : competitorList.getCompetitorList()) {
                    if (filterBy.equals("Competitor Number") && competitor.getCompetitorNumber() == Integer.parseInt(filterValue)) {
                        filteredCompetitors.add(competitor);
                    } else if (filterBy.equals("Level") && competitor.getLevel().equalsIgnoreCase(filterValue)) {
                        filteredCompetitors.add(competitor);
                    } else if (filterBy.equals("Country") && competitor.getCountry().equalsIgnoreCase(filterValue)) {
                        filteredCompetitors.add(competitor);
                    } else if (filterBy.equals("AGE") && competitor.getCompetitorName().getAge() == Integer.parseInt(filterValue)) {
                        filteredCompetitors.add(competitor);
                    }
                }
                Object[][] filteredData = new Object[filteredCompetitors.size()][6];
                for (int i = 0; i < filteredCompetitors.size(); i++) {
                    EgameCompetitor c = filteredCompetitors.get(i);
                    filteredData[i][0] = c.getCompetitorNumber();
                    filteredData[i][1] = c.getCompetitorName().getFullName();
                    filteredData[i][2]=c.getCompetitorName().getAge();
                    filteredData[i][3] = c.getLevel();
                    filteredData[i][4] = c.getCountry();
                    filteredData[i][5] = c.getOverallScore();
                }
                competitorTable.setModel(new DefaultTableModel(filteredData, columnNames));
            }
        });
        viewDetailsPanel.add(filterByComboBox);
        viewDetailsPanel.add(filterValueField);
        viewDetailsPanel.add(filterButton);


    }


}