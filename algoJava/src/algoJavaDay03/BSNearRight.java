package algoJavaDay03;

import java.util.Arrays;

public class BSNearRight {
    // [1,2,2,3,4,5] <= num 最右的位置

    // 在arr上找到满足<= num 最右的位置

    public static int nearestIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L =0;
        int R = arr.length - 1;
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        System.out.println("My answer: " + ans);
        return ans;
    }

    public static int test(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            System.out.println("No value");
            return -1;
        }
        for (int i = arr.length - 1; i >=0; i--) {
            if (arr[i] == num) {
                System.out.println("Testing:" + i);
                return i;
            }
        }
        System.out.println("No value");
        return -1;
    }

    public static int[] generatedRandArr(int maxLen, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxValue + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int maxLen = 10;
        int maxValue = 100;
        boolean succeed = true;
        int value = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
        int[] arr = generatedRandArr(maxLen, maxValue);
        Arrays.sort(arr);
        for (int i = 0; i < testTimes; i++) {
            if (test(arr, value) != nearestIndex(arr, value)) {
                printArray(arr);
                System.out.println("value: " + value);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed? "Pass" : "Fail");
    }
}
