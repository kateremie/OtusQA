package threadsafe;

public class GetInformatiomThreadSafe {

    public void setAsFive(){
        ThreadSafe.setThreadSafeVariable(5);
        System.out.println("Method set as five: " + ThreadSafe.getThreadSafeVariable());
        ThreadSafe.setToDefault();
    }

    public void setAsThree(){
        ThreadSafe.setThreadSafeVariable(3);
        System.out.println("Method set as three: " + ThreadSafe.getThreadSafeVariable());
        ThreadSafe.setToDefault();
    }

    public void setAsFour(){
        ThreadSafe.setThreadSafeVariable(4);
        System.out.println("Method set as four: " + ThreadSafe.getThreadSafeVariable());
        ThreadSafe.setToDefault();
    }
}
