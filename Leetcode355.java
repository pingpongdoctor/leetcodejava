public class Leetcode355 {
    private HashMap<Integer, HashSet<Integer>> follow = new HashMap<>();
    private HashMap<Integer, List<int[]>> posts = new HashMap<>();
    private int s;

    public Twitter() {
        s = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(posts.containsKey(userId)) {
            posts.get(userId).add(new int[] {tweetId, s});
        } else {
            List<int[]> postIds = new ArrayList<>();
            postIds.add(new int[] {tweetId, s});
            posts.put(userId,postIds);
        }
        s++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        List<int[]> userList = posts.getOrDefault(userId, new ArrayList<>());
        HashSet<Integer> followers = follow.getOrDefault(userId, new HashSet<>());
        List<int[]> totalPosts = new ArrayList<>();

        for(int[] userPost : userList) {
            totalPosts.add(userPost);
        }

        for(int follower : followers) {
            List<int[]> postList = posts.getOrDefault(follower, new ArrayList<>());
            for(int[] post : postList) {
                totalPosts.add(post);
            }
        }

        Collections.sort(totalPosts, (a,b) -> Integer.compare(b[1],a[1]));
        int size = Math.min(totalPosts.size(), 10);

        for (int i = 0 ; i < size; i++) {
            result.add(totalPosts.get(i)[0]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)) {
            follow.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            follow.put(followerId,followees);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
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