class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int n = secret.length();
        for (int i = 0; i < n; i++)
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        int bull = 0, cow = 0;
        for (int i = 0; i < n; i++) {
            char temp = guess.charAt(i);
            if (temp == secret.charAt(i)) {
                bull++;
                cow--;
            }
            if (map.getOrDefault(temp, 0) > 0) {
                map.put(temp, map.get(temp) - 1);
                cow++;
            }
        }
        return String.format("%dA%dB", bull, cow);
    }
}
/*
The idea is to iterate over the numbers in secret and in guess and count all bulls right away. For cows maintain an array that stores count of the number appearances in secret and in guess. Increment cows when either number from secret was already seen in guest or vice versa.

public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
A slightly more concise version:

public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
}
*/
