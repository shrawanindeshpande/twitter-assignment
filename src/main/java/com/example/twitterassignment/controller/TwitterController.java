package com.example.twitterassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;
import com.example.twitterassignment.service.TwitterService;

@RestController
public class TwitterController {
    @Autowired
    private TwitterService twitterService;

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam String query) {
        try {
            return new ResponseEntity<>(twitterService.searchTweets(query), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserTweets")
    public ResponseEntity<?> getUserTweets(@RequestParam String username) {
        try {
            return new ResponseEntity<>(twitterService.getUserTweets(username), HttpStatus.OK);
        } catch (TwitterException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
