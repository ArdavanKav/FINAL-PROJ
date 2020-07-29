package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class AnalyzeChart{
    String BrName = "L1";
    JFrame f1 = new JFrame("Voltage " + BrName);
    JFrame f2 = new JFrame("Current " + BrName);
    JFrame f3 = new JFrame("Power " + BrName);

    void openChartVoltage(ArrayList<Double> Voltage, double t){

        Draw1 draw1 = new Draw1(Voltage, t);
        f1.add(draw1);
        f1.setSize(730, 410);
        f1.setLocation(400,10);
        f1.setVisible(true);

    }
    void openChartCurrent(ArrayList<Double> Current, double t){

        Draw2 draw2 = new Draw2(Current, t);
        f2.add(draw2);
        f2.setSize(730, 410);
        f2.setLocation(780,420);
        f2.setVisible(true);


    }
    void openChartPower(ArrayList<Double> Power, double t){

        Draw3 draw3 = new Draw3(Power, t);
        f3.add(draw3);
        f3.setSize(730, 410);
        f3.setLocation(20,420);
        f3.setVisible(true);


    }


}
