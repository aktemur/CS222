package refactoringPrimeNumberGenerator.v1;

/// This class Generates prime numbers up to a user specified
/// maximum. The algorithm used is the Sieve of Eratosthenes. 
///
/// Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
/// d. c. 194, Alexandria. The first man to calculate the
/// circumference of the Earth. Also known for working on
/// calendars with leap years and ran the library at
/// Alexandria. 
///
/// The algorithm is quite simple. Given an array of integers
/// starting at 2. Cross out all multiples of 2. Find the
/// next uncrossed integer, and cross out all of its multiples.
/// Repeat until you have passed the square root of the
/// maximum value. 
///
/// Written by Robert C. Martin on 9 Dec 1999

public class PrimeGenerator {

    private static boolean[] crossedOut;

    public static void main(String[] args) {
        for (int i : generate(400)) {
            System.out.println(i);
        }
    }

    public static int[] generate(int maxValue) {
        if (maxValue < 2) {
            // Bad input.
            return new int[0];
        } else {
            initialize(maxValue);
            sieve();
            return pickPrimes();
        }
    }

    private static void initialize(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        // get rid of known non-primes
        crossedOut[0] = crossedOut[1] = true;
    }

    private static void sieve() {
        for (int i = 2; i < Math.sqrt(crossedOut.length) + 1; i++) {
            if (!crossedOut[i]) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for (int j = 2 * i; j < crossedOut.length; j += i)
            crossedOut[j] = true;
    }

    private static int[] pickPrimes() {
        int count = countPrimes();

        int[] primes = new int[count];
        // move the primes into the result
        for (int i = 0, j = 0; i < crossedOut.length; i++) {
            if (!crossedOut[i])
                primes[j++] = i;
        }
        return primes;
    }

    private static int countPrimes() {
        int count = 0;
        for (int i = 0; i < crossedOut.length; i++) {
            if (!crossedOut[i])
                count++;
        }
        return count;
    }
}
