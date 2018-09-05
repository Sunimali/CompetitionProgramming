/* 	ID:fuvec9f,sunimal1
  	TASK:barn1
  	LANG:JAVA
 */

//package barn1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class barn1 {
     
    int stall;
    int cows;
    int doors;
    int[] stalls;
    Integer[] deferences;
    Integer door[];int maxStalls;
    ArrayList<Integer> st = new ArrayList<Integer>();;
    ArrayList<Integer> d = new ArrayList<Integer>();
    

    public static void main(String[] args) {
        barn1 b = new barn1();
        b.getInput();
        b.sort();
        b.FindMax();
       // b.devideGroups();
        //System.out.println(b.st);
        /*for(int i = 0;i<b.deferences.length;i++){
            System.out.println("def=="+b.deferences[i]);
        }
        for(int i = 0;i<b.door.length;i++){
            System.out.println("door=="+b.door[i]);
        }*/
       // System.out.println("de=="+b.deferences[0]+","+b.deferences[1]+","+b.deferences[2]);
       // System.out.println(b.door[0]+","+b.door[1]+","+b.door[2]);
        b.getOutput();
    }
    
    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
            
             StringTokenizer s = new StringTokenizer(in.readLine());
             doors = (Integer.parseInt((s.nextToken())));
             cows = (Integer.parseInt((s.nextToken())));
             stall = (Integer.parseInt((s.nextToken())));
             stalls = new int[stall];
             deferences = new Integer[stall-1];
            // door = new int[doors];
             for(int i = 0;i<stall;i++){
                 stalls[i] = Integer.parseInt(in.readLine());
                // st.add(Integer.parseInt(in.readLine()));
             }
             Arrays.sort(stalls);
             //for(int i = 0;i < stall;i++){System.out.println(stalls[i]);}
             
             
            // int st = 
            // while
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(barn1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(barn1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sort(){
        for(int i = 1;i<stall;i++){
            st.add(stalls[i] - stalls[i-1]);
        }
        
       deferences = st.toArray(deferences);
       Arrays.sort(deferences);
       //deferences.
       //if(d.size()!=doors-1){
       A:for(int i = 0;i<deferences.length;i++){
           B:for(int j = 0;j<deferences.length;j++){
               // System.out.println("daaa=="+deferences[deferences.length-1-i]);
               
                   if(deferences[deferences.length-1-i].equals(st.get(j))&d.size()!=doors-1){
                       //System.out.println("j=="+j+"i==="+i);
                       boolean ok = false;
                       if(d.indexOf(j)==-1){ok = true;}
                       if(ok){
                            d.add(j);
                       }
                   }
                   if(d.size()==doors-1){break A;}//else{break B;}
               }
           }
       door = new Integer[d.size()];
       door= d.toArray(door);
       Arrays.sort(door);
        
    }
    public int devideGroups(){
        
        maxStalls = stalls[door[0]] - stalls[0] + 1;
        for(int i =0;i<doors-2;i++){
           // System.out.println("max=="+maxStalls);
            //System.out.println(stalls[door[i+1]]+","+stalls[door[i]+1]);
            maxStalls = maxStalls + stalls[door[i+1]] - stalls[door[i]+1] + 1;
            
        }maxStalls = maxStalls + stalls[stalls.length-1] - stalls[door[door.length-1]+1] + 1;
        //}else if(doors<stall){maxStalls = stalls[stalls.length-1]-stalls[0]+1;}
        //else{maxStalls = stall;}
        return maxStalls;
    }
    public void FindMax(){
        if(doors>1&stall>doors){
            sort();
            maxStalls = devideGroups();
        }
        if(doors==1&stall>doors){
            maxStalls = stalls[stalls.length-1]-stalls[0]+1;
        }
        if(stall<=doors){
            maxStalls = stall;
        }
    }
    public void getOutput(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
            out.println(maxStalls);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(barn1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
