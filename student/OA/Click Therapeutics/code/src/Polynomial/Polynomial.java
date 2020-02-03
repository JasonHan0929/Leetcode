package Polynomial;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial implements Iterable<Integer> {

    // use final field and keep the stability when used by multithread
    private final TreeMap<Integer, Double> coefMap = new TreeMap<>((x, y) -> (Integer.compare(y, x)));

    // polynomial = 0
    public Polynomial() {
        coefMap.put(0, 0.0);
    }

    // degreeArray=[2,1,0], coefArray=[1,2,-3] => x^2 + 2x - 3
    public Polynomial(double[] coefArray, int[] degreeArray) {
        if (coefArray.length != degreeArray.length) {
            throw new RuntimeException("Coefficient array does't not have the same length as degree array!");
        }
        for (int i = 0; i < coefArray.length; i++) {
            if (coefArray[i] != 0) {
                coefMap.put(degreeArray[i], coefArray[i]);
            }
        }
    }

    // copy from other polynomial
    public Polynomial(Polynomial other) {
        coefMap.putAll(other.getCoefMap());
    }

    // private, only be used within class as an assistant method
    private TreeMap<Integer, Double> getCoefMap() {
        return coefMap;
    }

    // round the coefficient to only to #num decimals because double will loss accuracy
    public Polynomial roundDecimalw(int num) {
        double mask = Math.pow(10, num);
        for (int degree: this) {
            double newCoef = Math.round(coefMap.get(degree) * mask) / mask;
            coefMap.put(degree, newCoef);
        }
        return this;
    }

    public Double getCoefficent(int degree) {
        return coefMap.get(degree);
    }

    public boolean containsDegree(int degree) {
        return coefMap.containsKey(degree);
    }

    public void putTerm(double coef, int degree) {
        coefMap.put(degree, coef);
    }

    public void deleteTerm(int degree) {
        coefMap.remove(degree);
    }

    // whether this polynomail only has a constant number
    public boolean isConstant() {
        if (coefMap.containsKey(0) && coefMap.size() == 1) return true;
        return false;
    }

    // get the biggest degree(the key of coefMap)
    public int getDegree() {
        return coefMap.firstKey();
    }

    // give a value of x and calculate the sum of this polynomial
    public double inputX(double x) {
        double result = 0;
        for (int degree : this) {
            result += coefMap.get(degree) * Math.pow(x, degree);
        }
        return result;
    }

    public Polynomial plus(Polynomial other) {
        for (Map.Entry<Integer, Double> entry : other.getCoefMap().entrySet()) {
            if (coefMap.containsKey(entry.getKey())) {
                double newCoef= entry.getValue() + coefMap.get(entry.getKey());
                if (newCoef == 0) coefMap.remove(entry.getKey()); // throw zero terms
                else coefMap.put(entry.getKey(), newCoef);
            } else {
                coefMap.put(entry.getKey(), entry.getValue());
            }
        }
        // corner case: result polynomial is 0
        if (coefMap.size() == 0) {
            coefMap.put(0, 0.0);
        }
        return this;
    }

    public Polynomial minus(Polynomial other) {
        for (Map.Entry<Integer, Double> entry : other.getCoefMap().entrySet()) {
            if (coefMap.containsKey(entry.getKey())) {
                double newCoef= coefMap.get(entry.getKey()) - entry.getValue();
                if (newCoef == 0) coefMap.remove(entry.getKey()); // throw zero terms
                else coefMap.put(entry.getKey(), newCoef);
            } else {
                coefMap.put(entry.getKey(), -entry.getValue());
            }
        }
        // corner case: result polynomial is 0
        if (coefMap.size() == 0) {
            coefMap.put(0, 0.0);
        }
        return this;
    }

    public Polynomial multiply(Polynomial other) {
        TreeMap<Integer, Double> result = new TreeMap<>();
        for (Map.Entry<Integer,Double> entry1 : coefMap.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : other.getCoefMap().entrySet()) {
                int degree = entry1.getKey() + entry2.getKey();
                double coef = entry1.getValue() * entry2.getValue();
                if (result.containsKey(degree)) {
                    double newCoef = coef + result.get(degree);
                    if (newCoef == 0) result.remove(degree); // throw zero terms
                    else result.put(degree, newCoef);
                } else {
                    result.put(degree, coef);
                }
            }
        }
        // corner case: result polynomial is 0
        if (result.size() == 0) {
            result.put(0, 0.0);
        }
        //copy result to this polynomial
        coefMap.clear();
        coefMap.putAll(result);
        return this;
    }

    // this = d * other + r, return an array like [d, r]
    public Polynomial[] divide(Polynomial other) {
        if (other.isConstant() && other.getCoefficent(0) == 0) {
            throw new RuntimeException("You could not divide a polynomial by zero!");
        }
        // Corner Case: other polynomial has a bigger degree
        if (other.getDegree() > getDegree()) {
            Polynomial remains = new Polynomial(this);
            coefMap.clear();
            coefMap.put(0, 0.0);
            return new Polynomial[]{new Polynomial(), remains};
        }
        // Corner Case: other is a constant polynomial
        if (other.isConstant()) {
            double constant = other.getCoefficent(0);
            for(Map.Entry<Integer, Double> entry : coefMap.entrySet()) {
                coefMap.put(entry.getKey(), entry.getValue() / constant);
            }
            return new Polynomial[]{this, new Polynomial()};
        }
        // use polynomial algorithm from Wikipedia
        TreeMap<Integer, Double> d = new TreeMap<>();
        int otherDegree = other.getDegree();
        double otherFirstCoef = other.getCoefficent(otherDegree);
        while (getDegree() >= other.getDegree()) {
            double coef = coefMap.get(coefMap.firstKey()) / otherFirstCoef;
            int degree = getDegree() - otherDegree;
            d.put(degree, coef);
            Polynomial temp = new Polynomial(new double[]{coef}, new int[]{degree});
            temp.multiply(other);
            this.minus(temp);
        }
        // remains
        Polynomial r = new Polynomial(this);
        //copy result to this polynomial
        coefMap.clear();
        coefMap.putAll(d);
        return new Polynomial[]{this, r};
    }

    public Polynomial dirivative() {
        TreeMap<Integer, Double> result = new TreeMap<>();
        for (int degree : this) {
            if (degree != 0) {
                result.put(degree - 1, degree * coefMap.get(degree));
            }
        }
        // corner case: result polynomial is 0
        if (result.size() == 0) {
            result.put(0, 0.0);
        }
        //copy result to this polynomial
        coefMap.clear();
        coefMap.putAll(result);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Double constant = null;
        for (Map.Entry<Integer, Double> entry : coefMap.entrySet()) {
            if (entry.getKey() == 0) {
                constant = entry.getValue();
            } else {
                if (entry.getKey() > 0) {
                    result.append(entry.getValue() + "x^" + entry.getKey() + "+");
                } else {
                    result.append(entry.getValue() + "x^(" + entry.getKey() + ")+");
                }
            }
        }
        if (constant == null) {
            result.deleteCharAt(result.length() - 1);
        } else if (constant.intValue() == constant) {
            // Corner Case: toString((double)0) = "-0.0"
            result.append(constant.intValue());
        } else {
            result.append(constant);
        }
        String resultString = result.toString();
        // severak modification of result string to make it easier to see
        resultString = resultString.replaceAll("\\+-", "-");
        resultString = resultString.replace("^1", "");
        resultString = resultString.replaceAll("\\.0+x", "x");
        resultString = resultString.replaceAll("1x", "x");
        return resultString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null || other.getClass() != getClass()) return false;
        Polynomial otherPoly = (Polynomial)other;
        return coefMap.equals(otherPoly.getCoefMap());
    }

    @Override
    public int hashCode() {
        return coefMap.hashCode();
    }

    @Override
    public Iterator<Integer> iterator() {
        return coefMap.keySet().iterator();
    }
}


/*
My Though about the design process:
  1. Data Structure:
      1) Do not use array-like data structure because you have to save every degree of x even its coefficient is zero. For example, to represent x^100, you have to use an array whose length is 101. This is not efficient in space.
      2) Do not use linked list because it's hard to keep degrees in order by linked list. Because you need to get the biggest degree of a polynomial to implement division and to output it into a elegent way.
      3) Based the above point, you need a map-like data structure and it could also keep a particular sequence of degree. So I choose tree map in java.
  2. Implement Operation:
      1) At first I tried to find some efficient algorithm to speed up the calculation about polynomial but it seems to be too complicated to implement and for different operation it needs different data structure to save a polynomial. So I give up, just implement the naive algorithm to do plus, minus, multiply, divide and get derivative.
      2) To implement division, I use remains to deal with the case when one polynomial is indivisible by the other.
  3. The cons and pros:
      1) I try my best to implement more funtionality in this class. So this class support negative degree polynomial like x^(-1).
      It also support decimal coefficient like 1.5x, but because I use double type to represent the coefficient, it might loss accuracy. Using BigDecimal will improve this point but I think it's not efficient in terms of running time. Also the class has nice toString() method which convert the polynomial to string in a 'convenient' pattern for human to read. For example, 3.0x^-2 + -1.0x will be convert to -x + 3x^(-2). I also override the equals method and hashcode method so that you could figure out if two polynomial are equivalent.
      2) This class do not support decimal degree like x(^0.5). This will make the class to complex to implement so I give up. And this class only support polynomial in the pattern of
      b + a1x + a2x^2 + a3x^3.... So if you have a polynomial like 1/(x + 1), this class could not work. I see the definition of polynomial in Wikipedia does not including 1/(x + 1).
  4. Test
      I do unit test in PolynomialTest.java which you could find in ../test/. This test using junit4 so you should enclose the jar files when your run it.
*/