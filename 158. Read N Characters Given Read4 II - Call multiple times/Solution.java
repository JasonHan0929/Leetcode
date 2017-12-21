/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    Deque<Character> cache = new LinkedList<>();
    
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean isEnd = false;
        int readBytes = 0;
        while (n > readBytes && !isEnd) {
            if (!cache.isEmpty()) {
                buf[readBytes++] = cache.poll();
                continue;
            }
            int currRead = read4(buffer);
            if (currRead < 4) isEnd = true;
            int len = Math.min(currRead, n - readBytes);
            int i = 0;
            for (i = 0; i < len; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += len;
            while (i < currRead) {
                cache.offer(buffer[i++]);
            }
        }
        return readBytes;
    }
}

/*
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }
*/
