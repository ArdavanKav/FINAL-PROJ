package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class runWindow {

    JFrame main = new JFrame("Simulation Setting");
    JLabel label1 = new JLabel("Select the branch:");
    JButton button = new JButton("Run");
    JTextField nameField = new JTextField();
    Border border1 = BorderFactory.createLineBorder(Color.BLUE , 3 , true);
    JPanel panel = new JPanel();
    JLabel label2 = new JLabel("Select analysis period:");
    JLabel label3 = new JLabel("to");
    JTextField startTime = new JTextField("0");
    JTextField endTime = new JTextField("t");
    static String selectedBranch = new String("");

   void open(String[] fileContainer){

        main.pack();
        main.setLocation(550,300);
        main.setSize(400, 250);
        main.setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0,0,385,212);
        panel.setBorder(border1);
        panel.setBackground(Color.white);

        label1.setBounds(40, 40, 130, 20);
        nameField.setBounds(160, 40, 100, 20);
        label2.setBounds(40,90, 150, 20);
        label3.setBounds(260, 90, 50,20);
        startTime.setBounds(190, 90, 60, 20);
        endTime.setBounds(290, 90, 60, 20);
        button.setBounds(150, 150, 100, 30);

        panel.add(label1);
        panel.add(nameField);
        panel.add(button);
        panel.add(label2);
        panel.add(label3);
        panel.add(startTime);
        panel.add(endTime);
        main.add(panel);
        main.setVisible(true);
        AnalyzeChart chart = new AnalyzeChart();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Analyze.Voltage.clear();
                Analyze.Current.clear();
                Analyze.Power.clear();
                Analyze.elementsKey.clear();
                Analyze.elements.clear();
                selectedBranch = nameField.getText();

                Analyze.main(fileContainer);
                double t1 = Analyze.realValue(startTime.getText());
                double t2;
                if(endTime.getText().equals("t"))
                    t2 = Analyze.t;
                else
                    t2 = Analyze.realValue(endTime.getText());

                if(!Analyze.doesExist){
                    JOptionPane.showMessageDialog(main, "Error :: invald branch name", "INPUT ERROR!", 0);
                }
                else if(t2 > Analyze.t || t1 < 0 || t2 <= 0 || t1 >= t2){
                    JOptionPane.showMessageDialog(main, "Error :: invald analysis domain", "INPUT ERROR!", 0);
                }
                //else if(Analyze.invalidinput){
                //    JOptionPane.showMessageDialog(main, "invalid input :: line: " + Analyze.fileContainerLocation, "ANALYZE ERROR!", 0);
                //   main.setVisible(false);
                //}
                else if(Analyze.err1){
                    JOptionPane.showMessageDialog(main, "Error # 1 #", "ANALYZE ERROR!", 0);
                main.setVisible(false);
                }
                else if(Analyze.err2){
                    JOptionPane.showMessageDialog(main, "Error # 2 #", "ANALYZE ERROR!", 0);
                    main.setVisible(false);
                }
                else if(Analyze.err3){
                    JOptionPane.showMessageDialog(main, "Error # 3 #", "ANALYZE ERROR!", 0);
                    main.setVisible(false);
                }
                else if(Analyze.err4){
                    JOptionPane.showMessageDialog(main, "Error # 4 #", "ANALYZE  ERROR!", 0);
                    main.setVisible(false);
                }
                else if(Analyze.err5){
                    JOptionPane.showMessageDialog(main, "Error # 5 #", "ANALYZE ERROR!", 0);
                    main.setVisible(false);
                }
                else{
                    int a = (Analyze.Voltage.size()/45);
                    if(a == 0)
                        a = 1;
                    ArrayList<Double> cutVoltage = new ArrayList<>();
                    ArrayList<Double> cutCurrent = new ArrayList<>();
                    ArrayList<Double> cutPower = new ArrayList<>();
                    for(int i = 0; i < Analyze.Voltage.size() ; i += a){
                        cutVoltage.add(Analyze.Voltage.get(i));
                        cutCurrent.add(Analyze.Current.get(i));
                        cutPower.add(Analyze.Power.get(i));
                    }
                    main.setVisible(false);
                    chart.openChartVoltage(cutVoltage, t1, t2);
                    chart.openChartCurrent(cutCurrent, t1, t2);
                    chart.openChartPower(cutPower, t1, t2);
                }
            }
        });
    }

}
