package algoJavaDay01;

public class Code02_SelectionSort {

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
       selectionSort(arr);
       printArray(arr);

    }
}
