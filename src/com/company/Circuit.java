package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circuit {

    JFrame circuit = new JFrame("circuit");
    JLabel dl = new JLabel();

    ImageIcon nodeimg = new ImageIcon("src\\pic\\node.png");
    ImageIcon groundimg = new ImageIcon("src\\pic\\ground.jpg");

    void main(ArrayList<Branch> elements){

        circuit.setSize(700 , 650);

        Image nie = nodeimg.getImage();
        Image nnimg = nie.getScaledInstance(30, 30 , Image.SCALE_SMOOTH);
        nodeimg = new ImageIcon(nnimg);

        Image gid = groundimg.getImage();
        Image ngid = gid.getScaledInstance(30, 30 , Image.SCALE_SMOOTH);
        groundimg = new ImageIcon(ngid);

        for (int i = 1 ; i<= 30 ; i++){
            if(i>=1 && i<=6)
                lablepic(circuit,nodeimg,90+100*(i-1) , 450 , 30 ,30);
            lablepic(circuit, groundimg , 90+100*(i-1) , 550 , 30 ,30);
            if(i>=7 && i<=12)
                lablepic(circuit,nodeimg,90+100*(i-7) , 350 , 30 ,30);
            if(i>=13 && i<=18)
                lablepic(circuit,nodeimg,90+100*(i-13) , 250 , 30 ,30);
            if(i>=19 && i<=24)
                lablepic(circuit,nodeimg,90+100*(i-19) , 150 , 30 ,30);
            if(i>=25 && i<=30)
                lablepic(circuit,nodeimg,90+100*(i-25) , 50 , 30 ,30);

        }

        for (int i = 1 ; i<= 30 ; i++){

            String s = String.valueOf(i);

            if(i>=1 && i<=6)
                lablewrite(circuit,s,70+100*(i-1) , 480 , 20 ,10);
            if(i>=7 && i<=12)
                lablewrite(circuit,s,70+100*(i-7) , 380 , 20 ,10);
            if(i>=13 && i<=18)
                lablewrite(circuit,s,70+100*(i-13) , 280 , 20 ,10);
            if(i>=19 && i<=24)
                lablewrite(circuit,s,70+100*(i-19) , 180 , 20 ,10);
            if(i>=25 && i<=30)
                lablewrite(circuit,s,70+100*(i-25) , 80 , 20 ,10);


        }

        ImageIcon rv = new ImageIcon("src\\pic\\resistorvertical.jpg");
        Image nrv = rv.getImage();
        Image nnrv = nrv.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        rv = new ImageIcon(nnrv);

        ImageIcon rh = new ImageIcon("src\\pic\\resistorhorizental.png");
        Image nrh = rh.getImage();
        Image nnrh = nrh.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        rh = new ImageIcon(nnrh);

        ImageIcon ch = new ImageIcon("src\\pic\\capacitorhorizental.jpg");
        Image nch = ch.getImage();
        Image nnch = nch.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        ch = new ImageIcon(nnch);

        ImageIcon cv = new ImageIcon("src\\pic\\capacitorvertical.jpg");
        Image ncv = cv.getImage();
        Image nncv = ncv.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        cv = new ImageIcon(nncv);

        ImageIcon lh = new ImageIcon("src\\pic\\inductorhorizental.jpg");
        Image nlh = lh.getImage();
        Image nnlh = nlh.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        lh = new ImageIcon(nnlh);

        ImageIcon lv = new ImageIcon("src\\pic\\inductorvertical.jpg");
        Image nlv = lv.getImage();
        Image nnlv = nlv.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        lv = new ImageIcon(nnlv);

        ImageIcon cshr = new ImageIcon("src\\pic\\cshorizentalr.jpg");
        Image ncshr = cshr.getImage();
        Image nncshr = ncshr.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        cshr = new ImageIcon(nncshr);

        ImageIcon cshl = new ImageIcon("src\\pic\\cshorizentall.jpg");
        Image ncshl = cshl.getImage();
        Image nncshl = ncshl.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        cshl = new ImageIcon(nncshl);

        ImageIcon csvu = new ImageIcon("src\\pic\\csverticalu.jpg");
        Image ncsvu= csvu.getImage();
        Image nncsvu = ncsvu.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        csvu = new ImageIcon(nncsvu);

        ImageIcon csvd = new ImageIcon("src\\pic\\csverticald.jpg");
        Image ncsvd= csvd.getImage();
        Image nncsvd = ncsvd.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        csvd = new ImageIcon(nncsvd);

        ImageIcon vshr = new ImageIcon("src\\pic\\vshorizentalr.jpg");
        Image nvshr = vshr.getImage();
        Image nnvshr = nvshr.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        vshr = new ImageIcon(nnvshr);

        ImageIcon vshl = new ImageIcon("src\\pic\\vshorizentall.jpg");
        Image nvshl = vshl.getImage();
        Image nnvshl = nvshl.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        vshl = new ImageIcon(nnvshl);

        ImageIcon vsvu = new ImageIcon("src\\pic\\vsverticalu.jpg");
        Image nvsvu= vsvu.getImage();
        Image nnvsvu = nvsvu.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        vsvu = new ImageIcon(nnvsvu);

        ImageIcon vsvd = new ImageIcon("src\\pic\\vsverticald.jpg");
        Image nvsvd= vsvd.getImage();
        Image nnvsvd = nvsvd.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        vsvd = new ImageIcon(nnvsvd);

        ImageIcon dvshr = new ImageIcon("src\\pic\\dvshorizentalr.jpg");
        Image ndvshr = dvshr.getImage();
        Image nndvshr = ndvshr.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        dvshr = new ImageIcon(nndvshr);

        ImageIcon dvshl = new ImageIcon("src\\pic\\dvshorizentall.jpg");
        Image ndvshl = dvshl.getImage();
        Image nndvshl = ndvshl.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        dvshl = new ImageIcon(nndvshl);

        ImageIcon dvsvu = new ImageIcon("src\\pic\\dvsverticalu.jpg");
        Image ndvsvu= dvsvu.getImage();
        Image nndvsvu = ndvsvu.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        dvsvu = new ImageIcon(nndvsvu);

        ImageIcon dvsvd = new ImageIcon("src\\pic\\dvsverticald.jpg");
        Image ndvsvd= dvsvd.getImage();
        Image nndvsvd = ndvsvd.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        dvsvd = new ImageIcon(nndvsvd);

        ImageIcon dcshr = new ImageIcon("src\\pic\\dcshorizentalr.jpg");
        Image ndcshr = dcshr.getImage();
        Image nndcshr = ndcshr.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        dcshr = new ImageIcon(nndcshr);

        ImageIcon dcshl = new ImageIcon("src\\pic\\dcshorizentall.jpg");
        Image ndcshl = dcshl.getImage();
        Image nndcshl = ndcshl.getScaledInstance(70, 10 , Image.SCALE_SMOOTH);
        dcshl = new ImageIcon(nndcshl);

        ImageIcon dcsvu = new ImageIcon("src\\pic\\dcsverticalu.jpg");
        Image ndcsvu= dcsvu.getImage();
        Image nndcsvu = ndcsvu.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        dcsvu = new ImageIcon(nndcsvu);

        ImageIcon dcsvd = new ImageIcon("src\\pic\\dcsverticald.jpg");
        Image ndcsvd= dcsvd.getImage();
        Image nndcsvd = ndcsvd.getScaledInstance(10, 70 , Image.SCALE_SMOOTH);
        dcsvd = new ImageIcon(nndcsvd);

        //--------------------------------------------------------------------------------------------------------

        ArrayList <Branch> p1 = new ArrayList() ;
        ArrayList<Branch> d2 = new ArrayList<>() ;



        for (int i = 0 ; i<=elements.size()-1 ; i++){
            for (int j = i+1 ; j< elements.size() ; j++){  //// firs paralel

                if(isparalel(elements.get(i) , elements.get(j))==1){
                  //  System.out.print(elements.get(j).type);
                    p1.add(elements.get(j)) ;
                    // Branches.remove(j);
                    //i-- ;
                }
            }
        }

        for (int i = 0 ; i<=p1.size()-1 ; i++){
            for (int j = i+1 ; j< p1.size() ; j++){  //// second paralel

                if(isparalel(p1.get(i) , p1.get(j))==1){
                    //  System.out.print(p1.get(j).type);
                    d2.add(p1.get(j)) ;
                    //   p1.remove(j);
                    //i-- ;
                }
            }
        }





        //  Iterator it = Branches.iterator();
        for (int i = 0 ; i< elements.size() ; i++) {   //// main elements

            int f = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (isparalel(elements.get(i), elements.get(j)) == 1)
                    f = 1;
            }
            if (f == 0) {
                if (elements.get(i).direction(elements.get(i)) == 1)
                    lablewrite(circuit, elements.get(i).name, x(elements.get(i).in, elements.get(i).out) - 20, y(elements.get(i).in, elements.get(i).out) + 70, 20, 10);
                else
                    lablewrite(circuit, elements.get(i).name, x(elements.get(i).in, elements.get(i).out) + 80, y(elements.get(i).in, elements.get(i).out) - 10, 20, 10);


                if (elements.get(i).type.equals("R")) {
                    if (elements.get(i).direction(elements.get(i)) == 1)
                        lablepic(circuit, rv, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, rh, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);
                }
                if (elements.get(i).type.equals("C")) {
                    if (elements.get(i).direction(elements.get(i)) == 1)
                        lablepic(circuit, cv, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, ch, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);

                }
                if (elements.get(i).type.equals("L")) {
                    if (elements.get(i).direction(elements.get(i)) == 1)
                        lablepic(circuit, lv, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, lh, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);

                }
                if (elements.get(i).type.equals("I")) {
                    if (elements.get(i).direction(elements.get(i)) == 1) {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, csvd, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, csvu, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);

                    } else {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, cshl, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);
                        else
                            lablepic(circuit, cshr, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);


                    }
                }

                if (elements.get(i).type.equals("V")) {
                    if (elements.get(i).direction(elements.get(i)) == 1) {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, vsvd, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, vsvu, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);

                    } else {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, vshl, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);
                        else
                            lablepic(circuit, vshr, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);


                    }
                }
                if (elements.get(i).type.equals("E") || elements.get(i).type.equals("H")) {
                    if (elements.get(i).direction(elements.get(i)) == 1) {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, dvsvd, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dvsvu, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);

                    } else {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, dvshl, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);
                        else
                            lablepic(circuit, dvshr, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);


                    }

                }
                if (elements.get(i).type.equals("G") || elements.get(i).type.equals("F")) {
                    if (elements.get(i).direction(elements.get(i)) == 1) {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, dcsvd, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dcsvu, x(elements.get(i).in, elements.get(i).out), y(elements.get(i).in, elements.get(i).out) + 30, 10, 70);

                    } else {
                        if (elements.get(i).in > elements.get(i).out)
                            lablepic(circuit, dcshl, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);
                        else
                            lablepic(circuit, dcshr, x(elements.get(i).in, elements.get(i).out) + 30, y(elements.get(i).in, elements.get(i).out), 70, 10);


                    }

                }
            }
        }
        for (int i = 0 ; i< p1.size() ; i++) {   //// first paralel elements

            int f = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (isparalel(p1.get(i), p1.get(j)) == 1)
                    f = 1;
            }

            if (f == 0) {

                if (elements.get(i).direction(elements.get(i)) == 1)
                    lablewrite(circuit, p1.get(i).name, x(p1.get(i).in, p1.get(i).out) + 35, y(p1.get(i).in, p1.get(i).out) + 55, 20, 10);
                else
                    lablewrite(circuit, p1.get(i).name, x(p1.get(i).in, p1.get(i).out) + 40, y(p1.get(i).in, p1.get(i).out) + 35, 20, 10);


                if (p1.get(i).type.equals("R")) {
                    if (p1.get(i).direction(p1.get(i)) == 1)
                        lablepic(circuit, rv, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, rh, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);

                }
                if (p1.get(i).type.equals("C")) {
                    if (p1.get(i).direction(p1.get(i)) == 1)
                        lablepic(circuit, cv, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, ch, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);

                }
                if (p1.get(i).type.equals("L")) {
                    if (p1.get(i).direction(p1.get(i)) == 1)
                        lablepic(circuit, lv, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, lh, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);

                }
                if (p1.get(i).type.equals("I")) {
                    if (p1.get(i).direction(p1.get(i)) == 1) {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, csvd, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, csvu, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);

                    } else {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, cshl, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);
                        else
                            lablepic(circuit, cshr, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);


                    }
                }

                if (p1.get(i).type.equals("V")) {
                    if (p1.get(i).direction(p1.get(i)) == 1) {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, vsvd, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, vsvu, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);

                    } else {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, vshl, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);
                        else
                            lablepic(circuit, vshr, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);


                    }
                }
                if (p1.get(i).type.equals("E") || p1.get(i).type.equals("H")) {
                    if (p1.get(i).direction(p1.get(i)) == 1) {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, dvsvd, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dvsvu, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);

                    } else {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, dvshl, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);
                        else
                            lablepic(circuit, dvshr, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);


                    }

                }
                if (p1.get(i).type.equals("G") || p1.get(i).type.equals("F")) {
                    if (p1.get(i).direction(p1.get(i)) == 1) {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, dcsvd, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dcsvu, x(p1.get(i).in, p1.get(i).out) + 10, y(p1.get(i).in, p1.get(i).out) + 30, 10, 70);

                    } else {
                        if (p1.get(i).in > p1.get(i).out)
                            lablepic(circuit, dcshl, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);
                        else
                            lablepic(circuit, dcshr, x(p1.get(i).in, p1.get(i).out) + 30, y(p1.get(i).in, p1.get(i).out) + 10, 70, 10);


                    }

                }
            }
        }

        for (int i = 0 ; i< d2.size() ; i++) {   //// second paralel elements

            int f = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (isparalel(elements.get(i), elements.get(j)) == 1)
                    f = 1;
            }
            if (f == 0) {

                if (elements.get(i).direction(elements.get(i)) == 1)
                    lablewrite(circuit, d2.get(i).name, x(d2.get(i).in, d2.get(i).out) + 40, y(d2.get(i).in, d2.get(i).out) + 65, 20, 10);
                else
                    lablewrite(circuit, d2.get(i).name, x(d2.get(i).in, d2.get(i).out) + 50, y(d2.get(i).in, d2.get(i).out) + 45, 20, 10);


                if (d2.get(i).type.equals("R")) {
                    if (d2.get(i).direction(d2.get(i)) == 1)
                        lablepic(circuit, rv, x(d2.get(i).in, d2.get(i).out) + 20, y(p1.get(i).in, d2.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, rh, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);

                }
                if (d2.get(i).type.equals("C")) {
                    if (d2.get(i).direction(d2.get(i)) == 1)
                        lablepic(circuit, cv, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, ch, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);

                }
                if (d2.get(i).type.equals("L")) {
                    if (d2.get(i).direction(d2.get(i)) == 1)
                        lablepic(circuit, lv, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                    else
                        lablepic(circuit, lh, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);

                }
                if (d2.get(i).type.equals("I")) {
                    if (d2.get(i).direction(d2.get(i)) == 1) {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, csvd, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, csvu, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);

                    } else {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, cshl, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);
                        else
                            lablepic(circuit, cshr, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);


                    }
                }

                if (d2.get(i).type.equals("V")) {
                    if (d2.get(i).direction(d2.get(i)) == 1) {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, vsvd, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, vsvu, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);

                    } else {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, vshl, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);
                        else
                            lablepic(circuit, vshr, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);


                    }
                }
                if (d2.get(i).type.equals("E") || d2.get(i).type.equals("H")) {
                    if (d2.get(i).direction(d2.get(i)) == 1) {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, dvsvd, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dvsvu, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);

                    } else {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, dvshl, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);
                        else
                            lablepic(circuit, dvshr, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);


                    }

                }
                if (d2.get(i).type.equals("G") || d2.get(i).type.equals("F")) {
                    if (d2.get(i).direction(d2.get(i)) == 1) {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, dcsvd, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);
                        else
                            lablepic(circuit, dcsvu, x(d2.get(i).in, d2.get(i).out) + 20, y(d2.get(i).in, d2.get(i).out) + 30, 10, 70);

                    } else {
                        if (d2.get(i).in > d2.get(i).out)
                            lablepic(circuit, dcshl, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);
                        else
                            lablepic(circuit, dcshr, x(d2.get(i).in, d2.get(i).out) + 30, y(d2.get(i).in, d2.get(i).out) + 20, 70, 10);


                    }

                }
            }
        }


        circuit.add(dl);
        circuit.setVisible(true);



    }
    static void lablepic(JFrame f, ImageIcon img, int x, int y, int w, int h) {
        JLabel l = new JLabel();
        l.setBounds(x, y, w, h);
        l.setIcon(img);
        f.add(l);
    }
    static void lablewrite(JFrame f, String s , int x, int y, int w, int h) {

        JLabel l = new JLabel(s);
        l.setBounds(x, y, w, h);
        f.add(l);
    }
    static int x (int in , int out) {
        if (in < out) {
            int t = in;
            in = out;
            out = t;
        }
        if (out == 0)
            return 90 + 100 * (in - 1);   //// if vertical
        else {
            int z = (out % 6);
            return 90 + 100 * (z - 1) ;    //// if vertical
        }
    }

    static int y (int in , int out) {
        if (in < out) {
            int t = in;
            in = out;
            out = t;
        }
        if (out == 0)
            return 450  ;  //// if horizental
        else {
            int z = ((in-1) / 6);
            return 450 - 100 * z ;    /// if horizental
        }
    }
    static int isparalel (Branch a  , Branch b ){

        if(((a.out == b.out) && (a.in == b.in)) ||((a.out == b.in) && (a.in == b.out) ))
            return 1 ;
        else
            return 0 ;
    }


}
