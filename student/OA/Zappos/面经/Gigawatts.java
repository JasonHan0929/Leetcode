import java.util.*;

public class Gigawatts {
	public static boolean gigawatts(int[] batteryOne, int[] batteryTwo, int gigawattTarget) {
		HashSet<Integer> hashset = new HashSet<>();
		for (int num : batteryOne) {
			hashset.add(num);
		}
		for (int num : batteryTwo) {
			if (hashset.contains(gigawattTarget - num)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] batteryOne = new int[]{6,3,1,9,5,4,0,1,-29,12,45,2,6};
		int[] batteryTwo = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
		int gigawattTarget = -19;
		System.out.print(gigawatts(batteryOne, batteryTwo, gigawattTarget));
	}
}
