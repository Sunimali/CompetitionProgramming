/* 	ID:fuvec9f,sunimal1
  	TASK:ariprog
  	LANG:JAVA
 */
//package ariprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ariprog {
    int n,m;
    Integer[] bisquares,output;
    ArrayList<int[]> results = new ArrayList<>();
        ArrayList<Integer> bis = new ArrayList<>();
    boolean[] input;
    


    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
            //StringTokenizer s = new StringTokenizer(in.readLine());
            n = Integer.parseInt(in.readLine());
            m = Integer.parseInt(in.readLine());
            input = new boolean[m*m*2+1];
            for(int i = 0 ;i <= m; i++){
                for(int j = i ; j <= m; j++){
                    //if(!bis.contains(i*i + j*j)){
                    if(input[i*i+j*j]){
                        //System.out.println("i,j  "+ i+" "+j);
                        //System.out.println(i*i + j*j);
                        continue;
                        //bis.add(i*i + j*j);
                    }
                    input[i*i+j*j] = true;
                    bis.add(i*i + j*j);
                }
            }
            bisquares = new Integer[bis.size()];
            bisquares =  bis.toArray(bisquares);
            Arrays.sort(bisquares);
        } catch (IOException ex) {
            Logger.getLogger(ariprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findsequences(){
        PrintWriter out = null;
        //output = new Integer[bisquares[bisquares.length+1- n]];
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
            //System.out.println(Arrays.toString(bisquares));
            for(int i = 0;i<bisquares.length - n+2 ;i++){
                for(int k = i+1;k<bisquares.length - n +2; k++){
                    int b = bisquares[k] - bisquares[i];
                    //System.out.println("b===  "+b+" i== "+ bisquares[i]);
                    if(bisquares[i] + (n - 1 )*b < input.length&&input[bisquares[i] + (n - 1 )*b]){
                    //if(Arrays.asList(bisquares).contains(bisquares[i] + (n - 1 )*b)){
                        boolean t = true;
                        A:for(int j = 1;j < n - 1; j++){
                            if(bisquares[i] + j*b < input.length && !input[bisquares[i] + j*b]){
                            //if(!Arrays.asList(bisquares).contains(bisquares[i] + j*b)){
                                t = false;
                                /*if(bisquares[i]==4 && b== 12){
                                    System.out.println(t+" boolene "+(bisquares[i] + j*b));
                                }*/
                                break A;
                            }
                        }
                        if(t== true){
                            //output[b] = bisquares[i];
                       
                            results.add(new int[]{bisquares[i],b});
                            //System.out.println(bisquares[i]+" "+ b);

                        }
                    }
                }
            }
            //output = new Integer[results.size()];
            //output =  results.toArray(output);
            Collections.sort(results,new ComparatorImpl());
            for (int[] r : results) {
                out.println(r[0]+" "+
                        r[1]);
            }
            if(results.isEmpty()){
                out.println("NONE");
            }
            out.close();
            } catch (IOException ex) {
            Logger.getLogger(ariprog.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    public static void main(String[] args) {
        ariprog a = new ariprog();
        a.getInput();
        a.findsequences();
    }

    private static class ComparatorImpl implements Comparator<int[]> {

        public ComparatorImpl() {
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


}
