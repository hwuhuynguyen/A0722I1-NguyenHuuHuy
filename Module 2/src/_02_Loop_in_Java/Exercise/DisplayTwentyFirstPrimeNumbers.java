package _02_Loop_in_Java.Exercise;

public class DisplayTwentyFirstPrimeNumbers {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        while (count < 20) {
            if (isPrime(number)) {
                System.out.printf(number + " ");
                count++;
            }
            number++;
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

