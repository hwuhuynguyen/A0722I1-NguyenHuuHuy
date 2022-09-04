package _10_DSA_List.Exercise.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);

        System.out.println("element 4: " + arrayList.get(4));
        System.out.println("element 1: " + arrayList.get(1));
        System.out.println("element 2: " + arrayList.get(2));

        arrayList.clear();
    }
}
