class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {  
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) { // j = i could not work because the length of the words will not be same
                if (j >= words.size()) return false;
                String otherWord = words.get(j);
                if (otherWord.length() <= i || word.charAt(j) != otherWord.charAt(i)) return false;
            }
        }  
        return true;
    }
}
