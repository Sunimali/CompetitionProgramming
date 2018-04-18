/* 	ID:fuvec9f,sunimal1
  	TASK:milk2
  	LANG:JAVA
 */
//package milk2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class milk2 {
    int cows;
     List<Integer>time = new ArrayList<Integer>();
    int conMilk = 0;
    int conNotMilk;
    Integer[] timeValues;
   // String[] man = new String[2];

    public static void main(String[] args) {
        milk2 m = new milk2();
        m.getInput();
        m.goDown();
        m.setArray();
        m.caclValues();
        m.getOutPut();
       /* System.out.println("size=="+m.timeValues.length);
        for(int i = 0;i<m.timeValues.length;i++){
        System.out.println(m.timeValues[i]);
        }
        System.out.println("milk=="+m.conMilk);System.out.println("no=="+m.conNotMilk);
        //System.out.println(m.time.get(6));*/

    }
    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
            String sr = in.readLine();
            cows = Integer.parseInt(sr);
            // timeValues = new int[2*cows];
             for(int i = 0;i<2*cows;i++){
                 StringTokenizer st = new StringTokenizer(in.readLine());
                 time.add(i,Integer.parseInt(st.nextToken()) );
                 time.add(i+1,Integer.parseInt(st.nextToken()));

                // System.out.println("timeValues"+i+"=="+timeValues[i]);
                // System.out.println("timeValues"+(i+1)+"=="+timeValues[i+1]);
                 i++;
             }


        } catch (IOException ex) {
            Logger.getLogger(milk2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setArray(){
        timeValues = new Integer[time.size()];
        timeValues = time.toArray(timeValues);
        Arrays.sort(timeValues);
    }

    public void caclValues(){
        conNotMilk = 0;
        int rangeMilk;int rangeNoMilk = 0;

        for(int i = 1;i<timeValues.length;i = i + 2){
           rangeMilk = timeValues[i] - timeValues[i-1];
          if(i != timeValues.length-1){rangeNoMilk = timeValues[i+1] - timeValues[i];}
           if(rangeMilk>conMilk){conMilk = rangeMilk;}
           if(rangeNoMilk>conNotMilk){conNotMilk = rangeNoMilk;}
        }
    }

    public void getOutPut(){
        PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
            out.println(conMilk+" "+conNotMilk);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(milk2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void goDown(){
        /*for(int j = 1;j<5;j = j+2){
            System.out.println("j=="+j);
            for(int i = 1;i<5;i++){
                   if(i==2){j = -1;break;}
            }
        }*/
        boolean ok = true;
        int goUp = 1;
        for(int point = 1;point<time.size()-2;point = point + 2){
   /* if(point == 7){
          for(int j = 0;j<time.size();j++){System.out.println("point=="+time.get(j));}
                }*/
            //System.out.println("point=="+point+"size=="+time.size());
            A:for(int i  = point;i<time.size()-2;i = i + 2){
                //System.out.println("sss"+i+time.get(i+2));
                if(time.get(point-1)<=time.get(i+1)&time.get(i+1)<=time.get(point)){
                       // System.out.println("sss1");
                    if(time.get(point-1)<=time.get(i+2)&time.get(i+2)<=time.get(point)){
                        time.remove(i+1);time.remove(i+1);//System.out.println("a");
                        ok = false;point =  -1;break A;
                    }else{
                        //System.out.println("ii=="+time.size());
                        time.remove(i+1);time.set(point,time.get(i+1));//time.remove(point+1);
                        time.remove(i+1);//
                       // System.out.println("b");
                        ok = false;point =  -1;break A;
                    }
                 }if(time.get(i+1)<=time.get(point-1)&time.get(point-1)<=time.get(i+2)){
                    // System.out.println("sss23"+"iiii=="+i);
                    if(time.get(i+1)<=time.get(point)&time.get(point)<=time.get(i+2)){
                        time.remove(point-1);
                        time.remove(point-1);//System.out.println("c");
                        ok = false;point = -1;break A;
                    }
                    else{
                       // System.out.println("sss3");
                        time.remove(i+2);time.set(point-1,time.get(i+1));
                       // System.out.println("get"+time.get(0));System.out.println("get"+time.get(1));
                        time.remove(i+1);//System.out.println("d");
                        ok = false;point = -1;break A;
                    }
                }
            }
        }
    }

}


