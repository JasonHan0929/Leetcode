import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static class Item implements Comparable<Item>{
        String date;
        String engagement;
        int times;
        
        private Item(String date, String engagement, String times) {
            this.date = date;
            this.engagement = engagement;
            this.times = Integer.parseInt(times);
        }
        
        @Override
        public int compareTo(Item o) {
            if (date.equals(o.date)) {
                return engagement.compareTo(o.engagement);
            }
            else {
                return o.date.compareTo(date);
            }
        }
        
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(date);
            builder.append(", ");
            builder.append(engagement);
            builder.append(", ");
            builder.append(times);
            return builder.toString();
        }
        
        public boolean same(Item o) {
            return date.equals(o.date) && engagement.equals(o.engagement);
        }

        public boolean add(Item o) {
            if (o == null || !date.equals(o.date))
                return false;
            else {
                if (engagement.equals(o.engagement)) {
                    times += o.times;
                }
                else {
                    engagement += ", " + times + ", " + o.engagement;
                    times = o.times;
                }
                return true;
            }
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String start = "";
        String end = "";
        List<Item> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (temp.isEmpty()) {
                continue;
            }
            String[] array = temp.split(",");
            if (++count == 1) {
                start = array[0].trim();
                end = array[1].trim();
            }
            else {
                String date = array[0].substring(0, 7).trim();
                if (isSelected(date, start, end)) {
                    String engagement = array[1].trim();
                    String times = array[2].trim();
                    list.add(new Item(date, engagement, times));
                }
            }
        }
        output(list, start, end); 
    }
    
    public static boolean isSelected(String date, String start, String end) {
        return date.compareTo(start) >= 0 && date.compareTo(end) < 0;
    }
    
    public static void output(List<Item> input, String start, String end) {
        Collections.sort(input);
        int index = 0;
        while (index < input.size() - 1) {
            if(input.get(index).same(input.get(index + 1))) {
                input.get(index).add(input.get(index + 1));
                    input.remove(index + 1);
            }
            else {
                index++;
            }
        }
        index = 0;
        while (index < input.size() - 1) {
            if (input.get(index).add(input.get(index + 1))) {
                input.remove(index + 1);
            }
            else {
                index++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.size(); i++) {
            result.append(input.get(i).toString());
            result.append("\n");
        }
        System.out.print(result.toString());
    }
}
