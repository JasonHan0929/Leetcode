/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int readBytes = 0;
        char[] buffer = new char[4];
        boolean isEnd = false;
        while (readBytes < n && !isEnd) {
            int currRead = read4(buffer);
            if (currRead < 4) isEnd = true;
            int len = Math.min(currRead, n - readBytes);
            for (int i = 0; i < len ; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += len;
        }
        return readBytes;
    }
}
