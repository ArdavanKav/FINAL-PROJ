package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Draw2 extends Canvas {

    static ArrayList<Double> list = new ArrayList<>();
    static double max = 0;
    static double min = 0;
    static double t1 = 0;
    static double t2 = 0;
    static int y0 = 180;

    Draw2(ArrayList<Double> list, double t1, double t2){
        this.list = list;
        this.t1 = t1;
        this.t2 = t2;
        min = 0;
        max = 0;
        for(double s: list){
            if(s > max)
                max = s;
            if(s < min)
                min = s;
        }
        this.y0 = (int)((350*max - 10*min)/(max - min));
    }

    public void paint(Graphics g) {
        int y;
        int yp;
        int x = 40;
        int xp = 40;
        g.setColor(Color.black);
        g.fillRect(0,0,2000,3000);
        g.setColor(Color.white);
        g.drawLine(40, 7, 40, 353);
        g.drawLine(37,10,40,10);
        g.drawLine(37,350,40,350);
        if(min > 0 && max > 0){
            y0 = 350;
            g.fillPolygon(new int[]{37, 40, 43}, new int[]{7, 1, 7}, 3);
        }
        else if(min <= 0 && max< 0){
            y0 = 10;
            g.fillPolygon(new int[]{37, 40, 44}, new int[]{353, 359, 353}, 3);
        }
        else if(min <= 0 && max >= 0){
            g.fillPolygon(new int[]{37, 40, 43}, new int[]{7, 1, 7}, 3);
        }
        g.drawLine(40, y0, 693, y0);
        g.fillPolygon(new int[]{693, 699, 693}, new int[]{y0-3, y0, y0+3}, 3);
        g.drawLine(690, y0, 690, y0+3);
        g.drawLine(365, y0, 365, y0+3);
        g.drawLine(197, y0, 197, y0+3);
        g.drawLine(532, y0, 532, y0+3);
        g.drawString(String.format("%.3f", (int)(t1/(Analyze.t/list.size())) *(Analyze.t/list.size())), 45, y0+15);
        g.drawString(String.format("%.3f", (int)(t2/(Analyze.t/list.size())) *(Analyze.t/list.size())), 680, y0+15);
        g.drawString(String.format("%.5f", max), 5, 20);
        g.drawString(String.format("%.5f", min), 5, 350);
        g.setColor(Color.GREEN);

        int i1 = (int) (t1* list.size()/Analyze.t)-1;
        int i2 = (int) (t2* list.size()/Analyze.t)-1;
        if(i1 < 0)
            i1=0;
        y = (int)((350*max - 10*min - 340*list.get(i1))/(max - min));
        for(int i = i1; i<= i2; i++){
            yp = y;
            y = (int)((350*max - 10*min - 340*list.get(i))/(max - min));
            g.drawLine(xp, yp, x, y);
            xp = x;
            x += (650/(i2 - i1));
        }

    }

}