import java.util.*;

public class MaxValidTime {
    public static void maxValidTime(int A, int B, int C, int D) {
        List<Integer> time = new ArrayList<>(4);
        time.add(A);
        time.add(B);
        time.add(C);
        time.add(D);
        Integer hourHigh = -1;
        for (int i = 0; i < time.size(); i++) {
            if (time.get(i) <= 2)
                hourHigh = Math.max(hourHigh, time.get(i));
        }
        if (hourHigh == -1) {
            printResult(new int[0]);
            return;
        }
        else
            time.remove(hourHigh);
        Integer hourLow = -1;
        for (int i = 0; i < time.size(); i++) {
            if (hourHigh == 2 && time.get(i) <= 3)
                hourLow = Math.max(hourLow, time.get(i));
            else if (hourHigh < 2)
                hourLow = Math.max(hourLow, time.get(i));
        }
        if (hourLow == -1) {
            printResult(new int[0]);
            return;
        }
        else
            time.remove(hourLow);
        Integer minHigh = -1;
        for (int i = 0; i < time.size(); i++) {
            if (time.get(i) <= 5)
                minHigh = Math.max(minHigh, time.get(i));
        }
        if (minHigh == -1) {
            printResult(new int[0]);
            return;
        }
        else
            time.remove(minHigh);
        int minLow = time.get(0);
        printResult(new int[]{hourHigh, hourLow, minHigh, minLow});
    }
    public static void printResult(int[] time) {
        if (time.length == 0)
            System.out.print("NOT POSSIBLE");
        else
            System.out.print(time[0] + "" + time[1] + ":" + time[2] + "" + time[3]);
    }
	public static void main(String[] args) {
		maxValidTime(1,8,3,2);
	}
}