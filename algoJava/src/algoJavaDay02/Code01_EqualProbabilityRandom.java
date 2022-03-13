package algoJavaDay02;

public class Code01_EqualProbabilityRandom {

    // 1-5 random to 1-7 random
    //originalRand => get 1-5
    public static int originalRand() {
        return (int) (Math.random() * 5) + 1;
    }

    // equal probability of 0 and 1 by using originalRand
    public static int equalZeroAndOne() {
        int ans = 0;
        do {
            ans = originalRand();
        } while ( ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 二进制 000~111 等概率 0~7 等概率返回
    public static int equalZeroToSeven() {
        //return (equalZeroAndOne() << 2) + (equalZeroAndOne() << 1) + equalZeroAndOne();
        return (equalZeroAndOne() << 2) + (equalZeroAndOne() << 1) + (equalZeroAndOne() << 0);
    }

    // 等概率0~7 => 0~6
    public static int equalZeroToSix() {
        int ans = 0;
        do {
            ans = equalZeroToSeven();
        } while (ans == 7);
        return ans;
    }

    public static int oneToSeven() {
        return equalZeroToSix() + 1;
    }

    public static void main(String[] args) {
        int testingTimes = 10000000;
        int[] counts = new int[8];
        for (int i = 0; i < testingTimes; i++) {
            int num = oneToSeven();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + ", this number shows " + counts[i] + " times");
        }
    }
}
