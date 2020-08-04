package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Branch> elements = new ArrayList<>();
        JFrame mainFrame = new JFrame("PSpice");
        JTextArea textArea = new JTextArea();
        JButton runButton = new JButton("RUN");
        JButton loadButton = new JButton("LOAD");
        JButton drawButton = new JButton("DRAW");
        JButton saveButton = new JButton("SAVE");
        JPanel panel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.black, 2 , false);
        runButton.setBorder(border);
        loadButton.setBorder(border);
        drawButton.setBorder(border);
        saveButton.setBorder(border);
        textArea.setBackground(Color.black);
        loadButton.setBackground(Color.black);
        drawButton.setBackground(Color.black);
        runButton.setBackground(Color.black);
        saveButton.setBackground(Color.black);
        loadButton.setForeground(Color.red);
        drawButton.setForeground(Color.red);
        runButton.setForeground(Color.red);
        textArea.setForeground(Color.red);
        saveButton.setForeground(Color.red);
        ImageIcon logo = new ImageIcon("src\\pic\\image.png");
        Image nrv = logo.getImage();
        Image nnrv = nrv.getScaledInstance(130, 130 , Image.SCALE_SMOOTH);
        logo = new ImageIcon(nnrv);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(280,180, 130,130);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel textlabel = new JLabel("PSpice");
        textlabel.setForeground(new Color(170,0,0));
        textlabel.setFont(new Font("BOLD", Font.BOLD, 45));
        textlabel.setBounds(270,300,150,100);

        mainFrame.setSize(480, 440);
        mainFrame.setLocation(500,200);
        mainFrame.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK , 6 , true));
        panel.setBackground(new Color(158,154,44));
        panel.setLayout(null);
        panel.setBounds(0,0,466,403);
        mainFrame.add(panel);

        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(new Font("BOLD", Font.BOLD, 16));
        scrollPane.setBorder(border);
        scrollPane.setBounds(10,10,220,310);
        loadButton.setBounds(20,340,80,40);
        runButton.setBounds(255,30,80,40);
        drawButton.setBounds(365,30,80,40);
        saveButton.setBounds(140, 340, 80, 40);

        panel.add(scrollPane);
        panel.add(loadButton);
        panel.add(runButton);
        panel.add(drawButton);
        panel.add(saveButton);
        panel.add(logoLabel);
        panel.add(textlabel);

        final File[] file = {new File("input.txt")};
        try {
            BufferedReader fileB = new BufferedReader(new FileReader(file[0]));
            String s;
            while((s = fileB.readLine()) != null)
                textArea.append(s + "\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Ardavan Kav\\Desktop");
                fileChooser.showSaveDialog(null);
                if(fileChooser.getSelectedFile() != null){
                    file[0] = fileChooser.getSelectedFile();
                    textArea.setText("");
                    try {
                        BufferedReader fileB = new BufferedReader(new FileReader(file[0]));
                        String s;
                        while((s = fileB.readLine()) != null)
                            textArea.append(s + "\n");
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    BufferedWriter fileW =new BufferedWriter(new FileWriter(file[0]));
                    String bufferedText = textArea.getText();
                    fileW.write(bufferedText);
                    fileW.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                boolean show = true;
                String[] fileContainer;
                String bufferedText = textArea.getText();
                fileContainer = bufferedText.split("\n");
                Analyze.Voltage.clear();
                Analyze.Current.clear();
                Analyze.Power.clear();
                Analyze.elementsKey.clear();
                Analyze.elements.clear();
                    runWindow.selectedBranch = "";

                Analyze.main(fileContainer);
                if (Analyze.invalidinput) {
                    JOptionPane.showMessageDialog(mainFrame, "invalid input :: line: " + Analyze.errLine, "ANALYZE ERROR!", 0);
                    Analyze.invalidinput = false;
                    show = false;
                }else if (Analyze.err1) {
                    JOptionPane.showMessageDialog(mainFrame, "Error # 1 #", "ANALYZE ERROR!", 0);
                    Analyze.err1 = false;
                    show = false;
                }
                else if(Analyze.err2){
                    JOptionPane.showMessageDialog(mainFrame, "Error # 2 #", "ANALYZE ERROR!", 0);
                    Analyze.err2 = false;
                    show = false;
                }
                else if(Analyze.err3){
                    JOptionPane.showMessageDialog(mainFrame, "Error # 3 #", "ANALYZE ERROR!", 0);
                    Analyze.err3 = false;
                    show = false;
                }

                else if(Analyze.err4){
                    JOptionPane.showMessageDialog(mainFrame, "Error # 4 #", "ANALYZE ERROR!", 0);
                    Analyze.err4 = false;
                    show = false;
                }

                else if(Analyze.err5){
                    JOptionPane.showMessageDialog(mainFrame, "Error # 5 #", "ANALYZE ERROR!", 0);
                    Analyze.err5 = false;
                    show = false;
                }
                elements.clear();
                for(String s: Analyze.elementsKey)
                    elements.add(Analyze.elements.get(s));


                //=================================================================================================RUN:

                if(show){
                    Circuit c = new Circuit();
                    c.main(elements);
                }

                //====================================================================================================

            }
        });

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] fileContainer;
                String bufferedText = textArea.getText();
                fileContainer = bufferedText.split("\n+");
                runWindow run = new runWindow();
                run.open(fileContainer);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    BufferedWriter fileW =new BufferedWriter(new FileWriter(file[0]));
                    String bufferedText = textArea.getText();
                    fileW.write(bufferedText);
                    fileW.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        mainFrame.setVisible(true);

    }

}
