public class LogSystem {
    
    List<String[]> pairs = new ArrayList<>();
    List<String> unity = new ArrayList<>(Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second"));
    int[] index = new int[]{4,7,10,13,16,19};//unity and index are used to repalce hashmap

    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        pairs.add(new String[]{timestamp, String.valueOf(id)});
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new ArrayList<>();
        int end = index[unity.indexOf(gra)];
        for (String[] pair : pairs) {
            if (pair[0].substring(0, end).compareTo(s.substring(0, end)) >= 0 
               && pair[0].substring(0, end).compareTo(e.substring(0, end)) <= 0)
                result.add(Integer.parseInt(pair[1]));
        }
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
