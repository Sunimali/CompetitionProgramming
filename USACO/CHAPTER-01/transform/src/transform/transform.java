/*  ID:fuvec9f,sunimal1
    TASK:transform
    LANG:JAVA
 */
//package transform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;


public class transform {
    int transformType;
    char[] first;
    char[] last;
    int numbers;
    public static void main(String[] args) {
        transform t = new transform();
        t.getInput();
        
        t.dgree90(t.first);
        t.Degree180(t.first);
        t.Degree270(t.first);
        t.reflection(t.first);
        t.combination(t.first);
        t.invalid(t.first);
        t.noChange();
        t.getoutput();
    }

    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("transform.in"));
            numbers = Integer.parseInt(in.readLine());
            first = new char[numbers*numbers];
            last = new char[numbers*numbers];
             for(int i = 0;i<first.length;i = i + numbers){
                 String st = in.readLine();
                 for(int j = 0;j<numbers;j++){
                     first[j+i] = st.charAt(j);
                 }

             }
             for(int i = 0;i<first.length;i = i + numbers){
                 String st = in.readLine();
                 for(int j = 0;j<numbers;j++){
                     last[j+i] = st.charAt(j);
                 }

             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(transform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(transform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int noChange(){
        if(transformType==0){
         if(Arrays.equals(last,first)){transformType = 6;}}
         return transformType;
    }
    public char[] rotate(char[] intial){
        char[] replace = new char[intial.length];
         int l = 0;
        for(int i = intial.length-numbers;i<intial.length;i++){

            for(int j = 0;j<numbers;j++){
                replace[l] = intial[i-j*numbers];
                l++;
            }
        }
        //System.out.println("tt");
        //for(int m = 0;m<first.length;m++){System.out.println(replace[m]);}
       return replace;

    }

    public int dgree90(char[] intial){

        if(Arrays.equals(last, rotate(intial))){transformType = 1;}
         return transformType;
    }
    public char[] reflection(char[] intial){
        
          char[] replace = new char[intial.length];
          if(transformType == 0){
         int l = 0;
        for(int i = numbers-1;i<intial.length;i = i + numbers){

            for(int j = 0;j<numbers;j++){
                //System.out.println("ss"+i);
                replace[l] = intial[i-j];
                l++;
            }
        }
        if(Arrays.equals(replace,last)){transformType = 4;}
        
        }return replace;
    }
    public int Degree180(char[] intial){
        if(transformType==0){
            if(Arrays.equals(rotate(rotate(intial)),last)){transformType = 2;}
        }
        return transformType;

    }
    public int Degree270(char[] intial){
        if(transformType==0){
            if(Arrays.equals(rotate(rotate(rotate(intial))),last)){transformType = 3;}
        }
        return transformType;


    }public int combination(char[] intial){
        reflection(intial);
        if(transformType==0){
            if(dgree90(reflection(intial))==1){transformType = 5;}
            if(Degree180(reflection(intial))==2){transformType = 5;}
            if(Degree270(reflection(intial))==3){transformType = 5;}

        }
        return transformType;

    }
    public int invalid(char[] intial){
        if(transformType==0){transformType = 7;}
        return transformType;

    }
    public void getoutput(){
         PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
            out.println(transformType);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(transform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
