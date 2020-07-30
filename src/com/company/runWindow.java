package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runWindow {

    static JFrame main = new JFrame("Simulation Setting");
    static JLabel label1 = new JLabel("Select the branch:");
    static JButton button = new JButton("Run");
    static JComboBox comboBox = new JComboBox();
    static Border border1 = BorderFactory.createLineBorder(Color.BLUE , 3 , true);
    static JPanel panel = new JPanel();
    static JLabel label2 = new JLabel("Select analysis period:");
    static JLabel label3 = new JLabel("to");
    static JTextField startTime = new JTextField("0");
    static JTextField endTime = new JTextField("t");
    static String selectedBranch = new String();

    static void open(String[] keys){

        main.pack();
        main.setLocation(550,300);
        main.setSize(400, 250);
        main.setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0,0,385,212);
        panel.setBorder(border1);
        panel.setBackground(Color.white);

        label1.setBounds(40, 40, 130, 20);
        comboBox = new JComboBox(keys);
        comboBox.setBounds(160, 40, 60, 20);
        label2.setBounds(40,90, 150, 20);
        label3.setBounds(260, 90, 50,20);
        startTime.setBounds(190, 90, 60, 20);
        endTime.setBounds(290, 90, 60, 20);
        button.setBounds(150, 150, 100, 30);

        panel.add(label1);
        panel.add(comboBox);
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
                selectedBranch = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
                Analyze.main(selectedBranch);
                double t1 = Analyze.realValue(startTime.getText());
                double t2;
                if(endTime.getText().equals("t"))
                    t2 = Analyze.t;
                else
                    t2 = Analyze.realValue(endTime.getText());
                if(t2 > Analyze.t || t1 < 0 || t2 <= 0 || t1 >= t2){
                    JOptionPane showError = new JOptionPane(JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(main, "Error :: invald analysis domain", "INPUT ERROR!", 0);
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
                    main.setVisible(false);
                    chart.openChartVoltage(Analyze.Voltage, t1, t2);
                    chart.openChartCurrent(Analyze.Current, t1, t2);
                    chart.openChartPower(Analyze.Power, t1, t2);
                }
            }
        });
    }

}
