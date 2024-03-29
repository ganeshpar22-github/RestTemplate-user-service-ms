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

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(value="/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		
		User userOne = new User(userId, "GP", "123456789");
		
		Posts posts = restTemplate.getForObject("http://localhost:8081/post/7",
				Posts.class);
		
		userOne.setPosts(posts);
		
		Notifications notifications = restTemplate.getForObject("http://localhost:8082/notification/36",
				Notifications.class);
		
		userOne.setNotifications(notifications);
		
		return userOne;
	}

}
