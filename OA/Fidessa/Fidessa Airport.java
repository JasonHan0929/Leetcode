    public static int airport(int[] arrivals, int[]departures, int flights) {
        Arrays.sort(arrivals);
        Arrays.sort(depatures);
        int gates = 0;
        int endsItr = 0;
        for(int i = 0; i < starts.length; i++) {
            if(arrivals[i] <= departures[endsItr])
                gates++;
            else
                endsItr++;
        }
        return gates;
    }

//http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
