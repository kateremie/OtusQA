package org.coal;

import static java.lang.Thread.sleep;

public class CoalMine {

    private static Integer capacity = 1000;
    public static synchronized Integer getCapacityAndDecreaseByTen(){
        try {
            sleep(10);
        }
        catch (InterruptedException e) {
            Thread.interrupted();
        }
    return capacity-=10;}
}
//and this