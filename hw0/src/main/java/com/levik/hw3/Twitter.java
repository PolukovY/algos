package com.levik.hw3;

import java.util.*;

public class Twitter {
    private final Map<Integer, Set<Integer>> followers;
    private final List<Node> tweets;
    private int timestamp;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new ArrayList<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Node node = new Node(userId, tweetId, ++timestamp);
        tweets.add(node);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> items = new LinkedList<>();
        Set<Integer> set = followers.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        int i = tweets.size() - 1;
        while (items.size()< 10 && i >= 0) {
            Node node = tweets.get(i);
            if(set.contains(node.userId)){
                items.add(node.tweetId);
            }
            i--;
        }

        return items;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followers.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }

    static class Node {
        private final int userId;
        private final int tweetId;
        private final int timestamp;

        Node(int userId, int tweetId, int timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }

        public int getUserId() {
            return userId;
        }

        public int getTweetId() {
            return tweetId;
        }

        public int getTimestamp() {
            return timestamp;
        }
    }
}
