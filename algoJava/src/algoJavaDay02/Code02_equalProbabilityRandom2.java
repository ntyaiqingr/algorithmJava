package algoJavaDay02;

public class Code02_equalProbabilityRandom2 {

    // 你知道f1会按照固定概率返回0，1但是你不知道具体f1的内容
    public static int f1() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回0和1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while(ans == f1());
        // ans = 0(do) ans = 1(while)
        // ans = 1(do) ans = 0(while)
        return ans;
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int[] counts = new int[2];
        for (int i = 0; i < testTimes; i++) {
            int num = f2();
            counts[num] ++;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i + ", this number shows " + counts[i] + " times");
        }
    }
}
