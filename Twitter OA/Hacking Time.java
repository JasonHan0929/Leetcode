/*
 * Complete the function below.
 */

    static String decrypt(String encrypted_message) {
        String key = "8251220";
        StringBuilder result = new StringBuilder();
        int lenS = encrypted_message.length();
        int lenK = key.length();
        int k = 0;
        for (int i = 0;  i < lenS; i++) {
            char temp = encrypted_message.charAt(i);
            if (Character.isLetter(temp)) {
                k = k % lenK;
                char digit = key.charAt(k);
                if (Character.isLowerCase(temp)) {
                    temp = (char)(temp - key.charAt(k) + '0');
                    if (temp < 'a')
                        temp += 26;
                }
                else if (Character.isUpperCase(temp)) {
                    temp = (char)(temp - key.charAt(k) + '0');
                    if (temp < 'A')
                        temp += 26;
                }
                k++;
            }
            result.append(temp);
        }
        return result.toString();
    }



