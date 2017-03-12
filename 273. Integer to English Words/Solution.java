public class Solution {
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return assist(num);
    }
    public String assist(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 20)
            result.append(belowTwenty[num]);
        else if (num < 100)
            result.append(belowHundred[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            result.append(belowTwenty[num / 100]).append(" Hundred ").append(assist(num % 100));
        else if (num < 1000000)
            result.append(assist(num / 1000)).append(" Thousand ").append(assist(num % 1000));
        else if (num < 1000000000)
            result.append(assist(num / 1000000)).append(" Million ").append(assist(num % 1000000));
        else
            result.append(assist(num / 1000000000)).append(" Billion ").append(assist(num % 1000000000));
        return result.toString().trim();
    }
}
