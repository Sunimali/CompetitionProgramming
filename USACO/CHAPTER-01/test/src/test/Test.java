
package test;

import java.util.ArrayList;
import java.util.List;


public class Test {


    public static void main(String[] args) {
        List<Integer>time = new ArrayList<Integer>();
        time.add(1);time.add(3);time.add(4);time.add(5);time.add(2);time.add(6);
        time.set(1,time.get(4));
        System.out.println("time=="+time.get(0)+time.get(1)+time.get(2)+time.get(3)+time.get(4)+
             time.get(5)  );
    }
}
