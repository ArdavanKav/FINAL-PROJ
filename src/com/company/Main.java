package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static ArrayList<String> elementsKey = new ArrayList<>();
    static Node[] node = new Node[100];
    static HashMap<String, Branch> elements = new HashMap<>();

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("KAV_Spice");
        JTextArea textArea = new JTextArea();
        JButton runButton = new JButton("RUN");
        JButton loadButton = new JButton("LOAD");
        JButton drawButton = new JButton("DRAW");
        JPanel panel = new JPanel();

        mainFrame.setSize(380, 440);
        mainFrame.setLocation(480,200);
        mainFrame.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE , 3 , true));
        panel.setLayout(null);
        panel.setBounds(0,0,366,403);
        mainFrame.add(panel);

        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(new Font("BOLD", Font.BOLD, 20));
        scrollPane.setBounds(20,10,220,370);
        loadButton.setBounds(260,50,80,40);
        runButton.setBounds(260,130,80,40);
        drawButton.setBounds(260,210,80,40);

        panel.add(scrollPane);
        panel.add(loadButton);
        panel.add(runButton);
        panel.add(drawButton);

        final FileReader[] file = new FileReader[1];
        final String[] thisline = new String[1];
        try {
            file[0] = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(file[0]);
            while ((thisline[0] = reader.readLine()) != null)
                textArea.append(thisline[0] +"\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Ardavan Kav\\Desktop");
                fileChooser.showSaveDialog(null);
                String s = fileChooser.getName(fileChooser.getSelectedFile());
                try {
                    file[0] = new FileReader(s);
                    BufferedReader reader = new BufferedReader(file[0]);
                    textArea.setText("");
                    while ((thisline[0] = reader.readLine()) != null)
                        textArea.append(thisline[0] +"\n");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] fileContainer = new String[100];
                String bufferedText = textArea.getText();
                fileContainer = bufferedText.split("\n");

                Analyze.Voltage.clear();
                Analyze.Current.clear();
                Analyze.Power.clear();
                Analyze.elementsKey.clear();
                Analyze.elements.clear();
                    runWindow.selectedBranch = "";
                Analyze.main(fileContainer);
                if(Analyze.err2)
                    JOptionPane.showMessageDialog(mainFrame, "Error # 2 #", "ANALYZE ERROR!", 0);
                else if(Analyze.err3)
                    JOptionPane.showMessageDialog(mainFrame, "Error # 3 #", "ANALYZE ERROR!", 0);
                else if(Analyze.err4)
                    JOptionPane.showMessageDialog(mainFrame, "Error # 4 #", "ANALYZE ERROR!", 0);
                else if(Analyze.err5)
                    JOptionPane.showMessageDialog(mainFrame, "Error # 5 #", "ANALYZE ERROR!", 0);


                //=================================================================================================RUN:





                //====================================================================================================


            }
        });

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] fileContainer;
                String bufferedText = textArea.getText();
                fileContainer = bufferedText.split("\n");
                runWindow run = new runWindow();
                run.open(fileContainer);
            }
        });

        mainFrame.setVisible(true);

    }

}
