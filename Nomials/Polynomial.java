package Nomials;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Monomial>  monomials;
    public Polynomial(){};
    public Polynomial(List<Monomial> monomialList){
        monomials = new TreeMap<>();
        for(Monomial m: monomialList){
            if(monomials.containsKey(m.getExponent()))
                monomials.put(monomials.get(m.getExponent()).add(m));
        }
    }
    public static Polynomial build(String input){

    }
}