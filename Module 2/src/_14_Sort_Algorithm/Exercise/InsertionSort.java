package _14_Sort_Algorithm.Exercise;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    private static void insertionSort(int[] arr) {
        int pos, x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("After insertion sort: ");
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");    }
}
