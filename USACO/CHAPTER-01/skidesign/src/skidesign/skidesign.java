/* ID:fuvec9f,sunimal1
 TASK:skidesign
 LANG:JAVA
 */
//package skidesign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class skidesign {
//skidesign
    
    int lowBudget = 100000000;
    int[] hills;
    int numbersCount;
    int numbers;

    public void getInput() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
            numbersCount = Integer.parseInt(in.readLine());
            //int num = 0;
            hills = new int[numbersCount];

            for (int i = 0; i < numbersCount; i++) {
                hills[i]=Integer.parseInt(in.readLine());
            }
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(skidesign.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(skidesign.class.getName()).log(Level.SEVERE, null, ex);
        }
      // numbers = num.toArray();
      // Arrays.sort(numbers);

    }

    public void calcBudget() {
        //Arrays.sort(numbers);
        for (int i=0; i<=83; i++){
            int cost=0,x;
		for (int j=0; j<hills.length; j++)
		{
			// if hill is below the interval
			if (hills[j]<i)
				x=i-hills[j];
			// if hill is above the interval
			else if (hills[j]>i+17)
				x=hills[j]-(i+17);
			// if hill is int the interval
			else
				x=0;
			cost+=x*x;
		}
		// update the minimum cost
		lowBudget=min(lowBudget,cost);
        }
        
    }
    
    public int min(int x, int y ){
        if(x>y){
            return y;
        }
        else{
            return x;
        }
    }
    public void output(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
            out.println(lowBudget);
            out.close();
            System.out.println(lowBudget);
        } catch (IOException ex) {
            Logger.getLogger(skidesign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       

    public static void main(String[] args) {
        skidesign s = new skidesign();
        s.getInput();
        s.calcBudget();
        s.output();
    }
}
       
