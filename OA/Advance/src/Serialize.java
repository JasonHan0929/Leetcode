import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.security.InvalidParameterException;

/**
 * Constrains:
 *  1. only '\n' could be used to generate a new line, not something like '\r\n'.
 *  2. When loading from string, a key must be followed by a value, so no unpaired key or value.
 *  3. When loading from string, no unnecessary whitespace like "kay = value".
 *  4. When loading from string, no duplicate key
 *  4. THe text for a key or a value should not be too long so that the replaceAll method are efficient.
 *
 * Problems:
 *  Actually I think     a[0]["k1"] = "v1"
 *                       a[0]["k2"] = "v2"
 *                       a[1]["A"] = "XXX"
 *   shouble be saved as "k1=v1;k2=v2\nA=XXX/n".
 *
 *   Because once we have a[0] = {}
 *   we should save it as "/n" rather than "".
 *   Empty string should be used to represent an empty array,
 *   instead of an array with one empty map.
 *
 *   So my program has a problem here, when you do save(load("\n\n")),
 *   the result is "\n".
 *   Because save method always disgardd the last "\n".
 *
 */
public class Serialize {
    public static void main( String[] args ) {
        String text = "\n\n";
        Serialize test = new Serialize();
        System.out.println(test.load(text));
        System.out.println(test.save(test.load(text)).length());
    }

    private boolean checkListInput(List<Map<String, String>> input) {
        if (input == null) {
            return false;
        }
        for (Map<String, String> map : input) {
            if (map == null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkStringInput(String input) {
        if (input == null) {
            return false;
        }
        return true;
    }

    private String escapeInputText(String text) {
        text = text.replaceAll("\n", Matcher.quoteReplacement("\\n"));
        text = text.replaceAll(";", Matcher.quoteReplacement("\\;"));
        return text;
    }

    private String restoreInputText(String text) {
        text = text.replaceAll(Matcher.quoteReplacement("\\n"), "\n");
        text = text.replaceAll(Matcher.quoteReplacement("\\;"), ";");
        return text;
    }

    public String save(List<Map<String, String>> input) {
        if (!checkListInput(input)) {
            throw new InvalidParameterException("Invalid Input!");
        }
        StringBuilder buffer = new StringBuilder();
        for (Map<String, String> map : input) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = escapeInputText(entry.getKey());
                String value = escapeInputText(entry.getValue());
                buffer.append(String.format("%s=%s;", key, value));
            }
            if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == ';') {
                buffer.deleteCharAt(buffer.length() - 1);
            }
            buffer.append("\n");
        }
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }

    public List<Map<String, String>> load (String input) {
        if (!checkStringInput(input)) {
            throw new InvalidParameterException("Invalid Input!");
        }
        if (input.equals("")) {
            return new ArrayList<>(); // corner case, "".split("\\n").length == 1 ?!
        }
        if (input.endsWith("\n")) {
            input += "#EOF"; // To deal with "...\n\n\n", but not a very smart approach
        }
        String[] mapStringArray = input.split("\\n");
        List<Map<String, String>> list = new ArrayList<>(mapStringArray.length);
        for (String mapString : mapStringArray) {
            if (mapString.equals("")) {
                list.add(new HashMap<>());
                continue;
            } else if (mapString.equals("#EOF")) {
                break;
            }
            Map<String, String> map = new HashMap<>();
            String[] keyValueArray = mapString.split(";");
            for (String keyValue : keyValueArray) {
                String[] pair = keyValue.split("=");
                String key = restoreInputText(pair[0]);
                String value = restoreInputText(pair[1]);
                map.put(key, value);
            }
            list.add(map);
        }
        return list;
    }
}



