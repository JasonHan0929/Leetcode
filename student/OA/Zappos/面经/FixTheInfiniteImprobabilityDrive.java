public class FixTheInfiniteImprobabilityDrive {
	public static String fixTheInfiniteImprobabilityDrive(String coordinates, int remove) {
		int n = coordinates.length();
		if (remove >= n) {
			return "0";
		}
		int finalLen = n - remove; 
		int[] stack = new int[n];
		int top = 0;
		for (int i = 0; i < n; i++) {
			while(top > 0 && remove > 0 && stack[top - 1] > coordinates.charAt(i)) {
				top--;
				remove--;
			}
			stack[top++] = coordinates.charAt(i);
		}
		return new String(stack, 0, n - remove);
	}
	public static void main(String[] args) {
		String coordinates = "746209249";
		int remove = 5;
		System.out.print(fixTheInfiniteImprobabilityDrive(coordinates, remove));
	}
}
