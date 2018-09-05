/* 	ID:fuvec9f,sunimal1
  	TASK:dualpal
  	LANG:JAVA
 */

//package dualpal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dualpal {
    static String word;
    static int startNum;
    static int wantNum;int nom;
    //int[] num;
    static List<Integer>dupal = new ArrayList<Integer>();
   
    public static void main(String[] args) {
        dualpal d = new dualpal();
        d.getInput();
        //d.findNumbers(99);
       d.findNumbers(startNum);
        d.getOutput();
    }
    public void getInput(){//3,25
        try {
            BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
            StringTokenizer s = new StringTokenizer(in.readLine()); 
            wantNum = Integer.parseInt(s.nextToken());
            startNum  = Integer.parseInt(s.nextToken())+1;
            
            //num = new int[wantNum];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dualpal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dualpal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getOutput(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
            for(int i = 0;i<dupal.size();i++ ){
                out.println(dupal.get(i));
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(dualpal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static String converter(int base,int number,StringBuilder sb){
        //String word = null;System.out.println("sb=="  +sb);
        //number = number/base;
        if(number>=base){
        switch(number%base){
            case 10:
                sb.append("A");
                break;
            case 11:
                sb.append("B");
                break;
            case 12:
                sb.append("C");
                break;
            case 13:
                sb.append("D");
                break;
            case 14:
                sb.append("E");
                break;
            case 15:
                sb.append("F");
                break;
            case 16:
                sb.append("G");
                break;
            case 17:
                sb.append("H");
                break;
            case 18:
                sb.append("I");
                break;
            case 19:
                sb.append("J");
                break;
            default:
                sb.append(number%base);break;
        }
        if(number/base>=base){converter(base,number/base,sb);}
        else{sb.append(number/base);//System.out.println(sb.toString());
             word = sb.toString();
        }
        }else{word = new Integer(number).toString();}
        /*if(){
            sb.append(number%base);}//switch statement*/
        
        
        return word;
    }
     public  void findNumbers(int numbr){
            nom = 0;
         for(int base = 2;base<=10;base++ ){
             //System.out.println(base);
             if(nom==2){break;}
            findPal(converter(base,numbr,new StringBuilder()));
         }
         if(nom==2&dupal.size()!=wantNum){dupal.add(numbr);}
         if(dupal.size()!=wantNum){numbr++;findNumbers(numbr);}
     }
     public  void findPal(String Word){
         if(Word.equals(new StringBuilder(Word).reverse().toString())){
             //System.out.println("hahaaa");
             nom++;
         }
     }
}
