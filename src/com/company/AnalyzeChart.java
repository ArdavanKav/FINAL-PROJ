package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class AnalyzeChart{

    static JFrame f1 = new JFrame("Voltage ");
    static JFrame f2 = new JFrame("Current ");
    static JFrame f3 = new JFrame("Power ");

    void openChartVoltage(ArrayList<Double> Voltage, double t1, double t2){
        Draw1 draw1 = new Draw1(Voltage, t1, t2);
        f1.add(draw1);
        f1.setSize(730, 410);
        f1.setLocation(400,10);
        f1.setVisible(true);

    }
    void openChartCurrent(ArrayList<Double> Current, double t1, double t2){
        Draw2 draw2 = new Draw2(Current, t1, t2);
        f2.add(draw2);
        f2.setSize(730, 410);
        f2.setLocation(780,420);
        f2.setVisible(true);

    }
    void openChartPower(ArrayList<Double> Power, double t1, double t2){
        Draw3 draw3 = new Draw3(Power, t1, t2);
        f3.add(draw3);
        f3.setSize(730, 410);
        f3.setLocation(20,420);
        f3.setVisible(true);

    }


}
