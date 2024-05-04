package com.example.twitterassignment.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@Service
public class TwitterService {
    private final String apiKey = "0nwRt6RotYduQoCabvY0HaNV1";
    private final String apiSecretKey = "3zlElYySGw8uWoDSiAW0av5sRiDGGsaB38j6O2oZZKV0GCY95Z";
    private final String accessToken = "1720465368508956672-09xBWgBg85Ydp21Nx59LZZzytE8Och";
    private final String accessTokenSecret = "3qAS68EDfVsjXm93r4fJtiOlAjMksuqCgbZcEbGTKFuEq";

    public Twitter getTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
    //for fetching tweets we need to get subscription od twitter developer
    //In basic version we cannot use all the functionality
    public ResponseEntity<List<Status>> searchTweets(String query) throws TwitterException {
        Twitter twitter = getTwitterInstance();
        return twitter.search().tweets(query);
    }
    public List<Status> getUserTweets(String username) throws TwitterException {
        Twitter twitter = getTwitterInstance();
        return twitter.timelines().getUserTimeline(username);
    }

}
