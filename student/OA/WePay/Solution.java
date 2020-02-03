public class Solution{

    /** build a data structure for power number */
    static class PowerNumber implements Comparable<PowerNumber> {
        private long value;// value = base ^ power
        private final long base;
        private long power;
        
        PowerNumber(long base, long power) {
            value = (long)Math.pow(base, power);
            this.base = base;
            this.power = power;
        }

        void addPower() {
            power += 1;
            value *= base; 
        }

        long getValue() {
            return value;
        }

        @Override
        public int compareTo(PowerNumber other) {
            return Long.compare(value, other.value);
        }
    }

    /*
     * Complete the function below.
     */
    static long getPowerNumber(long index) {
        index++;// make n starts from 1 so that code could be more readable
        long upperBound = (long)Math.pow(index + 1, 2);// the powernumber[index] must less than or equal to
        //(n + 1) ^ 2 because there are at least Nth number from 2 ^ 2 to (n + 1) ^ 2
        PriorityQueue<PowerNumber> pq = new PriorityQueue<>();//use pq to maintain candidates of next power number
        for (int i = 2; i <= index + 1; i++) {
            pq.offer(new PowerNumber(i, 2));
        }
        long nextValue = pq.peek().getValue();
        while (index > 1) {
            while (pq.peek().getValue() == nextValue) {
                PowerNumber curr = pq.poll();
                curr.addPower();
                if (curr.getValue() < upperBound) {
                    pq.offer(curr);
                }
            }
            index--;
            nextValue = pq.peek().getValue();
        }
        return nextValue;
    }
}

