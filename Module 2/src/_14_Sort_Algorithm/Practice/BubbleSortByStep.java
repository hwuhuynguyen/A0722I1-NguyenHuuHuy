package _14_Sort_Algorithm.Practice;

public class BubbleSortByStep {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    static int[] test = {3,4,5,2,1};

    private static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }

            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }

            System.out.print("List after the  " + k + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        bubbleSortByStep(test);
        for (int i = 0; i < test.length; i++)
            System.out.print(test[i] + " ");
    }
}
