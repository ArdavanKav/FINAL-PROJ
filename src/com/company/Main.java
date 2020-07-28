package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
                f2.setVisible(true);
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
        f2.setSize(700 , 600);

    }
}
