class Solution {
    public String nextClosestTime(String input) {
        if (input == null || input.length() != 5) {
            return "";
        }
        int[] time = new int[4];
        TreeSet<Integer> tree = new TreeSet<>();
        int min = 10;
        for (int i = 0; i < input.length(); i++) {
            if (i < 2) {
                time[i] = input.charAt(i) - '0';
                tree.add(time[i]);
                min = Math.min(min, time[i]);
            } else if (i > 2) {
                time[i - 1] = input.charAt(i) - '0';
                tree.add(time[i - 1]);
                min = Math.min(min, time[i - 1]);
            }
        }
        for (int i = 3; i >= 0; i--) {
            if (getNext(time, tree, i)) {
                for (int j = 3; j > i; j--) {
                    time[j] = min;
                }
                return String.format("%d%d:%d%d", time[0], time[1], time[2], time[3]);
            }
        }
        return String.format("%d%d:%d%d", min, min, min, min);
    }
    public boolean getNext(int[] time, TreeSet<Integer> tree, int i) {
        Integer temp = tree.higher(time[i]);
        if (temp == null) {
            return false;
        }
        if (i == 3) {
            time[i] = temp;
            return true;
        } else if (i == 2) {
            if (temp > 5) {
                return false;
            }
            time[i] = temp;
            return true;
        } else if (i == 1) {
            if (time[0] == 2 && temp > 3) {
                return false;
            }
            time[i] = temp;
            return true;
        } else {
            if (time[2] > 3 && temp > 1) {
                return false;
            }
            time[0] = temp;
            return true;
        }
    }
}

/*
Solution 1:
we can try to increase the minute and the hour one by one. If all these four digits of the next time is in hashset, we find it and output! because these four digits are all reused.

    public String nextClosestTime(String time) {
        String[] val = time.split(":");
        Set<Integer> set = new HashSet<>();
        int hour = add(set, val[0]);
        int minu = add(set, val[1]);

        int[] times = new int[] {hour, minu};
        nxt(times);

        while (!contains(times[0], times[1], set)) {
            nxt(times);
        }
        return valid(times[0]) + ":" + valid(times[1]);
    }

    public void nxt(int[] time) {
        int hour = time[0];
        int minu = time[1];
        minu ++;
        if (minu == 60) {
            hour ++;
            minu = 0;
            if (hour == 24) hour = 0;
        }
        time[0] = hour;
        time[1] = minu;
    }

    public int add(Set<Integer> set, String timeStr) {
        int time = Integer.parseInt(timeStr);
        set.add(time / 10);
        set.add(time % 10);
        return time;
    }

    public String valid(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }

    public boolean contains(int hour, int minu, Set<Integer> set) {
        return set.contains(hour / 10) && set.contains(hour % 10) && set.contains(minu / 10) && set.contains(minu % 10);
    }
but in this way, the cost will be 24* 60 = 1440.

Solution 2:
Because these four digits can be reused,so the next time can be constructed by these digits, so we try to use dfs to search all the next time.

it will search 4 * 4 * 4 * 4 = 256 times.

    int diff = 0x3f3f3f3f;
    String result = "";
    int h;
    int m;
    public String nextClosestTime(String time) {
        int[] digit = new int[4];
        int tot = 0;
        String[] val = time.split(":");
        int hour = Integer.parseInt(val[0]);
        int minu = Integer.parseInt(val[1]);
        digit[tot++] = hour / 10;
        digit[tot++] = hour % 10;
        digit[tot++] = minu / 10;
        digit[tot++] = minu % 10;

        h = hour;
        m = minu;

        dfs(digit, 0, new int[4]);

        return result;
    }

    void dfs(int[] digit, int i, int[] ans) {
        if (i == 4) {
            int hour = 10 * ans[0] + ans[1];
            int minu = 10 * ans[2] + ans[3];
            if (hour >= 0 && hour <= 23 && minu >= 0 && minu <= 59) {
                int df = diff(hour, minu);
                if (df < diff) {
                    diff = df;
                    result = valid(hour) + ":" + valid(minu);
                }
            }
        }
        else {
            for (int j = 0; j < 4; ++j) {
                ans[i] = digit[j];
                dfs(digit, i + 1, ans);
            }
        }
    }

    int diff(int hour, int minu) {
        int c2o = 60 * 60 - h * 60 - m;
        int n2o = 60 * 60 - hour * 60 - minu;
        return n2o < c2o ? c2o - n2o : c2o - n2o + 3600;
    }

    public String valid(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }
Solution 3:
Of course, we can try to prune, if hour and minute is not valid, just stop search.

for the test case "23:59", it will search 24 times, but solution 2 searches 256 times.

    int diff = 0x3f3f3f3f;
    String result = "";
    int h;
    int m;
    public String nextClosestTime(String time) {
        int[] digit = new int[4];
        int tot = 0;
        String[] val = time.split(":");
        int hour = Integer.parseInt(val[0]);
        int minu = Integer.parseInt(val[1]);
        digit[tot++] = hour / 10;
        digit[tot++] = hour % 10;
        digit[tot++] = minu / 10;
        digit[tot++] = minu % 10;

        h = hour;
        m = minu;

        dfs(digit, 0, new int[4]);

        return result;
    }

    void dfs(int[] digit, int i, int[] ans) {
        if (i == 4) {
            int hour = 10 * ans[0] + ans[1];
            int minu = 10 * ans[2] + ans[3];
            int df = diff(hour, minu);
            if (df < diff) {
                diff = df;
                result = valid(hour) + ":" + valid(minu);
            }
        }
        else {
            for (int j = 0; j < 4; ++j) {
                ans[i] = digit[j];
                if (i == 1) {
                    int hour = 10 * ans[0] + ans[1];
                    if (hour >= 0 && hour <= 23) dfs(digit, i + 1, ans);
                }
                else if (i == 3) {
                    int minu = 10 * ans[2] + ans[3];
                    if (minu >= 0 && minu <= 59) dfs(digit, i + 1, ans);
                }
                else {
                    dfs(digit, i + 1, ans);
                }
            }
        }
    }

    int diff(int hour, int minu) {
        int c2o = 60 * 60 - h * 60 - m;
        int n2o = 60 * 60 - hour * 60 - minu;
        return n2o < c2o ? c2o - n2o : c2o - n2o + 3600;
    }

    public String valid(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }
*/
