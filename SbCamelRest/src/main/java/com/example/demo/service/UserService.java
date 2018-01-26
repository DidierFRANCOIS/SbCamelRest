package com.example.demo.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	// use a tree map so they become sorted
	private final Map<String, User> users = new TreeMap<String, User>();
	Comment comment = null;

	public UserService() {

		User user01 = new User(1, "user 01");
		// construction des commentaires. 
		comment = new Comment (1, "commentaires 01 user 01 "); 
		user01.addComment(1, comment);
		comment = new Comment (2, "commentaires 03 user 01 "); 
		user01.addComment(2 , comment);
		comment = new Comment (3, "commentaires 03 user 01 "); 
		user01.addComment(3, comment);
		users.put("1", user01);

		users.put("2", new User(2, "user 02"));
		users.put("3", new User(2, "user 03"));



	}

	public String getUser() {
		System.out.println(" get user ");
		return " retour TODO " ; 
		// return "<customer>" + users.get(id).getName() + "</customer>";
	}
	
	
	/**
	 * Gets a user by the given id
	 *
	 * @param id  the id of the user
	 * @return the user, or <tt>null</tt> if no user exists
	 */
	public String getUser(String id , int test) {
		System.out.println(" get user " + id + " Test " + test );
		return "<customer>" + users.get(id).getName() + "</customer>";
	}

	/**
	 * List all users
	 *
	 * @return the list of all users
	 */
	public Collection<User> listUsers() {
		return users.values();
	}

	/**
	 * Updates or creates the given user
	 *
	 * @param user the user
	 */
	public void updateUser(User user) {
		users.put("" + user.getId(), user);
	}
}