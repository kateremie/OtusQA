package org.coal.tests;

import org.coal.miner.CoalMiner;

public class CoalMinersTest {

    public static void main(String[] args){
        new Thread(new CoalMiner(1)).start();
        new Thread(new CoalMiner(2)).start();
    }
}
