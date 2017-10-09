class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] length = {distance(p1, p2), distance(p1, p3), distance(p1, p4), distance(p2, p3), distance(p2, p4), distance(p3, p4)};
        if (length[0] == length[1] && length[1] == length[2])
            return false;
        long max = Math.max(length[0], Math.max(length[1], length[2]));
        int count = 0;
        for (long num : length) {
            if (num == max)
                count++;
            else if (num * 2 != max)
                return false;
        }
        return count == 2;
    }
    public long distance(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}

/*
Just find the square of lenghts, and validate that

There are only two equal longest lenghts.
The non longest lengths are all equal.
public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    long[] lengths = {length(p1, p2), length(p2, p3), length(p3, p4),
            length(p4, p1), length(p1, p3),length(p2, p4)}; // all 6 sides

    long max = 0, nonMax = 0;
    for(long len : lengths) {
        max = Math.max(max, len);
    }
    int count = 0;
    for(int i = 0; i < lengths.length; i++) {
        if(lengths[i] == max) count++;
        else nonMax = lengths[i]; // non diagonal side.
    }
    if(count != 2) return false; // diagonals lenghts have to be same.

    for(long len : lengths) {
        if(len != max && len != nonMax) return false; // sides have to be same length
    }
    return true;
}
private long length(int[] p1, int[] p2) {
    return (long)Math.pow(p1[0]-p2[0],2) + (long)Math.pow(p1[1]-p2[1], 2);
}
*/
