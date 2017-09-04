class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0)
            return result;
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
            result.get(i).add(1);
        }
        if (numRows >= 2)
            result.get(1).add(1);
        int len = 3;
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < len - 1; j++)
                result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i-1).get(j));
            result.get(i).add(1);
            len++;
        }
        return result;
    }
}

/*
public class Solution {
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	
	}
}
*/
