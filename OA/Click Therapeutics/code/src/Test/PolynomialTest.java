import static  org.junit.Assert.*;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import Polynomial.Polynomial;

public class PolynomialTest {

    @Test
    public void testOperations() {
        Polynomial a = new Polynomial(new double[]{1,2,3.3}, new int[]{0,1,2});
        Polynomial b = new Polynomial(new double[]{4,-5}, new int[]{-1,2});
        Polynomial result = new Polynomial(new double[]{4,1,2,-1.7}, new int[]{-1,0,1,2});
        testPlus(a, b, result);

        a = new Polynomial(new double[]{1,2,3.3}, new int[]{0,1,2});
        b = new Polynomial(new double[]{4,-5}, new int[]{-1,2});
        result = new Polynomial(new double[]{-4,1,2,8.3}, new int[]{-1,0,1,2});
        testMinus(a, b, result);

        a = new Polynomial(new double[]{1,2,3.3}, new int[]{0,1,2});
        b = new Polynomial(new double[]{4,-5}, new int[]{-1,2});
        result = new Polynomial(new double[]{4,8,13.2,-5,-10,-16.5}, new int[]{-1,0,1,2,3,4});
        testMultiply(a, b, result);

        a = new Polynomial(new double[]{2,1}, new int[]{2,0});
        b = new Polynomial(new double[]{1}, new int[]{1});
        result = new Polynomial(new double[]{2}, new int[]{1});
        Polynomial remains = new Polynomial(new double[]{1}, new int[]{0});
        testDivide(a, b, new Polynomial[]{result, remains});

        a = new Polynomial(new double[]{5,-3.2,6}, new int[]{5,-2,0});
        result = new Polynomial(new double[]{25,6.4}, new int[]{4,-3});
    }

    @Test
    public void testOtherfunction() {
        Polynomial test = new Polynomial(new double[]{5,3,0.7,0.6}, new int[]{4,0,-1,-2});

        testGetCoefficientMethod(test, 0.7, -1);

        testConatinsDegreeMethod(test, 4);

        testPutTermandDeleteTermMethods(test);

        testInputX(test, 1, 9.3);
    }

    private void testInputX(Polynomial test, double x, double expected) {
        String message = String.format("f(x) = %s, when x = %s, f(x) = %s", test, x, expected);
        BigDecimal real = new BigDecimal(test.inputX(x), new MathContext(4,RoundingMode.HALF_UP));
        assertTrue(message, real.doubleValue() == expected);
    }

    private void testPutTermandDeleteTermMethods(Polynomial test) {
        String message = String.format("f(x) = %s, delete first term", test);
        int degree = test.getDegree();
        double coef = test.getCoefficent(degree);
        test.deleteTerm(degree);
        assertFalse(message, test.containsDegree(degree));
        message = String.format("f(x) = %s, add new term %sx^%s", test, degree, coef);
        test.putTerm(coef, degree);
        assertTrue(message, test.getCoefficent(degree) == coef);
    }

    private void testGetCoefficientMethod(Polynomial test, double coef, int degree) {
        String message = String.format("f(x) = %s, degree(%s) = %s", test, degree, coef);
        assertTrue(message, coef == test.getCoefficent(degree));
    }

    private void testConatinsDegreeMethod(Polynomial test, int degree) {
        String message = String.format("f(x) = %s contains degree(%s)", test, degree);
        assertTrue(message, test.containsDegree(degree));
    }

    private void testDirivative(Polynomial a, Polynomial result) {
        String message = String.format("f'(%s) = %s", a, result);
        assertEquals(message, result, a.dirivative());
    }

    private void testPlus(Polynomial a, Polynomial b, Polynomial result) {
        String message = String.format("%s + %s = %s", a, b, result);
        assertEquals(message, result, a.plus(b).roundDecimalw(5));
    }

    private void testMinus(Polynomial a, Polynomial b, Polynomial result) {
        String message = String.format("%s - %s = %s", a, b, result);
        assertEquals(message, result, a.minus(b).roundDecimalw(5));
    }

    private void testMultiply(Polynomial a, Polynomial b, Polynomial result) {
        String message = String.format("%s * %s = %s", a, b, result);
        assertEquals(message, result, a.multiply(b).roundDecimalw(5));
    }

    private void testDivide(Polynomial a, Polynomial b, Polynomial[] result) {
        String message = String.format("%s / %s = %s", a, b, result);
        Polynomial[] real = a.divide(b);
        assertEquals(message, result, real);
    }
}
