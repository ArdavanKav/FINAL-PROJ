package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Draw3 extends Canvas {

    static ArrayList<Double> list = new ArrayList<>();
    static double max = 0;
    static double min = 0;
    static double t = 0;
    static int y0 = 0;
    Draw3(ArrayList<Double> list, double t){
        this.list = list;
        this.t = t;
        for(double s: list){
            if(s > max)
                max = s;
            if(s < min)
                min = s;
        }
        this.y0 = (int)((350*max - 10*min)/(max - min));
    }


    public void paint(Graphics g) {
        int y = y0;
        int yp = 0;
        int x = 40;
        int xp = 40;
        g.setColor(Color.black);
        g.fillRect(0,0,2000,3000);
        g.setColor(Color.white);
        g.drawLine(40, 7, 40, 353);
        g.drawLine(37,10,40,10);
        g.drawLine(37,350,40,350);
        if(min >= 0 && max >= 0){
            y0 = 350;
            g.fillPolygon(new int[]{37, 40, 43}, new int[]{7, 1, 7}, 3);
        }
        else if(min <= 0 && max<= 0){
            y0 = 10;
            g.fillPolygon(new int[]{37, 40, 44}, new int[]{353, 359, 353}, 3);
        }
        else if(min <= 0 && max >= 0){
            g.fillPolygon(new int[]{37, 40, 43}, new int[]{7, 1, 7}, 3);
            g.drawString("0.00", 5, y0);
        }
        g.drawLine(40, y0, 693, y0);
        g.fillPolygon(new int[]{693, 699, 693}, new int[]{y0-3, y0, y0+3}, 3);
        g.drawLine(690, y0, 690, y0+3);
        g.drawLine(365, y0, 365, y0+3);
        g.drawLine(197, y0, 197, y0+3);
        g.drawLine(532, y0, 532, y0+3);
        g.drawString(String.format("%.2f", t), 680, y0+15);
        g.drawString(String.format("%.2f", max), 5, 20);
        g.drawString(String.format("%.2f", min), 5, 350);
        g.setColor(Color.GREEN);

        for(double s: list){
            yp = y;
            y = (int)((350*max - 10*min - 340*s)/(max - min));
            g.drawLine(xp, yp, x, y);
            xp = x;
            x += (650/(list.size()-1));
        }



    }

}