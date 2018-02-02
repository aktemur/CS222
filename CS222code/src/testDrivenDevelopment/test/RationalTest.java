import org.junit.Test;
import testDrivenDevelopment.rational.Rational;

import static org.junit.Assert.*;

public class RationalTest {
    @Test
    public void testZeroArgumentConstructor() {
        Rational r = new Rational();
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testOneArgumentConstructor() {
        Rational r = new Rational(99);
        assertEquals(99, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testTwoArgumentConstructor1() {
        Rational r = new Rational(7, 5);
        assertEquals(7, r.getNumerator());
        assertEquals(5, r.getDenominator());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTwoArgumentConstructor2() {
        // Put here the piece of code that is supposed to
        // throw the exception
        new Rational(7, 0);
    }

    @Test
    public void testNormalization1() {
        Rational r = new Rational(15, 20);
        assertEquals(3, r.getNumerator());
        assertEquals(4, r.getDenominator());
    }

    @Test
    public void testNormalization2() {
        Rational r = new Rational(20, 15);
        assertEquals(4, r.getNumerator());
        assertEquals(3, r.getDenominator());
    }

    @Test
    public void testNormalization3() {
        Rational r = new Rational(20, 20);
        assertEquals(1, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testNormalization4() {
        Rational r = new Rational(30, 15);
        assertEquals(2, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testNormalization5() {
        Rational r = new Rational(13, 17);
        assertEquals(13, r.getNumerator());
        assertEquals(17, r.getDenominator());
    }

    @Test
    public void testNormalization6() {
        Rational r = new Rational(-10, 20);
        assertEquals(1, r.getNumerator());
        assertEquals(-2, r.getDenominator());
    }

    @Test
    public void testNormalization7() {
        Rational r = new Rational(10, -20);
        assertEquals(1, r.getNumerator());
        assertEquals(-2, r.getDenominator());
    }

    @Test
    public void testNormalization8() {
        Rational r = new Rational(-10, -20);
        assertEquals(1, r.getNumerator());
        assertEquals(2, r.getDenominator());
    }

    @Test
    public void testNormalization9() {
        Rational r = new Rational(0, -10);
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testNormalization10() {
        Rational r = new Rational(0, 20);
        assertEquals(0, r.getNumerator());
        assertEquals(1, r.getDenominator());
    }

    @Test
    public void testAddition() {
        Rational number1 = new Rational(5, 3);
        Rational number2 = new Rational(7, 4);
        Rational sum = number1.add(number2);

        assertEquals(5, number1.getNumerator());
        assertEquals(3, number1.getDenominator());
        assertEquals(7, number2.getNumerator());
        assertEquals(4, number2.getDenominator());
        assertEquals(41, sum.getNumerator());
        assertEquals(12, sum.getDenominator());
    }
}
