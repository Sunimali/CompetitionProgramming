
package ruler;


public class Ruler {

    public static void main(String[] args) {
        drawRuler(2,4);
    }
    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for(int i = 0;i<nInches;i++){
        drawInterval(majorLength-1);
        drawLine(majorLength,i);
        }
    }
    public static void drawLine(int tickLength, int tickLabel){
        for (int j = 0; j < tickLength; j++){System.out.print("-");}
        if(tickLabel>=0){System.out.println(" "+tickLabel);}
        System.out.println("\n");
    }
    public static void drawLine(int tickLength) {
        drawLine(tickLength,-1);
    }
    public static void drawInterval(int centralLength) {
        if(centralLength>=1)
            drawInterval(centralLength-1);
        drawLine(centralLength);
        drawInterval(centralLength-1);
    }

    
}
