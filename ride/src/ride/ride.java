/*ID:fuvec9f,sunimal1
  TASK:ride
 LANG:JAVA
*/
//package ride;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ride {


    public int getString(String group){

        if(group.length()>6){
            group = group.substring(0,7);
        }
        int noChar = group.length();
                    System.out.println("nochar "+noChar);
        String[] charArray = new String[noChar];
        int[] valueArray = new int[noChar];
        String[] alphobet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for(int i = 0;i<charArray.length;i++){
            charArray[i] =Character.toString(group.charAt(i));
                System.out.println("char"+charArray[i]);
        }

        for(int i = 0;i<charArray.length;i++){
            for(int r = 0;r<alphobet.length;r++){
                if(charArray[i].equals(alphobet[r])){
                    valueArray[i] = r+1;
                    System.out.println("value"+valueArray[i]);
                 }
            }
        }
        int product = 1;
        for(int i = 0;i<valueArray.length;i++){
            product = product*valueArray[i];
            System.out.println("prduct"+product);
        }
        System.out.println(" "+product);
       int mod =  product%47;
       return mod;
    }

    public static void main(String[] args) {
    //   BufferedReader in;
            try {
              BufferedReader in = new BufferedReader(new FileReader("ride.in"));
                String comet= in.readLine();
                String group = in.readLine();

                 ride rd = new ride();
                 int modComet = rd.getString(comet);
                int modGroup = rd.getString(group);
                 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

                 if(modComet == modGroup){
                     out.println("GO");
                 }
                 else{
                      out.println("STAY");
                 }
                 out.close();
                System.out.println(" " +modComet);
                System.out.println(" " +modGroup);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ride.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ride.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
