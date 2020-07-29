package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Branch {

    boolean seen = false;
    String type;
    String name;
    double I = 0;
    double V = 0;
    double p = 0;
    int in = 0 ;
    int out = 0 ;
    double value = 0;
    ArrayList<Double> Voltage = new ArrayList<>();
    ArrayList<Double> Current = new ArrayList<>();
    ArrayList<Double> Power = new ArrayList<>();
    double I0 = 0;
    double domain=0, freq=0, fi=0;

    int Vk = 0;
    int Vm = 0;
    String elementName = new String();
    double coeff = 0;

    Branch(){}
    Branch(String type, String name, int in, int out, double value){
        this.type = type;
        this.name = name;
        this.in = in;
        this.out = out;
        this.value = value;
    }
    Branch(String type, String name, int in, int out, double I0, double domain, double freq, double fi){
        this.type = type;
        this.name = name;
        this.in = in;
        this.out = out;
        this.I0 = I0;
        this.domain = domain;
        this.freq = freq;
        this.fi = fi;
        if(type.equals("I"))
            this.I = I0 + domain*Math.sin(fi);
        if(type.equals("V"))
            this.V = I0 + domain*Math.sin(fi);
    }
    Branch(String type, String name, int Vp, int Vn, int Vk, int Vm, double coeff){
        this.type = type;
        this.name = name;
        this.in = Vp;
        this.out = Vn;
        this.Vk = Vk;
        this.Vm = Vm;
        this.coeff = coeff;
    }
    Branch(String type, String name, int Vp, int Vn, String elementName, double coeff){
        this.type = type;
        this.name = name;
        this.in = Vp;
        this.out = Vn;
        this.elementName = elementName;
        this.coeff = coeff;
    }

    void updateBranch(Branch branch, Node[] node, HashMap<String, Branch> element, double time, double dt){
        if(branch.type.equals("R")){
            this.V = (node[branch.in].V - node[branch.out].V);
            this.I = (node[branch.in].V - node[branch.out].V) / branch.value;
            this.p = -V*I;
        }
        if(branch.type.equals("I")){
            this.V = (node[branch.in].V - node[branch.out].V);
            this.I = branch.I0 + branch.domain*Math.sin((2*Math.PI*branch.freq*time)+branch.fi);
            this.p = -V*I;
        }
        if(branch.type.equals("V")){
            this.V = branch.I0 + branch.domain*Math.sin((2*Math.PI*branch.freq*time)+branch.fi);
            this.p = V*I;
        }
        if(branch.type.equals("G")){
            this.V = (node[branch.in].V - node[branch.out].V);
            this.I = (node[branch.Vk].V - node[branch.Vm].V)*branch.coeff;
            this.p = -V*I;
        }
        if(branch.type.equals("F")){
            this.V = (node[branch.in].V - node[branch.out].V);
            this.I = (element.get(branch.elementName).I)*branch.coeff;
            this.p = -V*I;
        }
        if(branch.type.equals("E")){
            this.V = (node[branch.Vk].V - node[branch.Vm].V)*branch.coeff;
            this.p = V*I;
        }
        if(branch.type.equals("H")){
            this.V = (element.get(branch.elementName).I)*branch.coeff;
            this.p = V*I;
        }
    }

    void updateSpecial(Branch branch, Node[] node, double dt){
        if(branch.type.equals("C")){

            if(branch.Voltage.size() == 0)
                this.I = branch.value*(this.V/dt);
            else
                this.I = branch.value*((this.V - branch.Voltage.get(branch.Voltage.size()-1))/dt);

            if(branch.Voltage.size() != 0)
                this.V = branch.Voltage.get(branch.Voltage.size()-1) + (branch.I * dt)/branch.value;
            else
                this.V = (branch.I * dt)/branch.value;

            this.p = -V*I;
        }

        if(branch.type.equals("L")){
            this.V = (node[branch.in].V - node[branch.out].V);
            if(branch.Current.size() != 0)
                this.I = branch.Current.get(branch.Current.size()-1) + ((node[branch.in].V - node[branch.out].V)*dt)/branch.value;
            else
                this.I = ((node[branch.in].V - node[branch.out].V)*dt)/branch.value;
            this.p = -V*I;
        }

    }

}
