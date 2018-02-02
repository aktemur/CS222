package testDrivenDevelopment.rational;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this(0);
    }

    public Rational(int value) {
        this(value, 1);
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    private void normalize() {
        if (numerator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private static int gcd(int x, int y) {
        int rem = x % y;
        while (rem != 0) {
            x = y;
            y = rem;
            rem = x % y;
        }
        return y;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational add(Rational that) {
        int num = this.numerator * that.denominator + this.denominator * that.numerator;
        int denom = this.denominator * that.denominator;
        return new Rational(num, denom);
    }
}
