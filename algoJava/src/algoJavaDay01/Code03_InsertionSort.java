package algoJavaDay01;

public class Code03_InsertionSort {

    public static void insertionSort1(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int curIndex = i;
            while (curIndex -1 >= 0 && arr[curIndex - 1] > arr[curIndex]) {
                swap(arr, curIndex - 1, curIndex);
                curIndex--;
            }
        }
    }

    public static void insertionSort2(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr, j, j + 1);
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

    public static void main(String[] args) {
        int arr[] = {4,2,5,6,1,8,0};
        printArray(arr);
        insertionSort1(arr);
        printArray(arr);
    }
}
