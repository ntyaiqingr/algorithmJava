package algoJavaDay02;

public class Code03_Comp {

    public static void selectionSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void bubbleSort(int arr[]) {
        if(arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }

    //返回一个数组arr arr长度[0, maxLen-1], arr中每个值[0, maxValue-1]
    public static int[] lenRandValueRand(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandValueRand(maxLen, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            bubbleSort(arr2);
            if (!isSorted(arr1)) {
                System.out.println("False");
            }
        }
    }
}
