/*
  ID:fuvec9f,sunimal1
  TASK:beads
  LANG:JAVA
 */
//package beads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

class beads{
    int x;
    int amount = 0;
    int N;
    char[] necklace;
    public static void main(String[] args){
        beads bd = new beads();
        bd.getInput();
        //String nec = "rrwwwwbb" ;bd.necklace = nec.toCharArray();bd.N = bd.necklace.length;
        for(int i = 0;i<bd.N;i++){

            if(bd.getOk(i)){bd.getAmount(i);}
        }
        bd.getOutput();//System.out.println("am"+bd.amount);
    }
    public void getInput(){
         try {
            BufferedReader in = new BufferedReader(new FileReader("beads.in"));
            N = Integer.parseInt(in.readLine());

            String  nec = in.readLine();
            necklace = nec.toCharArray();

        } catch (IOException ex) {
            Logger.getLogger(beads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getAmount(int  i){

        int totalAmount = 0;



            int total1 = goRight('b',i)+goLeft('r',i,x);//System.out.println("tot1"+total1);
            int total2 = goRight('r',i)+goLeft('b',i,x);//System.out.println("tot2"+total2);
            if(total1>total2){ totalAmount=total1;
            }else{totalAmount=total2;}


       if(totalAmount>amount){ amount=totalAmount;}
    }
    public void getOutput(){
		int l = 0;
		for(int i = 0;i<N;i++){
			if(necklace[0]==necklace[i]){l++;}else{break;}
			}
			if(l==necklace.length){amount = l;}
            PrintWriter out;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
                out.println(amount);
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(beads.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   public int goRight(char color,int initial){
        int rightAmount = 0;

       for(int i = initial;i<N;i++){
           if(necklace[i] != color&necklace[i] !='w'){x=i;
                break;}else{rightAmount++;}

       }
       if(rightAmount==N-initial){

            for(int j = 0;j<initial;j++){
                if(necklace[j] != color&necklace[j] !='w'){x=j;
                     break;}else{rightAmount++;}

            }
       }return rightAmount;
   }

   public boolean getOk(int i){
       boolean ok=true;
       if(i!=0){
           if(necklace[i] ==necklace[i-1]){
               ok = false;
           }
       }else{
           if(necklace[0] ==necklace[N-1]){
               ok = false;
           }
       }return ok;
   }

   public int goLeft(char color,int initial,int x){
       int leftAmount = 0;
       this.x = x;
       if(x>initial){
       for(int i = initial;i>0;i--){

           if(necklace[i-1] != color&necklace[i-1] !='w'){
                break;}else{leftAmount++;}

       }
       if(leftAmount==initial){

            for(int j = N-1;j>x;j--){

                if(necklace[j] != color&necklace[j] !='w'){
                  break;   }else{leftAmount++;}

            }
       }}if(x<initial){
               for(int i = initial;i>x;i--){

           if(necklace[i-1] != color&necklace[i-1] !='w'){
                break;}else{leftAmount++;}

       }
       }

       return leftAmount;
   }

}

