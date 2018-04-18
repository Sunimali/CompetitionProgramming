/*
 ID:fuvec9f,sunimal1
 TASK:gift1
 LANG:JAVA
 */
//package gift1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gift1{
  String[] members;
     String[] ngReceivers;
     int[] amount;
     BufferedReader in ;
      String giver1;
       List<String> group1 = new ArrayList<String>();
String[] magula;
  public void getFile() throws FileNotFoundException {
      try {
          in = new BufferedReader(new FileReader("gift1.in"));
          int np = Integer.parseInt(in.readLine());

          members = new String[np];

          for(int j = 0;j < np;j++){
              members[j] = in.readLine();

          }
      } catch (IOException ex) {
          Logger.getLogger(gift1.class.getName()).log(Level.SEVERE, null, ex);
      }




  }


   public void getGroup(){
     String group;


     int i  = 0;
      try {
          while((group = in.readLine()) != null){
              group1.add(i,group);

              i++;
          }
      } catch (IOException ex) {
          Logger.getLogger(gift1.class.getName()).log(Level.SEVERE, null, ex);
      }
magula = new String[group1.size()];
 magula = group1.toArray(magula);

   }
public void print(){

         amount = new int[members.length];

        for(int i = 1;i<magula.length;i++){

           giver1 = magula[i-1];

         StringTokenizer st = new StringTokenizer(magula[i]);

          int money = Integer.parseInt(st.nextToken());
          int ng = Integer.parseInt(st.nextToken());
          int giftMoney;
          if(ng!=0){
              giftMoney = money/ng;
          }
          else{giftMoney = 0;}
                ngReceivers = new String[ng];

          for(int r =0;r<ng;r++){
           ngReceivers[r] =magula[i+r+1];
          }
                           for(int j = 0;j<ngReceivers.length;j++){
                     for(int k = 0;k<members.length;k++){
                         if(ngReceivers[j].equals(members[k])){
                              amount[k] = amount[k] + giftMoney;
                         }

                     }}
                           for(int k = 0;k<members.length;k++){
                                              if(members[k].equals(giver1)){
                             amount[k] = amount[k]-giftMoney*ng;

                         }}

          i = i + ng+1;

    }
           //for(int y = 0;y<members.length;y++){System.out.println(members[y]+amount[y]);}
      try {
          PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
           for(int y = 0;y<members.length;y++){
               String tmp = members[y]+" "+amount[y];
               out.println(tmp);
           }
           out.close();
      } catch (IOException ex) {
          Logger.getLogger(gift1.class.getName()).log(Level.SEVERE, null, ex);
      }

    }





    public static void main(String[] args){

            gift1 gft = new gift1();
      try {
          gft.getFile();
          gft.getGroup();
          gft.print();
      } catch (FileNotFoundException ex) {
          Logger.getLogger(gift1.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
}
