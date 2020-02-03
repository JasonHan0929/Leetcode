class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {// n > 0
            if (flowerbed[i] == 1)
                i++;
            else {
                if (available(flowerbed, i)) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
    
    public boolean available(int[] flowerbed, int i) {
        boolean left = i - 1 >= 0, right = i + 1 < flowerbed.length;
        if (left && right)
            return flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1;
        else if (left)
            return flowerbed[i - 1] != 1;
        else if (right)
            return flowerbed[i + 1] != 1;
        else
            return true;
    }
}

/*
//greedy?
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1)
                i++;
            else {
                if (available(flowerbed, i)) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
    
    public boolean available(int[] flowerbed, int i) {
        boolean left = i - 1 >= 0, right = i + 1 < flowerbed.length;
        if (left && right)
            return flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1;
        else if (left)
            return flowerbed[i - 1] != 1;
        else if (right)
            return flowerbed[i + 1] != 1;
        else
            return true;
    }
}
*/
/*
public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 1;
    int result = 0;
    for(int i=0; i<flowerbed.length; i++) {
        if(flowerbed[i] == 0) {
            count++;
        }else {
            result += (count-1)/2;
            count = 0;
        }
    }
    if(count != 0) result += count/2;
    return result>=n;
}
*/

