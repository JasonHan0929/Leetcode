public class Twitter {
    private final Map<Integer, Set<Integer>> followship = new HashMap<>();//<uid, followSet>
    private final Set<Integer[]> tweets = new TreeSet<>((x, y) -> y[2]-x[2]);//Integer[uid, tid, time]
    private int timestamp = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Integer[]{userId, tweetId, timestamp++});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(10);
        if (followship.containsKey(userId)) {
            Set<Integer> set = followship.get(userId);
            for (Integer[] triple : tweets) {
                if (result.size() >= 10)
                    return result;
                else if (set.contains(triple[0]) || userId == triple[0])
                    result.add(triple[1]);
            }
        } else {
            for (Integer[] triple : tweets) {
                if (result.size() >= 10)
                    return result;
                else if (userId == triple[0])
                    result.add(triple[1]);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followship.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followship.put(followerId, set);
        } else {
            followship.get(followerId).add(followeeId);
        }
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followship.containsKey(followerId))
            return;
        followship.get(followerId).remove(followeeId);
    }
}//not very fast

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class Twitter {
    private final Map<Integer, Set<Integer>> followship = new HashMap<>();//<uid, followSet>
    private final LinkedList<Integer[]> tweets = new LinkedList<>();//Integer[uid, tid]

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.addFirst(new Integer[]{userId, tweetId});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>(10);
        if (followship.containsKey(userId)) {
            Set<Integer> set = followship.get(userId);
            for (Integer[] triple : tweets) {
                if (result.size() >= 10)
                    return result;
                else if (set.contains(triple[0]) || userId == triple[0])
                    result.add(triple[1]);
            }
        } else {
            for (Integer[] triple : tweets) {
                if (result.size() >= 10)
                    return result;
                else if (userId == triple[0])
                    result.add(triple[1]);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followship.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followship.put(followerId, set);
        } else {
            followship.get(followerId).add(followeeId);
        }
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followship.containsKey(followerId))
            return;
        followship.get(followerId).remove(followeeId);
    }
}//still not very fast

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

/*
I use a map to track the tweets for each user. When we need to generate a news feed, I merge the news feed for all the followees and take the most recent 10. This is unlikely to perform, but the code passes the OJ. I'm sure design interviews ask for performance trade-offs and just posting this code in a design interview will not help you get an offer.

public class Twitter {
    Map<Integer, Set<Integer>> fans = new HashMap<>();
    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
    int cnt = 0;

    public void postTweet(int userId, int tweetId) {
        if (!fans.containsKey(userId)) fans.put(userId, new HashSet<>());
        fans.get(userId).add(userId);
        if (!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<>());
        tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!fans.containsKey(userId)) return new LinkedList<>();
        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        fans.get(userId).stream()
            .filter(f -> tweets.containsKey(f))
            .forEach(f -> tweets.get(f).forEach(feed::add));
        List<Integer> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().id);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!fans.containsKey(followerId)) fans.put(followerId, new HashSet<>());
        fans.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (fans.containsKey(followerId) && followeeId != followerId) fans.get(followerId).remove(followeeId);
    }

    class Tweet {
        int time;
        int id;

        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
}

Great solution. There are two possible places I think can improve the time complexity as well as space.

A. Since we will get 10 most tweets from each user. We can just save up to 10 tweets for each user. And we can use Dqueue to do that.

B. In getNewsFeed(). we can use minHeap instead so that PQueue only needs to save 10 tweets. And after each iteration if PQueue's size is bigger than 10, take the tweet with the min timestamp out of PQ.
*/

/* OO Design
public class Twitter {
    private static int timeStamp=0;
    
    // easy to find if user exist
    private Map<Integer, User> userMap;
    
    // Tweet link to next Tweet so that we can save a lot of time
    // when we execute getNewsFeed(userId)
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next=null;
        }
    }
    
    
    // OO design so User can follow, unfollow and post itself
    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;
        
        public User(int id){
            this.id=id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }
        
        public void follow(int id){
            followed.add(id);
        }
        
        public void unfollow(int id){
            followed.remove(id);
        }
        
        
        // everytime user post a new tweet, add it to the head of tweet list.
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next=tweet_head;
            tweet_head=t;
        }
    }
    
    
    

    // Initialize your data structure here. 
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    // Compose a new tweet.
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
            
    }
    

    
    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with 
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this 
    // heap before we get the 10 most recent tweet.
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId))   return res;
        
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
        for(int user: users){
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if(t!=null){
                q.add(t);
            }
        }
        int n=0;
        while(!q.isEmpty() && n<10){
          Tweet t = q.poll();
          res.add(t.id);
          n++;
          if(t.next!=null)
            q.add(t.next);
        }
        
        return res;
        
    }
    
    //follower follows a followee. If the operation is invalid, it should be a no-op.
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    //Follower unfollows a followee. If the operation is invalid, it should be a no-op.
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

*/
