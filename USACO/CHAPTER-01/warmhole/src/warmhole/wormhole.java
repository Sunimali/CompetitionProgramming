/* ID:fuvec9f,sunimal1
 TASK:wormhole
 LANG:JAVA
 */
//package warmhole;

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class wormhole {

    int[] x;
    int[] y;
    int[] partners;
    int[] nextRight;
    //ArrayList<Integer> y = new ArrayList<Integer>();
    int numberWarmholes;
    int pairs = 0;
    int NCR;
    int answer;

    public static void main(String[] args) {
        wormhole w = new wormhole();
        w.getInput();
        w.setNextRight();
        System.out.println(w.infiniteCircle());
        
        //System.out.println("NEXT=="+Arrays.toString(w.nextRight));
       // w.getOutput();

    }

    public void getInput() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
            numberWarmholes = Integer.parseInt(in.readLine());
            x = new int[numberWarmholes+ 1];
            y = new int[numberWarmholes +1];
            partners = new int[numberWarmholes + 1];
            nextRight = new int[numberWarmholes + 1];
            
            for (int i = 1; i <= numberWarmholes; i++) {
                StringTokenizer s = new StringTokenizer(in.readLine());
                x[i] = (Integer.parseInt(s.nextToken()));
                y[i] = (Integer.parseInt(s.nextToken()));
                //partners[i] = -1;
                //Collections.sort(y);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wormhole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(wormhole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getPairs(){
        int i,total = 0;
        for( i = 1;i<=numberWarmholes;i++){
           if(partners[i]==0){
               break;
           } 
        }
        //System.out.println("i == " + i);
        if(i>numberWarmholes ){
            //check if it is  ==a circle or not
            if(infiniteCircle()){
                //System.out.println("infinte");
                return 1;
            }
            else{
               // System.out.println("not infinite");
                return 0;
            }
        }
        for(int j = i + 1;j<=numberWarmholes;j++){
            if(partners[j]==0){
                partners[i] = j;
                partners[j] = i;
                
                int s =  getPairs();
                total = total + s;
                
                partners[i] = partners[j] = 0;
            }
            //System.out.println("s=="+s);
            //System.out.println("answer=="+total);
        }return total;
    }
    public void setNextRight(){
        for(int i = 1;i<=numberWarmholes;i++){
            //System.out.println("i=="+i);
            for(int j = 1;j<=numberWarmholes;j++){
                if(x[i]<x[j] && y[i] == y[j]){
                    //System.out.println(" j=="+j);
                    if(nextRight[i]==0){
                        nextRight[i] = j;
                    }
                    else if(x[j]-x[i]<x[nextRight[i]] - x[i]){
                        nextRight[i] = j;
                    }
                }
            }
            //System.out.println("righti=="+nextRight[i]);
        }
    
    }
    public boolean infiniteCircle(){
        //Boolean s = false;
        //System.out.println("partners"+partners);
        partners[1] = 4;
        partners[2] = 3;
        partners[3] = 2;
        partners[4] = 1;
        
        //partners[1] {0,2,1,4,3};
        for(int start = 1;start<=numberWarmholes;numberWarmholes++){
            int pos = start;
            for(int count = 0;count<numberWarmholes;count++){
                pos = nextRight[partners[pos]];
                if(pos==0){
                    return false;
                }
            }
            if(pos!=0){return true;}
            
            
        }
        return false;
        
    }
   /* public void getPairs() {
        A:
        for (int i = 0; i < y.size(); i++) {
            B:
            for (int j = 0; j < y.size(); j++) {
                if (j != i) {
                    int ok = y.get(i).compareTo(y.get(j));
                    if (ok == 0) {
                        if (i < j) {
                            y.remove(i);
                            y.remove(j - 1);
                            pairs++;
                            i = i - 1;
                            break B;

                        } else {
                            y.remove(i);
                            y.remove(j);
                            pairs++;
                            break B;
                        }
                    }
                }
            }
        }
    }

    public int NCR(int n) {
        int Nn = 1;
        int Nr = 1;
        for (int i = 1; i <= n; i++) {
            Nn = Nn * i;
        }
        for (int i = 1; i <= n - 2; i++) {
            Nr = Nr * i;
        }
        NCR = Nn / (Nr * 2);
        return NCR;
    }

    public void findAnswers() {
        int a;
        int b = 0;
        //System.out.println("s=="+x.size());
        if (x.size() - 4 > 2) {
            a = NCR(x.size() - 4) - 1;
            //System.out.println("s=="+a);
        } else {
            a = 1;
        }
        if (pairs > 1) {
            if (x.size() - 2 > 2) {
                b = NCR(x.size() - 2) - 1;
                // System.out.println("s=="+b);
            } else {
                b = 1;
            }
        }
        answer = a + b;
    }

    public void getOutput() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
            answer = getPairs();
            out.println(answer);
           // System.out.println(answer);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(wormhole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}*/

import java.util.Scanner;
import java.io.*;


public class wormhole {
	
	// Partners is one-indexed, with 0 representing a lack of a partner
	
	static int maxn = 12;
	
	static int n = 0;
	
	static int [] x = new int[maxn + 1];
	static int [] y = new int[maxn + 1];
	static int [] partners = new int[maxn + 1]; // Array with a number j at the ith index, meaning j is i's partner
	static int [] next_on_right = new int[maxn + 1];
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("wormhole.in"));
		PrintWriter pw = new PrintWriter(new File("wormhole.out"));
		
		n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			
			x[i] = x1;
			y[i] = y1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(x[j] > x[i] && y[i] == y[j]) {
					if(next_on_right[i] == 0 || x[j] - x[i] < x[next_on_right[i]] - x[i]) {
						next_on_right[i] = j;
					}
				}
			}
		}
		
		in.close();
		
		pw.println(solve());
		
		pw.close();
	}

	private static int solve() {
		
		int total = 0;
		
		// We first find i such that it doesnt have a partner
		
		int i = 0;
		
		for(i = 1; i <= n; i++) {
			if(partners[i] == 0)
				break;
		}
		
		if(i > n) {
			if(isCycle()) return 1;
			
			else return 0;
		}
		
		for(int j = i + 1; j <= n; j++) {
				
			if(partners[j] == 0) {
				//Now we try pairing i and j
				partners[i] = j;
				partners[j] = i;
				total += solve();
				partners[i] = partners[j] = 0;
			}
		}
		
		return total;
	}

	public static boolean isCycle() {
		for(int start = 1; start <= n; start++) {
			int pos = start;
			for(int count = 0; count < n; count++) {
				pos = next_on_right[partners[pos]];
			}
			
			if(pos != 0) return true;
		}
		
		return false;
	}

}
