package _13_Search_Algorithm.Practice;

public class BinarySearch_Recursion {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearch(int[] arr, int low, int high, int number) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (number < arr[mid]) {
                return binarySearch(arr, low, mid-1, number);
            } else if (number > arr[mid]) {
                return binarySearch(arr, mid+1, high, number);
            } else
                return mid;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 0, list.length - 1, 2));
        System.out.println(binarySearch(list, 0, list.length - 1, 11));
        System.out.println(binarySearch(list, 0, list.length - 1, 79));
        System.out.println(binarySearch(list, 0, list.length - 1, 1));
        System.out.println(binarySearch(list, 0, list.length - 1, 5));
        System.out.println(binarySearch(list, 0, list.length - 1, 80));
    }
}
