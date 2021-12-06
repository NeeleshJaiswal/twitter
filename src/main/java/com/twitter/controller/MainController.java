package com.twitter.controller;

import com.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class MainController {


    @Autowired
    TwitterService twitterService;

    @GetMapping("/tweets/{tweetKeyword}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity fetchTweets(@PathVariable String tweetKeyword) throws TwitterException {
        List<Status> statusList = twitterService.fetchTweets(tweetKeyword);
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }
}
