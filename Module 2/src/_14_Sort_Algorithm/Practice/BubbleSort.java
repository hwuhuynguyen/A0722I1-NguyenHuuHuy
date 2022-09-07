package _14_Sort_Algorithm.Practice;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    private static void bubbleSort(int[] arr) {
        boolean needNextPass = true;
        for (int i = 0; i < arr.length && needNextPass; i++) {
            for (int j = arr.length-1; j > i; j--) {
                needNextPass = false;
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
