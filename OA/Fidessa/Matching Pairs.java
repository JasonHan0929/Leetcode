/*
 * Complete the function below.
 */

    static int findMatchingPair(String input) {
        Deque<Character> stack = new LinkedList<>();
        int index = -1;
        if (Character.isLowerCase(input.charAt(0))) {
            return index;
        }
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if(!stack.isEmpty() && stack.peek() != temp - 32 && Character.isLowerCase(temp)) {
                break;
            }
            if (!stack.isEmpty() && stack.peek() == temp - 32) {
                stack.pop();
                index = i;
            }
            else {
                stack.push(temp);
            }
        }
        return index;
    }

