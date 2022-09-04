package _10_DSA_List.Exercise.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedList<Integer> ll = new LinkedList<>(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addLast(20);
        ll.add(4, 8);

//        ll.remove(2);
//        System.out.println(ll.contains(13));
//        System.out.println(ll.remove(0));
//        System.out.println(ll.indexOf(12));

        System.out.print(ll.get(0) + " ");      //13
        System.out.print(ll.get(1) + " ");      //12
        System.out.print(ll.get(2) + " ");      //11
        System.out.print(ll.get(3) + " ");      //10
        System.out.println(ll.get(4));          // 8
        System.out.println(ll.getFirst());      //13
        System.out.println(ll.getLast());       //20
        System.out.println(ll.size());          // 6
        System.out.println(ll.indexOf(8));      // 4

        ll.add(6, 9);
        System.out.println(ll.indexOf(9));      // 6
        System.out.println(ll.getLast());       // 9

        ll.clear();
    }
}
