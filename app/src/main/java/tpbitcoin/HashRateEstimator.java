package tpbitcoin;

import org.bitcoinj.core.Sha256Hash;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HashRateEstimator {
    private final int duration; //duration of each experience, in milliseconds
    private final int numberOfTries; // number of experience

    /** Create a new object for estimating the number of SHA256 hashs the host can perform per second
    ** @param duration: (milli-seconds) duration of each experiment
     * @param numberOfTries : number of experiments to run
     */
    public HashRateEstimator(int duration, int numberOfTries) {
        this.duration = duration;
        this.numberOfTries = numberOfTries;
    }

    /**
     * @return : return the hashrate (hash/second)
     */
    public double estimate(){
        Random rand = new Random();
        byte[] bytes = new byte[256];
        rand.nextBytes(bytes);

        MessageDigest md = Sha256Hash.newDigest();

        double moyenne = 0.0;
    //    long startTime = System.currentTimeMillis();
     //   int nbHash = 0;

        for(int i = 0; i < this.numberOfTries; i++) {
            long time = System.currentTimeMillis() + this.duration;
                    int count = 0;
            while(System.currentTimeMillis() < time){
                count++;
            }
            moyenne += count;
        }
           /* if(System.currentTimeMillis() > startTime + this.duration) continue;
            bytes = md.digest(bytes);
            nbHash++;
            }*/

        return moyenne/this.duration;
    }

}
