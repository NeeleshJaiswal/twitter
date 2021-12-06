package com.twitter.service;

import com.twitter.configuration.TwitterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;

import java.util.List;

@Service
public class TwitterServiceIMPL implements TwitterService {

    final TwitterConfiguration twitterConfiguration;

    @Autowired
    public TwitterServiceIMPL(TwitterConfiguration twitterConfiguration) {
        this.twitterConfiguration = twitterConfiguration;
    }

    @Override
    public List<Status> fetchTweets(String tweetKeyword) throws TwitterException {
        TwitterFactory tf = twitterConfiguration.getConfiguredTwitterFactory();
        Twitter twitter = tf.getInstance();
        Query query = new Query("#"+tweetKeyword);
        query.setLang("en");

        QueryResult result = twitter.search(query);

        return result.getTweets();
    }
}
