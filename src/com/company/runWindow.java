package com.company;
import jdk.dynalink.beans.StaticClass;

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

    static void open(String[] keys){

        main.pack();
        main.setLocation(550,300);
        main.setSize(400, 200);
        main.setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0,0,385,162);
        panel.setBorder(border1);
        panel.setBackground(Color.white);

        comboBox = new JComboBox(keys);
        label1.setBounds(40, 40, 130, 20);
        comboBox.setBounds(160, 40, 60, 20);
        button.setBounds(150, 100, 100, 30);

        panel.add(label1);
        panel.add(comboBox);
        panel.add(button);
        main.add(panel);
        main.setVisible(true);

        AnalyzeChart chart = new AnalyzeChart();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Analyze.main("L1");
                main.setVisible(false);
                chart.openChartVoltage(Analyze.Voltage, Analyze.t);
                chart.openChartCurrent(Analyze.Current, Analyze.t);
                chart.openChartPower(Analyze.Power, Analyze.t);
            }
        });
    }

}
