/* 	ID:fuvec9f,sunimal1
 TASK:crypt1
 LANG:JAVA
 */
//package crypt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class crypt1 {

    int N;
    Integer[] digits;
    ArrayList<Integer> digit3 = new ArrayList<Integer>();
    String word;
    ArrayList<Integer> particles = new ArrayList<Integer>();
    Integer solutions = 0;
    int crypt = 0;

    public static void main(String[] args) {
        crypt1 c = new crypt1();
        c.getInput();
        c.getDigit3();
        //c.findParticles();
        c.getOutput();
        //System.out.println("list==" + c.digit3);

    }

    public void getInput() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
            N = Integer.parseInt(in.readLine());
            digits = new Integer[N];
            word = in.readLine();
            StringTokenizer s = new StringTokenizer(word);
            for (int i = 0; i < N; i++) {
                digits[i] = Integer.parseInt(s.nextToken());
            }
            Arrays.sort(digits);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(crypt1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(crypt1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getDigit3() {
        int first = Integer.parseInt(new Integer(digits[0]).toString() + new Integer(digits[0]).toString() + new Integer(digits[0]).toString());
        int last = Integer.parseInt(new Integer(digits[N - 1]).toString() + new Integer(digits[N - 1]).toString() + new Integer(digits[N - 1]).toString());

        //System.out.println("frst"+first);
        //System.out.println("frst"+last);

        //System.out.println("ff"+new Integer(23).toString().indexOf('2'));
        A:
        for (int i = first; i <= last; i++) {
            if (check(i)) {
                digit3.add(i);
            }
        }
    }

    public ArrayList findParticles(int i) {
        particles.clear();
        for (int j = 0; j < N; j++) {
            //for(int i = 0;i<digit3.size();i++){

            if (digits[j] * digit3.get(i) < 1000 & check(digits[j] * digit3.get(i))) {

                particles.add(digits[j] * digit3.get(i));

            }
            // }
        }
        return particles;
    }

    public void fintCrypt(int i) {
        findParticles(i);
        //System.out.println("particles==" + particles);
        for (int l = 0; l < particles.size(); l++) {
            for (int j = l; j < particles.size(); j++) {
                solutions = particles.get(l) + 10 * particles.get(j);
                if (check(solutions)) {
                    crypt++;
                   // System.out.println(particles.get(l) + "," + particles.get(j) + "," + solutions);
                }
                if (l != j) {
                    solutions = particles.get(j) + 10 * particles.get(l);
                    if (check(solutions)) {
                        crypt++;
                       // System.out.println("***" + particles.get(l) + "," + particles.get(j) + "," + solutions);
                    }
                }
            }
        }
        /*for(int j = i-1;j>=0;j--){
         solutions = particles.get(i) + 10*particles.get(j);
         if(check(solutions)){
         crypt++;
         System.out.println("s0=="+solutions+",par=="+particles.get(i)+","+particles.get(j));
         }
         }*/

    }

    public boolean check(int i) {
        boolean ok = false;
        int x = 0;
        B:
        for (int l = 0; l < new Integer(i).toString().length(); l++) {
            if (word.indexOf(new Integer(i).toString().charAt(l)) == -1) {//
                break B;//
            } else {
                x++;
            }

        }
        if (x == new Integer(i).toString().length()) {
            ok = true;
        }
        return ok;
    }

    public void getOutput() {
        for (int i = 0; i < digit3.size(); i++) {
            fintCrypt(i);
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
            out.println(crypt);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(crypt1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
