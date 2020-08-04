package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CircuitMaker {

    JFrame mainFrame = new JFrame("Circuit Schematic");
    JPanel mainPanel = new JPanel();
    JPanel panel = new JPanel();
    JLabel[][] node = new JLabel[6][5];
    JLabel[] element = new JLabel[50];


    void main(ArrayList<Branch> branches) {

        mainFrame.setSize(820, 720);
        mainFrame.setLocation(300, 50);
        mainPanel.setBounds(0, 0, 800, 700);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 6, false));
        mainPanel.setBackground(new Color(158, 154, 44));
        mainPanel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 3, false));
        panel.setBounds(75, 25, 650, 575);
        panel.setBackground(Color.white);
        panel.setLayout(null);


        //--------------------------------------------------------------------------------------------------------------
        ImageIcon nodePNG = new ImageIcon("src\\MyPic\\node.png");
        Image nie = nodePNG.getImage();
        Image nnimg = nie.getScaledInstance(7, 7, Image.SCALE_SMOOTH);
        nodePNG = new ImageIcon(nnimg);

        //--------------------------------------------------------------------------------------------------------------
        ImageIcon GND = new ImageIcon("src\\MyPic\\ground.png");
        GND = new ImageIcon(GND.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        JLabel GNDlabel = new JLabel(GND);
        GNDlabel.setBounds(370, 600, 60, 60);
        mainPanel.add(GNDlabel);

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon resistor1 = new ImageIcon("src\\MyPic\\resistor1.png");
        resistor1 = new ImageIcon(resistor1.getImage().getScaledInstance(30, 100, Image.SCALE_SMOOTH));

        ImageIcon resistor2 = new ImageIcon("src\\MyPic\\resistor2.png");
        resistor2 = new ImageIcon(resistor2.getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon capacitor1 = new ImageIcon("src\\MyPic\\capacitor1.png");
        capacitor1 = new ImageIcon(capacitor1.getImage().getScaledInstance(30, 100, Image.SCALE_SMOOTH));

        ImageIcon capacitor2 = new ImageIcon("src\\MyPic\\capacitor2.png");
        capacitor2 = new ImageIcon(capacitor2.getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon inductor1 = new ImageIcon("src\\MyPic\\indactor1.png");
        inductor1 = new ImageIcon(inductor1.getImage().getScaledInstance(30, 100, Image.SCALE_SMOOTH));

        ImageIcon inductor2 = new ImageIcon("src\\MyPic\\indactor2.png");
        inductor2 = new ImageIcon(inductor2.getImage().getScaledInstance(100, 30, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon ac1 = new ImageIcon("src\\MyPic\\ac1.png");
        ac1 = new ImageIcon(ac1.getImage().getScaledInstance(70, 110, Image.SCALE_SMOOTH));

        ImageIcon ac2 = new ImageIcon("src\\MyPic\\ac2.png");
        ac2 = new ImageIcon(ac2.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon di1 = new ImageIcon("src\\MyPic\\di1.png");
        di1 = new ImageIcon(di1.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH));

        ImageIcon di2 = new ImageIcon("src\\MyPic\\di2.png");
        di2 = new ImageIcon(di2.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));

        ImageIcon di3 = new ImageIcon("src\\MyPic\\di3.png");
        di3 = new ImageIcon(di3.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH));

        ImageIcon di4 = new ImageIcon("src\\MyPic\\di4.png");
        di4 = new ImageIcon(di4.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon dv1 = new ImageIcon("src\\MyPic\\dv1.png");
        dv1 = new ImageIcon(dv1.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH));

        ImageIcon dv2 = new ImageIcon("src\\MyPic\\dv2.png");
        dv2 = new ImageIcon(dv2.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));

        ImageIcon dv3 = new ImageIcon("src\\MyPic\\dv3.png");
        dv3 = new ImageIcon(dv3.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH));

        ImageIcon dv4 = new ImageIcon("src\\MyPic\\dv4.png");
        dv4 = new ImageIcon(dv4.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------


        ImageIcon isource1 = new ImageIcon("src\\MyPic\\isource1.png");
        isource1 = new ImageIcon(isource1.getImage().getScaledInstance(70, 110, Image.SCALE_SMOOTH));

        ImageIcon isource2 = new ImageIcon("src\\MyPic\\isource2.png");
        isource2 = new ImageIcon(isource2.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH));

        ImageIcon isource3 = new ImageIcon("src\\MyPic\\isource3.png");
        isource3 = new ImageIcon(isource3.getImage().getScaledInstance(70, 110, Image.SCALE_SMOOTH));

        ImageIcon isource4 = new ImageIcon("src\\MyPic\\isource4.png");
        isource4 = new ImageIcon(isource4.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH));

        //--------------------------------------------------------------------------------------------------------------

        ImageIcon vsource1 = new ImageIcon("src\\MyPic\\vsource1.png");
        vsource1 = new ImageIcon(vsource1.getImage().getScaledInstance(70, 110, Image.SCALE_SMOOTH));

        ImageIcon vsource2 = new ImageIcon("src\\MyPic\\vsource2.png");
        vsource2 = new ImageIcon(vsource2.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH));

        ImageIcon vsource3 = new ImageIcon("src\\MyPic\\vsource3.png");
        vsource3 = new ImageIcon(vsource3.getImage().getScaledInstance(70, 110, Image.SCALE_SMOOTH));

        ImageIcon vsource4 = new ImageIcon("src\\MyPic\\vsource4.png");
        vsource4 = new ImageIcon(vsource4.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH));

        //==============================================================================================================

        for (int j = 0; j < 5; j++)
            for (int i = 0; i < 6; i++) {
                node[i][j] = new JLabel(nodePNG);
                node[i][j].setBounds(150 + 100 * i - 3, 500 - 100 * j - 3, 7, 7);
                mainPanel.add(node[i][j]);

            }

        int v1x=0, v2x = 0, v1y=500, v2y=500, i1=0, j1=0, i2=0, j2=0, num=0;

        for (Branch s : branches) {

            if (s.in == 0){
                v1y = 600;
                v2y = 500;
                s.out--;
                i2 = s.out % 6;
                v2x = 150 + i2*100;
                v1x = 150 + i2*100;
            }
            else if (s.out == 0){
                v2y = 600;
                v1y = 500;
                s.in--;
                i1 = s.in % 6;
                v1x = 150 + i1*100;
                v2x = 150 + i1*100;
            }
            else if (s.in != 0 && s.out != 0) {
                s.in--;
                s.out--;
                i1 = s.in % 6;
                j1 = s.in / 6;
                i2 = s.out % 6;
                j2 = s.out / 6;
                v1x = 150 + i1*100;
                v2x = 150 + i2*100;
                v1y = 500 - j1*100;
                v2y = 500 - j2*100;
            }

            if (s.type.equals("R")) {
                if(v2x == v1x){
                    element[num] = new JLabel(resistor1);
                    if(v1y < v2y)
                        element[num].setBounds(v1x-15,v1y,30,100);
                    if(v1y > v2y)
                        element[num].setBounds(v1x-15,v2y,30,100);
                    mainPanel.add(element[num]);
                }
                if(v1y == v2y){
                    element[num] = new JLabel(resistor2);
                    if(v1x > v2x)
                        element[num].setBounds(v2x,v1y-15,100,30);
                    if(v1x < v2x)
                        element[num].setBounds(v1x,v1y-15,100,30);
                    mainPanel.add(element[num]);
                }
            }

            if (s.type.equals("C")) {
                if(v2x == v1x){
                    element[num] = new JLabel(capacitor1);
                    if(v1y < v2y)
                        element[num].setBounds(v1x-15,v1y,30,100);
                    if(v1y > v2y)
                        element[num].setBounds(v1x-15,v2y,30,100);
                    mainPanel.add(element[num]);
                }
                if(v1y == v2y){
                    element[num] = new JLabel(capacitor2);
                    if(v1x > v2x)
                        element[num].setBounds(v2x,v1y-15,100,30);
                    if(v1x < v2x)
                        element[num].setBounds(v1x,v1y-15,100,30);
                    mainPanel.add(element[num]);
                }
            }

            if (s.type.equals("L")) {
                if(v2x == v1x){
                    element[num] = new JLabel(inductor1);
                    if(v1y < v2y)
                        element[num].setBounds(v1x-15,v1y,30,100);
                    if(v1y > v2y)
                        element[num].setBounds(v1x-15,v2y,30,100);
                    mainPanel.add(element[num]);
                }
                if(v1y == v2y){
                    element[num] = new JLabel(inductor2);
                    if(v1x > v2x)
                        element[num].setBounds(v2x,v1y-15,100,30);
                    if(v1x < v2x)
                        element[num].setBounds(v1x,v1y-15,100,30);
                    mainPanel.add(element[num]);
                }
            }

            if (s.type.equals("V")) {
                if(s.freq != 0){
                    if(v2x == v1x){
                        element[num] = new JLabel(ac1);
                        if(v1y < v2y)
                            element[num].setBounds(v1x-35,v1y-5,70,110);
                        if(v1y > v2y)
                            element[num].setBounds(v1x-35,v2y-5,70,110);
                        mainPanel.add(element[num]);
                    }
                    if(v1y == v2y){
                        element[num] = new JLabel(ac2);
                        if(v1x > v2x)
                            element[num].setBounds(v2x-5,v1y-35,110,70);
                        if(v1x < v2x)
                            element[num].setBounds(v1x-5,v1y-35,110,70);
                        mainPanel.add(element[num]);
                    }
                }

                else if(s.freq == 0){
                    if(v2x == v1x){
                        if(v1y < v2y){
                            element[num] = new JLabel(vsource3);
                            element[num].setBounds(v1x-35,v1y-5,70,110);
                        }

                        if(v1y > v2y){
                            element[num] = new JLabel(vsource1);
                            element[num].setBounds(v1x-35,v2y-5,70,110);
                        }
                        mainPanel.add(element[num]);
                    }
                    if(v1y == v2y){
                        if(v1x > v2x){
                            element[num] = new JLabel(vsource4);
                            element[num].setBounds(v2x-5,v1y-35,110,70);
                        }

                        if(v1x < v2x){
                            element[num] = new JLabel(vsource2);
                            element[num].setBounds(v1x-5,v1y-35,110,70);
                        }
                        mainPanel.add(element[num]);
                    }
                }

            }

            if (s.type.equals("I")) {
                if(s.freq != 0){
                    if(v2x == v1x){
                        element[num] = new JLabel(ac1);
                        if(v1y < v2y)
                            element[num].setBounds(v1x-35,v1y-5,70,110);
                        if(v1y > v2y)
                            element[num].setBounds(v1x-35,v2y-5,70,110);
                        mainPanel.add(element[num]);
                    }
                    if(v1y == v2y){
                        element[num] = new JLabel(ac2);
                        if(v1x > v2x)
                            element[num].setBounds(v2x-5,v1y-35,110,70);
                        if(v1x < v2x)
                            element[num].setBounds(v1x-5,v1y-35,110,70);
                        mainPanel.add(element[num]);
                    }
                }

                else if(s.freq == 0){
                    if(v2x == v1x){
                        if(v1y < v2y){
                            element[num] = new JLabel(isource3);
                            element[num].setBounds(v1x-35,v1y-5,70,110);
                        }

                        if(v1y > v2y){
                            element[num] = new JLabel(isource1);
                            element[num].setBounds(v1x-35,v2y-5,70,110);
                        }
                        mainPanel.add(element[num]);
                    }
                    if(v1y == v2y){
                        if(v1x > v2x){
                            element[num] = new JLabel(isource4);
                            element[num].setBounds(v2x-5,v1y-35,110,70);
                        }

                        if(v1x < v2x){
                            element[num] = new JLabel(isource2);
                            element[num].setBounds(v1x-5,v1y-35,110,70);
                        }
                        mainPanel.add(element[num]);
                    }
                }
            }

            if (s.type.equals("G") || s.type.equals("F")) {
                if(v2x == v1x){
                    if(v1y < v2y){
                        element[num] = new JLabel(di3);
                        element[num].setBounds(v1x-35,v1y,70,100);
                    }

                    if(v1y > v2y){
                        element[num] = new JLabel(di1);
                        element[num].setBounds(v1x-35,v2y,70,100);
                    }
                    mainPanel.add(element[num]);
                }
                if(v1y == v2y){
                    if(v1x > v2x){
                        element[num] = new JLabel(di4);
                        element[num].setBounds(v2x,v1y-35,100,70);
                    }

                    if(v1x < v2x){
                        element[num] = new JLabel(di2);
                        element[num].setBounds(v1x,v1y-35,100,70);
                    }
                    mainPanel.add(element[num]);
                }
            }

            if (s.type.equals("E") || s.type.equals("H")) {
                if(v2x == v1x){
                    if(v1y < v2y){
                        element[num] = new JLabel(dv3);
                        element[num].setBounds(v1x-35,v1y,70,100);
                    }

                    if(v1y > v2y){
                        element[num] = new JLabel(dv1);
                        element[num].setBounds(v1x-35,v2y,70,100);
                    }
                    mainPanel.add(element[num]);
                }
                if(v1y == v2y){
                    if(v1x > v2x){
                        element[num] = new JLabel(dv4);
                        element[num].setBounds(v2x,v1y-35,100,70);
                    }

                    if(v1x < v2x){
                        element[num] = new JLabel(dv2);
                        element[num].setBounds(v1x,v1y-35,100,70);
                    }
                    mainPanel.add(element[num]);
                }
            }

            num++;

        }


        mainFrame.add(mainPanel);
        mainPanel.add(panel);
        mainFrame.setVisible(true);

    }


}
