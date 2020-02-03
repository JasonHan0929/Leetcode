public class SumOfAllSubarray {
	public static int solution(int[] nums) {
		int result = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			result += nums[i] * (i + 1) * (n - i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[]{1,2,3};
		System.out.println(solution(input));
	}
}