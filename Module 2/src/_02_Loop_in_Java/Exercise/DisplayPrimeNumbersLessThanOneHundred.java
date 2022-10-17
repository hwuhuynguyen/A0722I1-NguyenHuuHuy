package _02_Loop_in_Java.Exercise;

public class DisplayPrimeNumbersLessThanOneHundred {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.printf(i + " ");
            }
        }
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
