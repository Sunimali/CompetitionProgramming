/*
  ID:fuvec9f,sunimal1
  TASK:friday
  LANG:JAVA
 */
//package friday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class friday {

    int yearsNO;
    int[] month;
    int[] year;
    int day[]=new int[7];
    int[] day13  = new int[7];
    public void getYearsNO() throws FileNotFoundException{
        try {
            BufferedReader in = new BufferedReader(new FileReader("friday.in"));
            yearsNO = Integer.parseInt(in.readLine());


        } catch (IOException ex) {
            Logger.getLogger(friday.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getYearArray(){
        year = new int[yearsNO];
        for(int i = 0;i<year.length;i++){
            year[i] = 1900 + i;

        }
    }
    public void setDayArray(){
        for(int i = 0;i<day.length;i++){
            day[i] = i + 1;
        }
    }
    public void intMonth(int year){
        month = new int[12];
        month[0] =  month[2] = month[4] =  month[6] = month[7] = month[9] = month[11] = 31;
        month[3] =  month[5] = month[8] = month[10] = 30;
         if (year % 4 == 0)
                  month[1] = 29;
                else
                    month[1] = 28;
                if ((year % 100 == 0) & (year % 400 != 0))
                    month[1] = 28;

     }

    public void setArray(int r){
     if(r<6){
        for(int j = 0;j<6-r;j++){day[r+1+j] = j+1; }
        for(int m = 0;m<=r;m++){day[m] = 7-r+m;}
     }
     if(r==6){
          setDayArray();
    }

    }
    public void intDays(int month){
        for(int i = 0;i<day.length;i++){
            if(day[i] == 6){day13[i] = day13[i]+ 1;}
        }
        if(month == 28){
            for(int i = 0;i<day.length;i++){
                if(day[i]==7){setArray(i);}
            }
        }
        else{
            A:for(int i = 0;i<day.length;i++){
                if(day[i]==month - 28){setArray(i);

                break A;
                }
            }
        }


    }
    public void getOutput(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
            out.print(day13[5]+" ");
            out.print(day13[6]+" ");
            for(int i = 0;i<4;i++){out.print(day13[i] + " "); }
            out.println(day13[4]);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(friday.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        friday fry = new friday();
        try {
            fry.getYearsNO();
            fry.getYearArray();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(friday.class.getName()).log(Level.SEVERE, null, ex);
        }
        fry.setDayArray();

        for(int i = 0;i<fry.year.length;i++){
            fry.intMonth(fry.year[i]);
            for(int j = 0;j<fry.month.length;j++){
                fry.intDays(fry.month[j]);
            }
        }
        fry.getOutput();
      //  fry.intMonth(1992);System.out.println("FEB"+fry.month[1]);

    }
}
