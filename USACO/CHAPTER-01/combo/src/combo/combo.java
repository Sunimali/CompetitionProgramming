/*ID:fuvec9f,sunimal1
 TASK:combo
 LANG:JAVA
 */
//package combo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class combo {

    int N;
    ArrayList<Integer> FJC1 = new ArrayList<Integer>();
    ArrayList<Integer> FJC2 = new ArrayList<Integer>();
    ArrayList<Integer> FJC3 = new ArrayList<Integer>();
    ArrayList<Integer> MC1 = new ArrayList<Integer>();
    ArrayList<Integer> MC2 = new ArrayList<Integer>();
    ArrayList<Integer> MC3 = new ArrayList<Integer>();
    ArrayList<String> list = new ArrayList<String>();
    // Integer[] FJC1 = new Integer[5];
    /*int[] FJC2 = new int[5];
     int[] FJC3 = new int[5];
     int[] MC1 = new int[5];
     int[] MC2 = new int[5];
     int[] MC3 = new int[5];*/
    Object[] c = {FJC1, FJC2, FJC3, MC1, MC2, MC3};

    public static void main(String[] args) {
        combo c = new combo();
        c.getInput();
        c.findList();
        c.getOutput();
    }

    public void getInput() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("combo.in"));
            N = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            
                for (int i = 0; i < 3; i++) {
                    int n = Integer.parseInt(st.nextToken());
                    for (int j = -2; j < 3; j++) {
                        int l = n + j;
                        ff((ArrayList<Integer>) c[i], l);
                    }
                }
                StringTokenizer st2 = new StringTokenizer(in.readLine());
                for (int i = 3; i < 6; i++) {
                    int n = Integer.parseInt(st2.nextToken());
                    for (int j = -2; j < 3; j++) {
                        int l = n + j;
                        ff((ArrayList<Integer>) c[i], l);
                    }
                }

            



        } catch (FileNotFoundException ex) {
            Logger.getLogger(combo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(combo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ff(ArrayList<Integer> a, int l) {
        if (l == 0) {
            a.add(N);
        } else if (l == -1&N-1>0) {
            a.add(N - 1);
        }else if(l==N+1){
            a.add(1);
        }else if(l==N+2&N>=2){
           a.add(2);
             
        } else if(l<=N&l>=1){
            a.add(l);
        }else{}
        System.out.println("size=="+a);
    }

    public void findList() {
        for (int i = 0; i < FJC1.size(); i++) {
            for (int j = 0; j < FJC2.size(); j++) {
                for (int l = 0; l < FJC3.size(); l++) {
                    String lock1 = new Integer(FJC1.get(i)).toString() + new Integer(FJC2.get(j)).toString() + new Integer(FJC3.get(l)).toString();
                    if (!list.contains(lock1)) {
                        list.add(lock1);
                    }
                    
                }
            }
        }
        for (int i = 0; i < MC1.size(); i++) {
            for (int j = 0; j < MC2.size(); j++) {
                for (int l = 0; l < MC3.size(); l++) {
                    String lock2 = new Integer(MC1.get(i)).toString() + new Integer(MC2.get(j)).toString() + new Integer(MC3.get(l)).toString();
                   
                    if (!list.contains(lock2)) {
                        list.add(lock2);
                    }
                }
            }
        }
    }

    public void getOutput() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
            out.println(list.size());
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(combo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
