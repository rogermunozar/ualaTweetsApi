package com.tweets.api.user.infrastructure;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweets.api.follow.application.FollowShow;
import com.tweets.api.follow.domain.Follow;
import com.tweets.api.follow.domain.IFollowService;
import com.tweets.api.timeline.application.TimelineShow;
import com.tweets.api.timeline.domain.ITimelineService;
import com.tweets.api.timeline.domain.ITweetService;
import com.tweets.api.timeline.domain.Timeline;
import com.tweets.api.tweet.application.TweetShow;
import com.tweets.api.tweet.domain.Tweet;
import com.tweets.api.user.application.UserCreate;
import com.tweets.api.user.domain.IUserService;
import com.tweets.api.user.domain.User;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private IUserService userService;
    @Autowired
    private ITimelineService tlService;
    @Autowired
    private IFollowService followService;
    @Autowired
    private ITweetService tweetService;


    @Operation(summary = "Show all users", description="Each user have a key field called username, first name and last name")
    @GetMapping()
    //    
    public List<User> getUsers() {
        return userService.getAllUsers();                
    }
    
    
    @Operation(summary = "Add a new user", description = "The field username is the user key")
    @PostMapping
    //
    public ResponseEntity<?>  add(@RequestBody UserCreate userCreate) {
        String response = userService.addUser(userCreate.toDomain());
        if(response.equals("201")){
            return new ResponseEntity<String>("201", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("400", HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Get an user by username")
    @GetMapping("/{username}")
    //
    public ResponseEntity<?> getUser(@PathVariable String username) {      

        User user = userService.getUser(username);
        if(user==null){
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        
    }


    @Operation(summary = "Get tweets of an user by username")
    @GetMapping("/{username}/tweets")
    //
    public ResponseEntity<?> getTweet(@PathVariable String username) {              
        List<Tweet> tweetList = tweetService.getTweets(username);        
        if(tweetList==null){
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        }
        //
        List<TweetShow> tweetShowedList = new ArrayList<>();
        tweetList.forEach(tweet->tweetShowedList.add(new TweetShow(tweet)));
        return new ResponseEntity<List<TweetShow>>(tweetShowedList , HttpStatus.OK);        
    }


    @Operation(summary = "Get timeline of an user by username", description = "It is sort by sent date")
    @GetMapping("/{username}/timeline")
    //
    public ResponseEntity<?> getTimeline(@PathVariable String username) {      
        List<Timeline> timelines = tlService.getTimeline(username);
        if(timelines==null){
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        }
        //
        List<TimelineShow> timelineShow = new ArrayList<>();
        timelines.forEach( element -> timelineShow.add( new TimelineShow(element)));
        return new ResponseEntity<List<TimelineShow>>(timelineShow, HttpStatus.OK);
    }    


    @Operation(summary = "Get follows of an user by username")
    @GetMapping("/{username}/follows")
    //
    public ResponseEntity<?> getFollow(@PathVariable String username) {
        List<Follow> followList = followService.getFollows(username);
        if(followList==null){
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        }
        //
        List<FollowShow> followShowList = new ArrayList<>();
        followList.forEach(follow->followShowList.add(new FollowShow(follow)));
        return new ResponseEntity<List<FollowShow>>(followShowList , HttpStatus.OK);
    }

}   
