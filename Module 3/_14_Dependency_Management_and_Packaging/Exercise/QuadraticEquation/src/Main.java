
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a,b,c;
        System.out.println("Enter a,b,c: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        if (equation.getDiscriminant()<0)
            System.out.println("The equation has no roots");
        else if (equation.getDiscriminant()==0)
            System.out.println("The equation has one root: " + equation.getRoot1());
        else {
            System.out.println("The equation has two roots: ");
            System.out.println("Delta is: " + equation.getDiscriminant());
            System.out.println("Root1 is: " + equation.getRoot1());
            System.out.println("Root2 is: " + equation.getRoot2());
        }
    }
}
