package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JPanel{

    public static void main(String[] args) {

        // text console (30 emtiazi )  ///////////////////////////////////////////////////////////////
        JFrame f1 = new JFrame("text console");
        JFrame f2 = new JFrame("circuit");

        JLabel l0 = new JLabel(""); /// debugger lable
        l0.setBounds(0, 0, 1, 1); /// debugger lable


        //JPanel p1 = new JPanel();
        //  p1.setBounds(100 , 110 ,450 , 450 );


        JTextArea Txtbox = new JTextArea();
        Txtbox.setBounds(50, 50, 400, 290);

        JButton cfbtn = new JButton("Choose your file");
        cfbtn.setBounds(100, 350, 300, 30);


        JButton Runbtn = new JButton("Run");
        Runbtn.setBounds(100, 390, 300, 30);
///////////////////////////////////////////////////////////////////
        Runbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
              //  f2.setVisible(true);
                circuit c = new circuit();

                c.pic.setBounds(100 , 100 , 200 , 200);
                //c.add(c.pic);
                ImageIcon im = new ImageIcon("src\\pic\\images.png");
                Image img = im.getImage();
                Image nimg = img.getScaledInstance(c.pic.getWidth() , c.pic.getHeight() , Image.SCALE_SMOOTH);
                im = new ImageIcon(nimg);
                c.pic.setIcon(im);
               // c.add(c.pic);
/////////////////////////////////////////////////////////////////////////////
                ImageIcon nodeimg = new ImageIcon("src\\pic\\node.png");
                Image nie = nodeimg.getImage();
                Image nnimg = nie.getScaledInstance(30, 30 , Image.SCALE_SMOOTH);
                nodeimg = new ImageIcon(nnimg);
//////////////////////////////////////////////////////////////////////////////
                ImageIcon groundimg = new ImageIcon("src\\pic\\ground.png");
                Image gid = groundimg.getImage();
                Image ngid = gid.getScaledInstance(30, 30 , Image.SCALE_SMOOTH);
                groundimg = new ImageIcon(ngid);
//////////////////////////////////////////////////////////////////////////////
                c.l00.setBounds(20 , 580 , 60 , 20);
                c.add(c.l00);

                ///////////////////////////////////////////// 1to 6 node
                c.l1.setBounds(70 , 500 , 20 , 10);
                c.add(c.l1);

                c.l2.setBounds(170 , 500 , 20 ,10);
                c.add(c.l2);

                c.l3.setBounds(270 , 500 , 20 ,10);
                c.add(c.l3);

                c.l4.setBounds(370 , 500 , 20 ,10);
                c.add(c.l4);

                c.l5.setBounds(470 , 500 , 20 ,10);
                c.add(c.l5);

                c.l6.setBounds(570 , 500 , 20 ,10);
                c.add(c.l6);

                ///////////////////////////////////////////// 7 to 12
                c.l7.setBounds(70 , 400 , 20 , 10);
                c.add(c.l7);

                c.l8.setBounds(170 , 400 , 20 ,10);
                c.add(c.l8);

                c.l9.setBounds(270 , 400 , 20 ,10);
                c.add(c.l9);

                c.l10.setBounds(370 , 400 , 20 ,10);
                c.add(c.l10);

                c.l11.setBounds(470 , 400 , 20 ,10);
                c.add(c.l11);

                c.l12.setBounds(570 , 400 , 20 ,10);
                c.add(c.l12);
                //////////////////////////////////////////////////// 13 to 18
                c.l13.setBounds(70 , 300 , 20 , 10);
                c.add(c.l13);

                c.l14.setBounds(170 , 300 , 20 ,10);
                c.add(c.l14);

                c.l15.setBounds(270 , 300 , 20 ,10);
                c.add(c.l15);

                c.l16.setBounds(370 , 300 , 20 ,10);
                c.add(c.l16);

                c.l17.setBounds(470 , 300 , 20 ,10);
                c.add(c.l17);

                c.l18.setBounds(570 , 300 , 20 ,10);
                c.add(c.l18);
                /////////////////////////////////////// 19 to 24
                c.l19.setBounds(70 , 200 , 20 , 10);
                c.add(c.l19);

                c.l20.setBounds(170 , 200 , 20 ,10);
                c.add(c.l20);

                c.l21.setBounds(270 , 200 , 20 ,10);
                c.add(c.l21);

                c.l22.setBounds(370 , 200 , 20 ,10);
                c.add(c.l22);

                c.l23.setBounds(470 , 200 , 20 ,10);
                c.add(c.l23);

                c.l24.setBounds(570 , 200 , 20 ,10);
                c.add(c.l24);
                /////////////////////////////////////// 25 to 30

                c.l25.setBounds(70 , 100 , 20 , 10);
                c.add(c.l25);

                c.l26.setBounds(170 , 100 , 20 ,10);
                c.add(c.l26);

                c.l27.setBounds(270 , 100 , 20 ,10);
                c.add(c.l27);

                c.l28.setBounds(370 , 100 , 20 ,10);
                c.add(c.l28);

                c.l29.setBounds(470 , 100 , 20 ,10);
                c.add(c.l29);

                c.l30.setBounds(570 , 100 , 20 ,10);
                c.add(c.l30);
///////////////////////////////////////////////////////////////////////////////

                ///////////////////////////////////////////// 1to 6 node
                c.n1.setBounds(90 , 450 , 30 , 30);
                c.n1.setIcon(nodeimg);
                c.add(c.n1);

                c.n2.setBounds(190 , 450 , 30 ,30);
                c.n2.setIcon(nodeimg);
                c.add(c.n2);

                c.n3.setBounds(290 , 450 , 30 ,30);
                c.n3.setIcon(nodeimg);
                c.add(c.n3);

                c.n4.setBounds(390 , 450 , 30 ,30);
                c.n4.setIcon(nodeimg);
                c.add(c.n4);

                c.n5.setBounds(490 , 450 , 30 ,30);
                c.n5.setIcon(nodeimg);
                c.add(c.n5);

                c.n6.setBounds(590 , 450 , 30 ,30);
                c.n6.setIcon(nodeimg);
                c.add(c.n6);

                ///////////////////////////////////////////// 7 to 12
                c.n7.setBounds(90 , 350 , 30 , 30);
                c.n7.setIcon(nodeimg);
                c.add(c.n7);

                c.n8.setBounds(190 , 350 , 30 ,30);
                c.n8.setIcon(nodeimg);
                c.add(c.n8);

                c.n9.setBounds(290 , 350 , 30 ,30);
                c.n9.setIcon(nodeimg);
                c.add(c.n9);

                c.n10.setBounds(390 , 350 , 30 ,30);
                c.n10.setIcon(nodeimg);
                c.add(c.n10);

                c.n11.setBounds(490 , 350 , 30 ,30);
                c.n11.setIcon(nodeimg);
                c.add(c.n11);

                c.n12.setBounds(590 , 350 , 30 ,30);
                c.n12.setIcon(nodeimg);
                c.add(c.n12);
                //////////////////////////////////////////////////// 13 to 18
                c.n13.setBounds(90 , 250 , 30 , 30);
                c.n13.setIcon(nodeimg);
                c.add(c.n13);

                c.n14.setBounds(190 , 250 , 30 ,30);
                c.n14.setIcon(nodeimg);
                c.add(c.n14);

                c.n15.setBounds(290 , 250 , 30 ,30);
                c.n15.setIcon(nodeimg);
                c.add(c.n15);

                c.n16.setBounds(390 , 250 , 30 ,30);
                c.n16.setIcon(nodeimg);
                c.add(c.n16);

                c.n17.setBounds(490 , 250 , 30 ,30);
                c.n17.setIcon(nodeimg);
                c.add(c.n17);

                c.n18.setBounds(590 , 250 , 30 ,30);
                c.n18.setIcon(nodeimg);
                c.add(c.n18);
                /////////////////////////////////////// 19 to 24
                c.n19.setBounds(90 , 150 , 30 , 30);
                c.n19.setIcon(nodeimg);
                c.add(c.n19);

                c.n20.setBounds(190 , 150 , 30 ,30);
                c.n20.setIcon(nodeimg);
                c.add(c.n20);

                c.n21.setBounds(290 , 150 , 30 ,30);
                c.n21.setIcon(nodeimg);
                c.add(c.n21);

                c.n22.setBounds(390 , 150 , 30 ,30);
                c.n22.setIcon(nodeimg);
                c.add(c.n22);

                c.n23.setBounds(490 , 150 , 30 ,30);
                c.n23.setIcon(nodeimg);
                c.add(c.n23);

                c.n24.setBounds(590 , 150 , 30 ,30);
                c.n24.setIcon(nodeimg);
                c.add(c.n24);
                /////////////////////////////////////// 25 to 30

                c.n25.setBounds(90 , 50 , 30 , 30);
                c.n25.setIcon(nodeimg);
                c.add(c.n25);

                c.n26.setBounds(190 , 50 , 30 ,30);
                c.n26.setIcon(nodeimg);
                c.add(c.n26);

                c.n27.setBounds(290 , 50 , 30 ,30);
                c.n27.setIcon(nodeimg);
                c.add(c.n27);

                c.n28.setBounds(390 , 50 , 30 ,30);
                c.n28.setIcon(nodeimg);
                c.add(c.n28);

                c.n29.setBounds(490 , 50 , 30 ,30);
                c.n29.setIcon(nodeimg);
                c.add(c.n29);

                c.n30.setBounds(590 , 50 , 30 ,30);
                c.n30.setIcon(nodeimg);
                c.add(c.n30);
///////////////////////////////////////////////////////////////////////////////
                c.g1.setBounds(90 , 550 , 30 , 30);
                c.g1.setIcon(groundimg);
                c.add(c.g1);

                c.g2.setBounds(190 , 550 , 30 ,30);
                c.g2.setIcon(groundimg);
                c.add(c.g2);

                c.g3.setBounds(290 , 550 , 30 ,30);
                c.g3.setIcon(groundimg);
                c.add(c.g3);

                c.g4.setBounds(390 , 550 , 30 ,30);
                c.g4.setIcon(groundimg);
                c.add(c.g4);

                c.g5.setBounds(490 , 550 , 30 ,30);
                c.g5.setIcon(groundimg);
                c.add(c.g5);

                c.g6.setBounds(590 , 550 , 30 ,30);
                c.g6.setIcon(groundimg);
                c.add(c.g6);

                c.l0.setBounds(100 ,100 ,200 ,200); //// debugger
                c.add(c.l0);
            }
        });


        ////////////////////////////////////////////////////

        JFileChooser fc = new JFileChooser();

        ////////////////// filter
        //  FileFilter TextFiles = new FileNameExtensionFilter("Text file" , "txt");
        //  fc.setFileFilter(TextFiles);

        ////////////////////////////////////////////////////////////////////


        fc.setDialogTitle("Open a file");
        cfbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // FileReader infile  = new FileReader(fc.getSelectedFile());
                try {
                    FileReader infile = new FileReader(fc.getSelectedFile());
                    String[] fileContainer = new String[100]; //just contain lines of input file
                    String thisline = new String();// negah dashtan khat khandeh shode tavasot read.readLine()
                    BufferedReader reader = reader = new BufferedReader(infile);
                    for (int i = 0; (thisline = reader.readLine()) != null; i++) {
                        fileContainer[i] = thisline;
                        //   Txtbox.setText(thisline + "\n");

                    }
                } catch (IOException d) {
                    //System.err.println(d.getMessage());
                    //  JOptionPane.showMessageDialog(f1 , "Error" , JOptionPane.WARNING_MESSAGE);
                }
                // int fileContainerLocation = 0;
            }
        });
        //////////////////////////////////////////////////////// add things
        //  fc.add(f1);
        //  p1.add(cfbtn);
        //  f1.add(p1)
        f1.add(cfbtn);
        f1.add(Runbtn);
        f1.add(Txtbox);


        f1.add(l0); /// debugger lable
        f1.setSize(500, 500);
        f1.setVisible(true);
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////// rasm madar
      //  JFrame f2 = new JFrame("circuit");
      //  f2.setSize(700 , 600);

    }
}
