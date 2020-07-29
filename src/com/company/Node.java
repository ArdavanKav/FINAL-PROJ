package com.company;
import java.util.ArrayList;

public class Node {
    int num = 0;
    boolean doesExist = false;
    ArrayList<Branch> branches = new ArrayList<>();
    ArrayList<Integer> neighbours = new ArrayList<>();
    ArrayList<Integer> unionNeighbours = new ArrayList<>();
    ArrayList<Double> Voltage = new ArrayList<>();
    double V = 0;
    int union = 0;
    boolean added = false;

}
