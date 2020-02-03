public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num > 8)
            return result;
        //num = Math.min(8, num);
        //while (num >= 0) {
            for (int i = 0; i <= Math.min(3, num) && num - i >= 0; i++) {
                getTime(i, num - i, result);
            }
            //num--;
        //}
        return result;
    }//no need to produce the result from num - 1, num -2....
    public void getTime(int numHour, int numMin, List<String> result) {
        List<String> hourResult = new ArrayList<>();
        List<String> minResult = new ArrayList<>();
        getHour(numHour, new int[]{8, 4, 2, 1}, hourResult, 0, 0);
        getMin(numMin, new int[]{32, 16, 8, 4, 2, 1}, minResult, 0, 0);
        for (String hour : hourResult) {
            for (String min : minResult)
                result.add(hour + ":" + min);
        }
    }
    public void getHour(int num, int[] unity, List<String> result, int sum, int start) {
        if (num == 0)
            result.add(Integer.toString(sum));
        else {
            for (int i = start; i < unity.length; i++) {//use start otherwise will produce duplicates
                if (unity[i] == 0 || sum + unity[i] >= 12)
                    continue;
                else {
                    int temp = unity[i];
                    unity[i] = 0;
                    getHour(num - 1, unity, result, sum + temp, i + 1);
                    unity[i] = temp;
                }
            }
        }
    }
    public void getMin(int num, int[]unity, List<String> result, int sum, int start) {
        if (num == 0) {
            result.add(sum < 10 ? "0" + sum : Integer.toString(sum));
        } else {
            for (int i = start; i < unity.length; i++) {
                if (unity[i] == 0 || sum + unity[i] >= 60)
                    continue;
                else {
                    int temp = unity[i];
                    unity[i] = 0;
                    getMin(num - 1, unity, result, sum + temp, i + 1);
                    unity[i] = temp;
                }
            }
        }
    }
}
