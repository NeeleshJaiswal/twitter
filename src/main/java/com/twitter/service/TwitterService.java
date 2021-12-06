package com.twitter.service;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterService {

    List<Status> fetchTweets(String tweetKeyword) throws TwitterException;

}
