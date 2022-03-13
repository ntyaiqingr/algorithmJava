package algoJavaDay03;

import java.util.Arrays;

public class Code01_BSExist {

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L =0;
        int R = arr.length - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else  {
                R = mid - 1;
            }
        }
        return false;
    }

    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxLen, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxLen + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int maxValue = 100;
        int maxLen = 10;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxLen, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random())  - (int) (maxValue * Math.random());
            if (exist(arr, value) != test(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Pass" : "Fail");
    }
}
