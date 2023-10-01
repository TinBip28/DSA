package week3.fraction;


import javax.management.InvalidAttributeValueException;

public class Fraction {
    private final float numerator;
    private final float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        try {
            check(c);
        } catch (Exception e) {
            System.out.println("Invalid value");
            ;
        }
        float lcm = lcm(this.denominator, c.denominator);
        float a = lcm / this.denominator;
        float b = lcm / c.denominator;
        return normalize(new Fraction(b * this.numerator + a * c.numerator, lcm));
    }

    public Fraction minus(Fraction c) {
        try {
            check(c);
        } catch (Exception e) {
            System.out.println("Invalid value");
            ;
        }
        float lcm = lcm(this.denominator, c.denominator);
        float a = lcm / this.denominator;
        float b = lcm / c.denominator;
        return normalize(new Fraction(a * this.numerator - b * c.numerator, lcm));
    }

    public Fraction multi(Fraction c) {
        try {
            check(c);
        } catch (Exception e) {
            System.out.println("Invalid value");
        }
        return normalize(new Fraction(this.numerator * c.numerator, this.denominator * c.denominator));
    }

    public Fraction divi(Fraction c) {
        try {
            check(c);
        } catch (Exception e) {
            System.out.println("Invalid value");
        }
        return normalize(new Fraction(this.numerator * c.denominator, this.denominator * c.numerator));
    }

    public Fraction normalize(Fraction c) {
        float gcd = gcd(c.numerator, c.denominator);
        return new Fraction(c.numerator / gcd, c.denominator / gcd);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public float gcd(float a, float b) {
        float result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }

    public float lcm(float a, float b) {
        return (a / gcd(a, b)) * b;
    }

    public boolean check(Fraction c) {
        return c.denominator == 0 && this.denominator == 0;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
