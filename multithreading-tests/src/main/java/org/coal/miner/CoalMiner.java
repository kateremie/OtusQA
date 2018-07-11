package org.coal.miner;

import org.coal.CoalMine;

import static java.lang.Thread.sleep;

public class CoalMiner implements Runnable {

    static boolean shouldTheJobBeFinished = false;
    int workerId;

    public CoalMiner(int workerId){
        this.workerId = workerId;

    }

    public void atWork(){
        int leftCapacity = CoalMine.getCapacityAndDecreaseByTen();
        try {
            sleep(10);
        }
       catch (InterruptedException e) {
            Thread.interrupted();
        }

        if(leftCapacity==0){
            shouldTheJobBeFinished = true;
            return;}
        System.out.println("How much coal left = " + leftCapacity + " miner's id" + workerId);
    }

    public void run() {
        long starTimer = System.currentTimeMillis();
        try {
            sleep(100);
        }
        catch (InterruptedException e) {
            Thread.interrupted();
        }
        while (!shouldTheJobBeFinished){
            atWork();
        }

        long endTimer = System.currentTimeMillis();
        long finishedTime = endTimer - starTimer;
        System.out.println("The miner" + workerId+ "Finish the job by time: " + finishedTime);
    }
}
