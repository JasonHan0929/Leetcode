class Solution {
    public String complexNumberMultiply(String a, String b) {
        ComplexNumber complexA = new ComplexNumber(a);
        ComplexNumber complexB = new ComplexNumber(b);
        complexA.mutiplex(complexB);
        return complexA.toString();
    }
}

class ComplexNumber {
    private int real;
    private int imaginary;

    ComplexNumber(String input) {
        String[] parts = input.split("\\+"); // 可以用正则"\\+|i"
        if (parts.length > 0) {
            this.real = Integer.parseInt(parts[0]);
        }
        if (parts.length > 1) {
            this.imaginary = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
        }
    }

    public void mutiplex(ComplexNumber other) {
        int newReal = real * other.real - imaginary * other.imaginary;
        int newImaginary = real * other.imaginary + imaginary * other.real;
        real = newReal;
        imaginary = newImaginary;
    }
    
    public String toString() {
        return String.format("%d+%di", real, imaginary);
    }
}
