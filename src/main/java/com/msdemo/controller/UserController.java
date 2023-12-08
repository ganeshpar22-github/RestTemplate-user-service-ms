package com.msdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.msdemo.model.Notifications;
import com.msdemo.model.Posts;
import com.msdemo.model.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static final String USER_SERVICE = "user-service";
	
	
	@GetMapping(value="/{userId}")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "userServiceFallBack" )
	public User getUser(@PathVariable("userId") String userId) {
		
		User userOne = new User(userId, "GP", "123456789");
		
		Posts posts = restTemplate.getForObject("http://post-service/post/1",
				Posts.class);
		
		userOne.setPosts(posts);
		
		Notifications notifications = restTemplate.getForObject(
				"http://notification-service/notification/1",
				Notifications.class);
		
		userOne.setNotifications(notifications);
		
		return userOne;
	}
	
	//if post or notification service failed then this response will be returned
	
	public User userServiceFallBack(Exception exception) {
		return new User("1", "Yash Parmar", "62669590987");
	}

}
