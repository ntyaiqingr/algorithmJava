package algoJavaDay03;

import java.util.Arrays;

public class BSNearLeft {
    // [1,2,2,3,4,5] >=num 最左的位置

    // 在arr上找到满足>=num最左位置
    public static int nearestIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generatedRandArr(int maxLen, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxLen + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() + (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 10000;
        int maxLen = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generatedRandArr(maxLen, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            if (test(arr, value) != nearestIndex(arr, value)) {
                System.out.println(maxLen);
                System.out.println(maxValue);
                printArray(arr);
                System.out.println(value);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Pass" : "Fail");
    }
}
