/* 	ID:fuvec9f,sunimal1
  	TASK:milk
  	LANG:JAVA
 */
 
//package milk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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


public class milk {
    int milkUnits;int farmers;
    int[] perUnit ;
    ArrayList<String> b = new ArrayList<String>();;
    ArrayList<String> a = new ArrayList<String>();
    int[] units;
    int gainUnits = 0;int cost = 0;
    int balanceUnits = 0;
    public static void main(String[] args) {
        milk m = new milk();
        m.getInput();
        //System.out.println(m.units[2]);
        //System.out.println(m.a);
        m.sort();
        m.calCost(0);
        m.getOutput();
        //for(int i = 0;i<m.farmers;i++){System.out.println(m.perUnit[i]+" "+m.units[i]);}
        
    }
    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("milk.in"));
            StringTokenizer s = new StringTokenizer(in.readLine());
            milkUnits = Integer.parseInt((s.nextToken()));
            balanceUnits = milkUnits;
            //System.out.println(milkUnits);
            farmers = Integer.parseInt((s.nextToken()));
            //System.out.println(farmers);
            perUnit = new int[farmers];
            units = new int[farmers];
            //a = new String[farmers];
            int i = 0;
            while(i!= farmers){
           
               //System.out.println("haaaa");
               StringTokenizer st = new StringTokenizer(in.readLine()); 
               perUnit[i] = (Integer.parseInt((st.nextToken())));
               units[i] = (Integer.parseInt((st.nextToken())));
               a.add(perUnit[i]+" "+units[i]); 
               i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(milk.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(milk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sort(){
        Arrays.sort(perUnit);
        A:for(int i = 0;i < farmers;i++){
            B:for(int j = 0;j < farmers;j++){
                 if(perUnit[i]==Integer.parseInt(a.get(j).substring(0,a.get(j).indexOf(" ")))){
                      units[i]=Integer.parseInt(a.get(j).substring(a.get(j).indexOf(" ")+1));//b.add(i,a.get(j));
                      a.remove(j);
                      break B;
                 } 
            }
        }
        

        
        //Arrays.sort(a);
        
        
    }
    void calCost(int i){
        if(gainUnits!=milkUnits){
            if(units[i]<=balanceUnits){
                cost = cost + perUnit[i]*units[i];
                gainUnits = gainUnits + units[i];
                balanceUnits = milkUnits - gainUnits;
            }else{
               cost = cost + perUnit[i]*balanceUnits; 
               gainUnits = gainUnits + balanceUnits;
               balanceUnits = milkUnits - gainUnits;
            }
            //System.out.println("cost=="+cost);
            //System.out.println("balanceu=="+balanceUnits);
           // System.out.println("gainunit=="+gainUnits);
          if(balanceUnits!=0&i<farmers){
              calCost(i+1);
          }  
        }
            
        
    }
    public void getOutput(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
            out.println(cost);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(milk.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
