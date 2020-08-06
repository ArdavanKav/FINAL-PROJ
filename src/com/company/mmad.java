package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mmad {

    static ArrayList<Double> Voltage = new ArrayList<>();
    static ArrayList<Double> Current = new ArrayList<>();
    static ArrayList<Double> Power = new ArrayList<>();
    static ArrayList<String> elementsKey = new ArrayList<>();
    static Node[] node = new Node[100];
    static HashMap<String, Branch> elements = new HashMap<>();
    static double t = 0;
    static boolean err5 = false;
    static boolean err4 = false;
    static boolean err3 = false;
    static boolean err2 = false;
    static boolean err1 = false;
    static boolean invalidinput = false;
    static int errLine;
    static boolean doesExist = false;

    public static void main(String[] fileContainer) {
        String name = runWindow.selectedBranch;
        int fileContainerLocation = 0;
        String input;
        String[] sp;
        double dt = 0;
        double dv = 0;
        double di = 0;
        final boolean[] error3 = {false};

        for (int i = 0; i < 100; i++) {
            node[i] = new Node();
            node[i].union = i;
            node[i].num = i;
        }
        //-----------------------------------------------------------------------Regex:
        Pattern commentPattern = Pattern.compile("(?m)^\\*");
        Pattern resistorPattern = Pattern.compile("R");
        Pattern capacitorPattern = Pattern.compile("C");
        Pattern indactorPattern = Pattern.compile("L");
        Pattern currentSourcePattern = Pattern.compile("I");
        Pattern VoltageSourcePattern = Pattern.compile("V");
        Pattern dependent_ItoV_Pattern = Pattern.compile("G");
        Pattern dependent_ItoI_Pattern = Pattern.compile("F");
        Pattern dependent_VtoV_Pattern = Pattern.compile("E");
        Pattern dependent_VtoI_Pattern = Pattern.compile("H");
//========================================================================================================== Main While:
        while (true) {
            if(fileContainer.length == fileContainerLocation){
                err1 = true;
                return;
            }
            input = fileContainer[fileContainerLocation];
            fileContainerLocation++;
            sp = input.split(" +");
            //--------------------------------------------------------------------Matchers:
            Matcher CommentMatcher = commentPattern.matcher(input);
            Matcher resistorMatcher = resistorPattern.matcher(sp[0]);
            Matcher capacitorMatcher = capacitorPattern.matcher(sp[0]);
            Matcher inductorMatcher = indactorPattern.matcher(sp[0]);
            Matcher currentSourceMatcher = currentSourcePattern.matcher(sp[0]);
            Matcher voltageSourceMatcher = VoltageSourcePattern.matcher(sp[0]);
            Matcher dependent_ItoV_Matcher = dependent_ItoV_Pattern.matcher(sp[0]);
            Matcher dependent_ItoI_Matcher = dependent_ItoI_Pattern.matcher(sp[0]);
            Matcher dependent_VtoV_Matcher = dependent_VtoV_Pattern.matcher(sp[0]);
            Matcher dependent_VtoI_Matcher = dependent_VtoI_Pattern.matcher(sp[0]);
            //--------------------------------------------------------------------------
            try {
                if (sp[0].equals("dt")) {
                    if (realValue(sp[1]) > 0)
                        dt = realValue(sp[1]);
                    else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                } else if (sp[0].equals("dv")) {
                    if (realValue(sp[1]) > 0)
                        dv = realValue(sp[1]);
                    else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                } else if (sp[0].equals("di")) {
                    if (realValue(sp[1]) > 0)
                        di = realValue(sp[1]);
                    else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                } else if (sp[0].equals(".tran")) {
                    if (dt == 0 || dv == 0 || di == 0) {
                        err1 = true;
                        return;
                    } else {
                        if (realValue(sp[1]) > 0)
                            t = realValue(sp[1]);
                        else {
                            err1 = true;
                            return;
                        }
                    }
                    break;
                } else if (CommentMatcher.find())
                    continue;
                else if (resistorMatcher.find() || capacitorMatcher.find() || inductorMatcher.find()) {
                    resistorMatcher = resistorPattern.matcher(sp[0]);
                    capacitorMatcher = capacitorPattern.matcher(sp[0]);
                    inductorMatcher = indactorPattern.matcher(sp[0]);
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    double value = 0;
                    if (realValue(sp[3]) > 0)
                        value = realValue(sp[3]);
                    else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    Branch newBranch = new Branch();
                    if (resistorMatcher.find())
                        newBranch = new Branch("R", sp[0], in, out, value);
                    if (capacitorMatcher.find())
                        newBranch = new Branch("C", sp[0], in, out, value);
                    if (inductorMatcher.find())
                        newBranch = new Branch("L", sp[0], in, out, value);
                    elements.put(sp[0], newBranch);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(newBranch);
                    node[out].branches.add(newBranch);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (currentSourceMatcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double I0 = 0, A = 0, f = 0, fi = 0;
                    if (realValue(sp[3]) != -1000000 && realValue(sp[4]) != -1000000 && realValue(sp[5]) != -1000000 && realValue(sp[6]) != -1000000) {
                        I0 = realValue(sp[3]);
                        A = realValue(sp[4]);
                        f = realValue(sp[5]);
                        fi = realValue(sp[6]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch source = new Branch("I", sp[0], in, out, I0, A, f, fi);
                    elements.put(sp[0], source);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(source);
                    node[out].branches.add(source);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (voltageSourceMatcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double V0 = 0, A = 0, f = 0, fi = 0;
                    if (realValue(sp[3]) != -1000000 && realValue(sp[4]) != -1000000 && realValue(sp[5]) != -1000000 && realValue(sp[6]) != -1000000) {
                        V0 = realValue(sp[3]);
                        A = realValue(sp[4]);
                        f = realValue(sp[5]);
                        fi = realValue(sp[6]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch source = new Branch("V", sp[0], in, out, V0, A, f, fi);
                    elements.put(sp[0], source);
                    elementsKey.add(sp[0]);

                    node[in].branches.add(source);
                    node[out].branches.add(source);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (dependent_ItoV_Matcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double coeff = 0;
                    if (realValue(sp[5]) != -1000000) {
                        coeff = realValue(sp[5]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch DSource = new Branch("G", sp[0], in, out, Integer.parseInt(sp[3]), Integer.parseInt(sp[4]), coeff);
                    elements.put(sp[0], DSource);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(DSource);
                    node[out].branches.add(DSource);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (dependent_ItoI_Matcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double coeff = 0;
                    if (realValue(sp[4]) != -1000000) {
                        coeff = realValue(sp[4]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch DSource = new Branch("F", sp[0], in, out, sp[3], coeff);
                    elements.put(sp[0], DSource);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(DSource);
                    node[out].branches.add(DSource);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (dependent_VtoV_Matcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double coeff = 0;
                    if (realValue(sp[5]) != -1000000) {
                        coeff = realValue(sp[5]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch DSource = new Branch("E", sp[0], in, out, Integer.parseInt(sp[3]), Integer.parseInt(sp[4]), coeff);
                    elements.put(sp[0], DSource);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(DSource);
                    node[out].branches.add(DSource);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else if (dependent_VtoI_Matcher.find()) {
                    int in = Integer.parseInt(sp[1]);
                    int out = Integer.parseInt(sp[2]);
                    if (!node[in].doesExist)
                        node[in].doesExist = true;
                    if (!node[out].doesExist)
                        node[out].doesExist = true;
                    double coeff = 0;
                    if (realValue(sp[4]) != -1000000) {
                        coeff = realValue(sp[4]);
                    } else {
                        invalidinput = true;
                        errLine = fileContainerLocation;
                        return;
                    }
                    Branch DSource = new Branch("H", sp[0], in, out, sp[3], coeff);
                    elements.put(sp[0], DSource);
                    elementsKey.add(sp[0]);
                    node[in].branches.add(DSource);
                    node[out].branches.add(DSource);
                    node[in].neighbours.add(out);
                    node[out].neighbours.add(in);
                } else{
                    invalidinput = true;
                    errLine = fileContainerLocation;
                    return;
                }
            } catch (Exception e) {
                invalidinput = true;
                errLine = fileContainerLocation;
                return;
            }
        }

        if(elementsKey.contains(name))
            doesExist = true;
        else if(!name.equals(""))
            return;

        int nodeCounter = 0;
        for (int i = 1; i < 100; i++)
            if (node[i].doesExist){
                nodeCounter++;
            }

        //-----------------------------------------------------------------------------------------------------------Errors:

        if (!error4(node, elements, elementsKey)){
            err4 = true;
            return;
        }
        if (!error5(node, elements, elementsKey, nodeCounter)){
            err5 = true;
            return;
        }


        //--------------------------------------------------------------------------------------------------union class:
        class Union {
            Node mainNode = new Node();
            ArrayList<Node> nodes = new ArrayList<>();
            ArrayList<Branch> branches = new ArrayList<>();
            ArrayList<Branch> innerSource = new ArrayList<>();
            ArrayList<Integer> neighbours = new ArrayList<>();
            double I1 = 0, I2 = 0;

            void addNode(Node node1) {
                if (nodes.size() == 0)
                    this.mainNode = node1;
                nodes.add(node1);
                for (Branch s : node1.branches) {
                    if (s.type.equals("V") || s.type.equals("H") || s.type.equals("E")) {
                        if (!innerSource.contains(s))
                            innerSource.add(s);
                    } else if (!branches.contains(s))
                        branches.add(s);
                }
            }

            void setNeighbours() {
                for (Branch s : innerSource) {
                    nodes.get(nodes.indexOf(node[s.in])).unionNeighbours.add(s.out);
                    nodes.get(nodes.indexOf(node[s.out])).unionNeighbours.add(s.in);
                }
            }

            void updateUnion(double Vn) {

                for (Node s : node)
                    s.added = false;
                ArrayList<Integer> sff = new ArrayList<>();
                node[mainNode.num].added = true;
                node[mainNode.num].V = Vn;
                sff.add(mainNode.num);
                for (Branch s : innerSource)
                    s.I = 0;
                for (Branch s : innerSource)
                    s.seen = false;
                for (int i = 0; i < sff.size(); i++) {
                    for (Branch s : innerSource) {
                        if (s.in == sff.get(i) && nodes.contains(node[s.out]) && !sff.contains(s.out)) {
                            sff.add(s.out);
                            node[s.out].V = node[s.in].V + s.V;
                        } else if (s.out == sff.get(i) && nodes.contains(node[s.in]) && !sff.contains(s.in)) {
                            sff.add(s.in);
                            node[s.in].V = node[s.out].V - s.V;
                        } else if (sff.contains(s.out) && sff.contains(s.in) && node[s.out].V != node[s.in].V + s.V)
                            error3[0] = true;
                        else if (sff.contains(s.out) && sff.contains(s.in) && node[s.out].V == node[s.in].V + s.V)
                            node[s.out].V = node[s.in].V + s.V;
                        else if (sff.contains(s.in) && sff.contains(s.out) && node[s.in].V != node[s.out].V - s.V)
                            error3[0] = true;
                        else if (sff.contains(s.in) && sff.contains(s.out) && node[s.in].V == node[s.out].V - s.V)
                            node[s.in].V = node[s.out].V - s.V;

                        if (sff.get(i) == s.in && s.seen == false && s.in != 0) {
                            for (Branch q : node[sff.get(i)].branches) {
                                if (sff.get(i) == q.out && !q.name.equals(s.name))
                                    s.I += q.I;
                                else if (sff.get(i) == q.in && !q.name.equals(s.name))
                                    s.I -= q.I;
                            }
                            s.seen = true;
                        } else if (sff.get(i) == s.out && s.seen == false && s.out != 0) {
                            for (Branch q : node[sff.get(i)].branches) {

                                if (sff.get(i) == q.in && !q.name.equals(s.name))
                                    s.I += q.I;
                                else if (sff.get(i) == q.out && !q.name.equals(s.name))
                                    s.I -= q.I;
                            }
                            s.seen = true;
                        }
                    }
                }
            }
        }
        //------------------------------------------------------------------------------------------------ create union:

        int saf[] = new int[100];
        saf[0] = 0;
        node[0].added = true;
        int safCounter = 0;
        for (int i = 0; i <= nodeCounter; i++) {
            for (Branch s : node[saf[i]].branches) {
                if (s.type.equals("V") || s.type.equals("H") || s.type.equals("E")) {
                    if (!node[s.in].added && s.out == saf[i])
                        node[s.in].union = node[saf[i]].union;
                    else if (node[s.in].added && s.out == saf[i]) {
                        int unionP = node[saf[i]].union;
                        for (int j = 0; j <= nodeCounter; j++) {
                            if (node[j].union == unionP)
                                node[j].union = node[s.in].union;
                        }
                    }
                    if (!node[s.out].added && s.in == saf[i])
                        node[s.out].union = node[saf[i]].union;
                    else if (node[s.out].added && s.in == saf[i]) {
                        int unionP = node[saf[i]].union;
                        for (int j = 0; j <= nodeCounter; j++) {
                            if (node[j].union == unionP)
                                node[j].union = node[s.out].union;
                        }
                    }
                }
            }

            for (int s : node[saf[i]].neighbours) {
                if (!node[s].added) {
                    node[s].added = true;
                    safCounter++;
                    saf[safCounter] = node[s].num;
                }
            }
        }
        Union union[] = new Union[100];
        int unionCounter = 0;

        for (int i = 0; i <= nodeCounter; i++) {
            union[i] = new Union();
            node[i].added = false;
        }

        for (int i = 0; i <= nodeCounter; i++) {
            if (node[i].added)
                continue;

            for (int j = 0; j <= nodeCounter; j++) {
                if (node[j].added)
                    continue;
                else if (node[i].union == node[j].union) {
                    union[unionCounter].addNode(node[j]);
                    node[j].added = true;
                }
            }
            unionCounter++;
        }

        for (int i = 0; i < unionCounter; i++)
            union[i].setNeighbours();

        for (String s : elementsKey) {
            if (node[elements.get(s).in].union != node[elements.get(s).out].union && !union[node[elements.get(s).in].union].neighbours.contains(node[elements.get(s).out].union) && !union[node[elements.get(s).out].union].neighbours.contains(node[elements.get(s).in].union)) {
                union[node[elements.get(s).in].union].neighbours.add(node[elements.get(s).out].union);
                union[node[elements.get(s).out].union].neighbours.add(node[elements.get(s).in].union);
            }
        }

        union[0].updateUnion(0);

        //------------------------------------------------------------------------------------------------------Analyze:

        double time = 0;
        int iii=0;

        while(time <= t){

            for(Node s: node)
                s.V = 0;
            union[0].updateUnion(0);

            for(String key: elementsKey){
                if(!elements.get(key).type.equals("L") && !elements.get(key).type.equals("I") && !elements.get(key).type.equals("G") && !elements.get(key).type.equals("F"))
                    elements.get(key).I = 0;
                if(!elements.get(key).type.equals("V") && !elements.get(key).type.equals("E") && !elements.get(key).type.equals("H"))
                    elements.get(key).V = 0;
            }

            while (true) {
                boolean exit = true;
                for (int i = 1; i < unionCounter; i++) {
                    for (String ss : elementsKey) {
                        Branch s = elements.get(ss);
                        s.updateBranch(elements.get(s.name), node, dt, dv);
                        if (union[i].nodes.contains(node[s.in]) && !union[i].nodes.contains(node[s.out]))
                            union[i].I1 += s.I;
                        if (union[i].nodes.contains(node[s.out]) && !union[i].nodes.contains(node[s.in]))
                            union[i].I1 -= s.I;
                    }

                    union[i].updateUnion(union[i].mainNode.V + dv);
                    for (Branch s : union[i].branches) {
                        s.updateBranch(elements.get(s.name), node, dt, dv);
                        if (union[i].nodes.contains(node[s.in]) && !union[i].nodes.contains(node[s.out]) && !s.type.equals("C"))
                            union[i].I2 += s.I;
                        if (union[i].nodes.contains(node[s.out]) && !union[i].nodes.contains(node[s.in]) && !s.type.equals("C"))
                            union[i].I2 -= s.I;
                        if(s.type.equals("C")){
                            if(union[i].nodes.contains(node[s.in]) && !union[i].nodes.contains(node[s.out]))
                                union[i].I2 += s.currentP;
                            if(union[i].nodes.contains(node[s.out]) && !union[i].nodes.contains(node[s.in]))
                                union[i].I2 -= s.currentN;
                        }
                    }
                    union[i].updateUnion(union[i].mainNode.V - dv);
                }

                for (int i = 1; i < unionCounter; i++) {
                    union[i].updateUnion(union[i].mainNode.V + ((Math.abs(union[i].I1) - Math.abs(union[i].I2)) / di) * dv);
                    if(union[i].I1 * union[i].I2 >= 0)
                        exit = false;
                    if(union[i].I1 == union[i].I2 || Math.abs(union[i].I1) <= 0.001 || Math.abs(union[i].I2) <= 0.001)
                        exit = true;
                    union[i].I1 = 0;
                    union[i].I2 = 0;
                }
                if(exit)
                    break;
            }


            for(String s: elementsKey)
                elements.get(s).updateSpecial(elements.get(s), node, dt);
            for(String key: elementsKey)
                elements.get(key).updateSource(elements.get(key), node, elements, time);

            for (int i = 0; i <= nodeCounter; i++)
                node[i].Voltage.add(node[i].V);
            for (String i : elementsKey) {
                if(!elements.get(i).type.equals("C"))
                    elements.get(i).updateBranch(elements.get(i), node, dt, dv);
                elements.get(i).Voltage.add(elements.get(i).V);
                elements.get(i).Current.add(elements.get(i).I);
                elements.get(i).Power.add(elements.get(i).p);
            }
            if (!error4(node, elements, elementsKey))
                err4 = true;
            if (!error2(node, elements, elementsKey, nodeCounter))
                err2 = true;
            if (error3[0])
                err3 = true;
            time += dt;
        }
        if(!name.equals("")){
            Voltage = elements.get(name).Voltage;
            Current = elements.get(name).Current;
            Power = elements.get(name).Power;
        }

    }
    //==================================================================================================================


    static double realValue(String str) {
        Pattern pattern1 = Pattern.compile("[pnumkMG]");
        Pattern pattern2 = Pattern.compile("^-?[0-9]+\\.?[0-9]*[pnumkMG]?$");
        Pattern number = Pattern.compile("[-0-9.]+");
        Matcher matcher = pattern1.matcher(str);
        Matcher matcher2 = pattern2.matcher(str);
        Matcher numMatcher = number.matcher(str);
        int pow = 0;
        double num = 0;
        if (matcher2.find()) {
            if (numMatcher.find())
                num = Double.parseDouble(numMatcher.group());
            if (matcher.find()) {
                if (matcher.group().equals("p"))
                    pow = -12;
                if (matcher.group().equals("n"))
                    pow = -9;
                if (matcher.group().equals("u"))
                    pow = -6;
                if (matcher.group().equals("m"))
                    pow = -3;
                if (matcher.group().equals("k"))
                    pow = 3;
                if (matcher.group().equals("M"))
                    pow = 6;
                if (matcher.group().equals("G"))
                    pow = 9;
            }
        } else
            return -1000000;
        return num * Math.pow(10, pow);
    }


    static boolean error2(Node node[], HashMap<String, Branch> elements, ArrayList<String> keys, int nodeCounter) {
        ArrayList<Integer> cutSet = new ArrayList<>();
        for (int i = 1; i <= nodeCounter; i++)
            node[i].added = false;
        int I = 0;

        for (String key : keys) {
            if (!elements.get(key).type.equals("I") && !elements.get(key).type.equals("G") && !elements.get(key).type.equals("F"))
                continue;

            I = 0;
            for (int i = 0; i <= nodeCounter; i++)
                node[i].added = false;
            cutSet.clear();
            cutSet.add(elements.get(key).in);
            node[elements.get(key).in].added = true;

            for (int i = 0; i < cutSet.size(); i++) {
                for (Branch s : node[cutSet.get(i)].branches) {
                    if (!s.type.equals("I") && !s.type.equals("G") && !s.type.equals("F")) {
                        if (!node[s.in].added) {
                            node[s.in].added = true;
                            cutSet.add(s.in);
                        }
                        if (!node[s.out].added) {
                            node[s.out].added = true;
                            cutSet.add(s.out);
                        }
                    } else if (s.in == cutSet.get(i))
                        I += s.I;
                    else if (s.out == cutSet.get(i))
                        I -= s.I;
                }
            }
            if (I != 0 && !cutSet.contains(0) && cutSet.size() != nodeCounter + 1)
                return false;
        }

        for (int i = 1; i <= nodeCounter; i++)
            node[i].added = false;

        return true;
    }


    static boolean error4(Node node[], HashMap<String, Branch> elements, ArrayList<String> keys) {

        if (!node[0].doesExist)
            return false;
        for (String s : keys)
            if (elements.get(s).in == 0 && elements.get(s).out == 0 && elements.get(s).V != 0)
                return false;
        return true;
    }


    static boolean error5(Node node[], HashMap<String, Branch> elements, ArrayList<String> keys, int nodeCounter) {
        ArrayList<Integer> cutSet = new ArrayList<>();
        ArrayList<Integer> saf = new ArrayList<>();
        for (int i = 1; i <= nodeCounter; i++)
            node[i].added = false;
        node[0].added = true;
        saf.add(0);
        for (int i = 0; i < saf.size(); i++) {
            for (int s : node[saf.get(i)].neighbours)
                if (!node[s].added) {
                    saf.add(s);
                    node[s].added = true;
                }
        }
        if (nodeCounter != saf.size() - 1)
            return false;
        for (String key : keys) {
            if (elements.get(key).type.equals("V") || elements.get(key).type.equals("E") || elements.get(key).type.equals("H"))
                continue;
            boolean exit = false;
            for (String s : keys) {
                if (s.equals(key))
                    continue;
                else if (elements.get(s).in == elements.get(key).in && elements.get(s).out == elements.get(key).out)
                    exit = true;
                else if (elements.get(s).out == elements.get(key).in && elements.get(s).in == elements.get(key).out)
                    exit = true;
            }
            if (exit)
                continue;
            for (int i = 0; i <= nodeCounter; i++)
                node[i].added = false;
            cutSet.clear();
            cutSet.add(elements.get(key).in);
            node[elements.get(key).in].added = true;
            for (int i = 0; i < cutSet.size(); i++) {
                for (int s : node[cutSet.get(i)].neighbours) {
                    if (cutSet.get(i) == elements.get(key).in && s == elements.get(key).out)
                        continue;
                    if (!node[s].added) {
                        cutSet.add(s);
                        node[s].added = true;
                    }
                }
            }
            if (cutSet.size() != nodeCounter + 1){
                System.out.println(nodeCounter+1 +" "+ cutSet.size()+" "+key);
                return false;
            }

        }
        for (int i = 0; i <= nodeCounter; i++)
            node[i].added = false;

        return true;
    }

}