/* 	ID:fuvec9f,sunimal1
  	TASK:palsquare
  	LANG:JAVA
 */

//package palsquare;

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


public class palsquare {
    int base;
    static String square;
    int mul; static int num; static String word;

    List<String>sqre = new ArrayList<String>();
    List<String>numb = new ArrayList<String>();
    public static void main(String[] args) {

        palsquare p = new palsquare();
        p.getInput();//num = 10;
        //System.out.println(converter(10,4,new StringBuilder()));
        p.findPalsquare();
       p.getOutput();
    }

    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
            base = Integer.parseInt(in.readLine());
        }catch (FileNotFoundException ex) {
            Logger.getLogger(palsquare.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(palsquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String converter(int base,int number,StringBuilder sb){
       
        if(number>=base){
            findABC(number%base,sb);
      
        if(number/base>=base){converter(base,number/base,sb);}
        else if(number/base<=9){sb.append(number/base);
             word = sb.toString();}
        else{findABC(number/base,sb);word = sb.toString();}
             
        
        }//else{word = new Integer(number).toString();}
        else{findABC(number,sb);word = sb.toString();} 
       


        return word;
    }
    public static void findABC(int no,StringBuilder sb){
    switch(no){
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
                sb.append(no);break;
        }
    }
    public  void findPalsquare(){
        for(int N  = 1;N<=300;N++){
           //int N =12;
            mul = N*N;

            //base = 15;//N = 12;
            String mull = converter(base,mul,new StringBuilder());//mull = "weaew";
            //System.out.println(mull);
            if(mull.equals(new StringBuilder(mull).reverse().toString())){
                //System.out.println("buhhh");
                sqre.add(mull);
                numb.add(new StringBuilder((converter(base,N,new StringBuilder()))).reverse().toString());
            }

        }
    }
    public void getOutput(){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
            //System.out.println(numb.size());
            for(int i = 0;i<numb.size();i++){
                //System.out.println("fgh");
                out.println(numb.get(i)+" "+sqre.get(i));
            }out.close();
        } catch (IOException ex) {
            Logger.getLogger(palsquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
