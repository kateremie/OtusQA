package threadsafe.tests;

import org.junit.Test;
import threadsafe.GetInformatiomThreadSafe;

public class ThreadSafeTests {
    @Test
    public void test1(){
        System.out.println("1");
        GetInformatiomThreadSafe gits = new GetInformatiomThreadSafe();
        gits.setAsThree();
    }

    @Test
    public void test2(){
        System.out.println("2");
        GetInformatiomThreadSafe gits = new GetInformatiomThreadSafe();
        gits.setAsFour();
    }


    @Test
    public void test3(){
        System.out.println("3");
        GetInformatiomThreadSafe gits = new GetInformatiomThreadSafe();
        gits.setAsFive();
    }
}
