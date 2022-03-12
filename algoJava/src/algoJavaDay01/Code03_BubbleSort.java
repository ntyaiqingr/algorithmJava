package algoJavaDay01;

public class Code03_BubbleSort {

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

    public static void main(String[] args) {
        int arr[] = {4,2,5,6,1,8,0};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
