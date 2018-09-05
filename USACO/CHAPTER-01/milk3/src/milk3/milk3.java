/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milk3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class milk3 {

    int a,b,c;
    
    public void getInput(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
             StringTokenizer s = new StringTokenizer(in.readLine());
             a = (Integer.parseInt((s.nextToken())));
             b = (Integer.parseInt((s.nextToken())));
             c = (Integer.parseInt((s.nextToken())));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(milk3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(milk3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getOutput(){
    
    }
    public static void main(String[] args) {
        milk3 m = new milk3();
        m.getInput();
        m.getOutput();
    }
    
    
}
