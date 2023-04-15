package Scalars;

public class Integer implements Scalar {
    private int number;
    public Integer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    public Scalar add(Integer i) {
        return new Integer(this.number + i.number);
    }

    public Scalar add(Rational r) {
        return null;
    }

    public Scalar mult(Scalar s) {
       return s.mult(this);
    }

    public Scalar mult(Integer s) {
        return new Integer(this.number + s.number);
    }

    public Scalar mult(Rational r) {
        return null;
    }

    public Scalar neg() {
        return new Integer(-this.number);
    }

    public Scalar power(int exponent) {
        Scalar powered = new Integer(1);
        for (int i = 0; i < exponent; i++) {
            powered = this.mult(powered);
        }
        return powered;
    }

    public int sign() {
        if (this.number > 0)
            return 1;
        if (this.number < 0)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return this.number + "";
    }
}
