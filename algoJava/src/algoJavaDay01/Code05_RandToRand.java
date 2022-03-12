package algoJavaDay01;

import javax.imageio.ImageTranscoder;
import java.rmi.MarshalException;

public class Code05_RandToRand {

    // return [0, 1)
    // random x is in the range of  [0, 1). Change the frequency from original to [0, x^2)
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static void main(String[] args) {
        System.out.println("Testing begin!");

        int testingTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testingTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double)count / (double)testingTimes);
        count = 0;
        System.out.println("=======================");
        // [0, 1) -> [0, 8)

        for (int i = 0; i < testingTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testingTimes);
        System.out.println((double) 5 / (double) 8);

        System.out.println("======================");
        int K = 9;
        // [0, K) => [0, 8]

        int[] counts = new int[9];
        for (int i = 0; i < testingTimes; i++) {
            int ans = (int) (Math.random() * K); //[0, K-1]
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + ", this number shows " + counts[i] + " times");
        }

        System.out.println("======================");
        count = 0;
        double x = 0.7;
        for (int i = 0; i < testingTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testingTimes);
        System.out.println(Math.pow(x, 2));
    }
}
