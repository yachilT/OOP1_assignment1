package Nomials;
import Scalars.*;
import Scalars.Integer;

public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(int exponent, Scalar coefficient){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public Monomial add(Monomial m){
        if(this.exponent != m.getExponent())
            return null;
        return new Monomial(this.exponent, this.coefficient.add(m.getCoefficient()));
    }
    public Monomial mul(Monomial m){
        return new Monomial(this.exponent = m.getExponent(), this.coefficient.mul(m.coefficient));
    }
    public Scalar evaluate(Scalar s){
        return this.coefficient.mult(s.power(this.exponent));
    }
    public Monomial derivative(){
        return new Monomial(this.exponent - 1,this.coefficient.mult(new Integer(exponent)));
    }
    public int sign(){
        return this.coefficient.sign();
    }
    public String toString(){
        Scalar one = new Integer(1);
        Scalar zero = new Integer(0);
        if(this.coefficient.equals(zero))
            return "0";
        else if(this.coefficient.equals(one))
            return "x^"+this.exponent;
        else
            return this.coefficient.toString() + '*' + "x^"+this.exponent;
    }
    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Scalar coefficient) {
        this.coefficient = coefficient;
    }
}
