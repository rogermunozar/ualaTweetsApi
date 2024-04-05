package com.twetter.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tweets.api.tweet.domain.ITweetValidator;
import com.tweets.api.tweet.domain.Tweet;
import com.tweets.api.tweet.domain.TweetValidator;
import com.tweets.api.util.Constants;

class ApiApplicationTests {

	@Autowired
    private ITweetValidator tweetValidator;

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}

	@Test
	void tweetValidatorTestOK() {
		Tweet tweet = new Tweet();		
		tweet.setUsername("abc");
		tweet.setMessage("abc 123");
		tweetValidator = new TweetValidator();	
		Assertions.assertTrue(tweetValidator.isValid(tweet));
	}

	@Test
	void tweetValidatorTestLongMessageNotOk() {
		Tweet tweet = new Tweet();		
		String message = "";		
		for(int i=0;i<(Constants.MAX_LENGTH_TWEET*2); i++){
			message+="A";
		}
		tweet.setUsername("abc");
		tweet.setMessage(message);
		tweetValidator = new TweetValidator();	
		Assertions.assertFalse(tweetValidator.isValid(tweet));
	}


}
