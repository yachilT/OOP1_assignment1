package Scalars;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar add(Integer i);
    public Scalar add(Rational r);
    public Scalar mult(Scalar s);
    public Scalar mult(Integer s);
    public Scalar mult(Rational r);

    public Scalar neg();

    public Scalar power(int exponent);
    public int sign();
}
