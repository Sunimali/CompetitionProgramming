/* 	ID:fuvec9f,sunimal1
  	TASK:namenum
  	LANG:JAVA
 */
//package namenum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class namenum {
     //char[][] alphabet = new char[9][3];
      static int amount;
      static String word;
      static String number;
      static int l;
      static boolean ok;
     List<String>num = new ArrayList<String>();


    public static void main(String[] args) {
        namenum n = new namenum();
        n.getInput();
        n.choose();
        n.getOutput();

    }
    public void getInput(){
        /*alphabet[0][0] = 'A';alphabet[0][1] = 'B';alphabet[0][2] = 'C';//2
        alphabet[1][0] = 'D';alphabet[1][1] = 'E';alphabet[1][2] = 'F';//3
        alphabet[2][0] = 'G';alphabet[2][1] = 'H';alphabet[2][2] = 'I';//4
        alphabet[3][0] = 'J';alphabet[3][1] = 'K';alphabet[3][2] = 'L';//5
        alphabet[4][0] = 'M';alphabet[4][1] = 'N';alphabet[4][2] = 'O';//6
        alphabet[5][0] = 'P';alphabet[5][1] = 'R';alphabet[5][2] = 'S';//7
        alphabet[6][0] = 'T';alphabet[6][1] = 'U';alphabet[6][2] = 'V';//8
        alphabet[7][0] = 'W';alphabet[7][1] = 'X';alphabet[7][2] = 'Z';//9*/

        try {
            BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
            number = in.readLine();
            amount = number.length();
        } catch (FileNotFoundException ex) {
            System.out.println("threre is not file in that name");
            Logger.getLogger(namenum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(namenum.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void choose(){
         try {
             BufferedReader t = new BufferedReader(new FileReader("dict.txt"));
             int i = 0;

             while((word = t.readLine()) != null){
                 if(word.length()==amount){
                     remove(0);
                     if(ok){num.add(word);}
                 }

              i++;
          }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(namenum.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(namenum.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     public static void remove(int n){
          l = 0;ok = false;
         // System.out.println("again=="+n);
         if(word.charAt(n)=='A'|word.charAt(n)=='B'|word.charAt(n)=='C'){
             l = 2;
         }
         if(word.charAt(n)=='D'|word.charAt(n)=='E'|word.charAt(n)=='F'){
             l = 3;//System.out.println("33333k"+n);
         }
          if(word.charAt(n)=='G'|word.charAt(n)=='H'|word.charAt(n)=='I'){
              l = 4;
         }
         if(word.charAt(n)=='M'|word.charAt(n)=='N'|word.charAt(n)=='O'){
             l = 6;
         }
         if(word.charAt(n)=='T'|word.charAt(n)=='U'|word.charAt(n)=='V'){
             l = 8;
         }
         if(word.charAt(n)=='J'|word.charAt(n)=='K'|word.charAt(n)=='L'){
             l = 5;
         }
         if(word.charAt(n)=='P'|word.charAt(n)=='R'|word.charAt(n)=='S'){
             l = 7;
         }
         if(word.charAt(n)=='W'|word.charAt(n)=='X'|word.charAt(n)=='Y'){
             l = 9;
         }if(l==Integer.parseInt(number.substring(n,n+1))){
            // System.out.println("char"+number.charAt(n));
             //System.out.println(Integer.parseInt(number.substring(n,n+1)));
             ok = true;
             //if(n<=amount-1){ok = true;}
             if(n<amount-1){remove(n+1);}}//}
     }
    public void getOutput(){
         try {
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
             if(num.isEmpty()){out.println("NONE");}
             for(int i = 0;i<num.size();i++){out.println(num.get(i));}out.close();
         } catch (IOException ex) {
             Logger.getLogger(namenum.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

}
