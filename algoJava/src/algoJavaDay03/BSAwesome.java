package algoJavaDay03;

public class BSAwesome {

    // arr 整体无序
    // arr 相邻的数不相等
    // 寻找一个值 比他左边以及右边的都小
    public static  int oneMinIndex(int arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N== 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N-1] < arr[N-2]) {
            return N-1;
        }
        int L = 0;
        int R = N-1;
        int ans = -1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                ans = mid;
                break;
            } else if (arr[mid - 1] < arr[mid]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int[] generatedRandArr(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 0; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean checkResult(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] < arr[minIndex] : true;
        return  rightBigger && leftBigger;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int maxLen = 5;
        int maxValue = 20;
        int testTimes = 100000;
        System.out.println("Start");
        for (int i = 0; i < testTimes; i++) {
            int [] arr = generatedRandArr(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!checkResult(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("End");
    }
}
