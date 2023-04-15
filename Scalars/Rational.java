package Scalars;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    private int gcd(int n1, int n2) {
        int temp, GCD = 0;
        while (n2 != 0) {
            temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }


    public Scalar add(Scalar s) {
        return s.add(this);
    }

    public Scalar add(Integer i) {
        return this.add(new Rational(i.getNumber(), 1));
    }

    public Scalar add(Rational r) {
        return new Rational(this.numerator * r.denominator + r.numerator * this.denominator,
                this.denominator * r.denominator).reduce();
    }

    public Scalar mult(Scalar s) {
        return s.mult(this);
    }

    public Scalar mult(Integer s) {
        return this.mult(new Rational(s.getNumber(), 1));
    }

    public Scalar mult(Rational r) {
        return new Rational(this.numerator * r.numerator,
                this.denominator * r.denominator).reduce();
    }

    public Scalar neg() {
        return new Rational(-this.numerator, this.denominator);
    }

    public Scalar power(int exponent) {
        Scalar powered = new Rational(1, 1);
        for (int i = 0; i < exponent; i++) {
            powered = this.mult(powered);
        }
        return powered;
    }

    public int sign() {
        if (this.numerator == 0)
            return 0;
        if (this.numerator > 0 == this.denominator > 0)
            return 1;
        return -1;
    }

    public Rational reduce(){
        int n1 = this.numerator < 0 ? -this.numerator: this.numerator;
        int n2 = this.denominator < 0 ? -this.denominator: this.denominator;

        int gcd = this.gcd(n1, n2);
        return new Rational(this.numerator / gcd, this.denominator / gcd);
    }
}
