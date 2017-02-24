import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Twitter {
	static List<int[]> twitterList = new ArrayList<>();
	static Map<Integer,LinkedList<Integer>> followMap = new HashMap<>();
	
    /** Initialize your data structure here. */
    public Twitter() {
    	twitterList = new ArrayList<>();
    	followMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        twitterList.add(new int[]{userId,tweetId});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new ArrayList<Integer>();
    	int twitterSize = twitterList.size();
    	int count = 0;
    	for(int i=twitterSize-1;i>=0;i--){
    		int tmpUserId = twitterList.get(i)[0];
    		if(tmpUserId!=userId){
    			LinkedList<Integer> followLinkedList = followMap.get(userId);
    			if(followLinkedList==null){
    				continue;
    			}
    			if(!followLinkedList.contains(new Integer(tmpUserId))){
    				continue;
    			}
    		}
    		result.add(twitterList.get(i)[1]);
    		count++;
    		if(count==10){
    			break;
    		}
    	}
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
        	followMap.put(followerId, new LinkedList<Integer>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
        	followMap.get(followerId).remove(new Integer(followeeId));
        }
    }
    
    public static void main(String[] args) {
    	Twitter twitter = new Twitter();

    	// User 1 posts a new tweet (id = 5).
    	twitter.postTweet(1, 5);

    	// User 1's news feed should return a list with 1 tweet id -> [5].
    	twitter.getNewsFeed(1);

    	// User 1 follows user 2.
    	twitter.follow(1, 2);

    	// User 2 posts a new tweet (id = 6).
    	twitter.postTweet(2, 6);

    	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    	twitter.getNewsFeed(1);

    	// User 1 unfollows user 2.
    	twitter.unfollow(1, 2);

    	// User 1's news feed should return a list with 1 tweet id -> [5],
    	// since user 1 is no longer following user 2.
    	twitter.getNewsFeed(1);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */