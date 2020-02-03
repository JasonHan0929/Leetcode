public class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 1)
            return s;
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(s.length(), new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare (Map.Entry<Character, Integer> A, Map.Entry<Character, Integer> B) {
                return B.getValue() - A.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            heap.add(entry);
        StringBuilder result = new StringBuilder();//注意不要用+链接字符串，效率低
        while(heap.size() > 0) {
            Map.Entry<Character, Integer> tempo = heap.poll();
            for(int i = tempo.getValue(); i > 0; i--)
                result.append(tempo.getKey());
        }
        return result.toString();
    }
}//HeapSort方式略繁琐
/*class EntryComparator implements Comparator<Map.Entry<Character, Integer>> {
    @Override
    public int compare (Map.Entry<Character, Integer> A, Map.Entry<Character, Integer> B) {
        return B.getValue() - A.getValue();
    }
}*/

public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char chr;
        for (int i = 0; i < s.length(); i++) {
            chr = s.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> count = new ArrayList<>(map.entrySet());
        count.sort(new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> oA, Map.Entry<Character, Integer> oB) {
                return oB.getValue().compareTo(oA.getValue());
            }
        });
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : count) {//注意要给出entry的类型参数
            for (int i = entry.getValue(); i > 0; i--)
                result.append(entry.getKey());
        }
        return result.toString();
    }//用自带的sort更简洁
}
       
