/*
 * Copyright Levi9 Global Sourcing, 2012-2016
 */
package rs.code9.badminton.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.code9.badminton.exceptions.ServiceFailureException;
import rs.code9.badminton.model.User;
import rs.code9.badminton.service.UserService;

/**
 * User RESTful controller.
 * 
 * @author Nikola
 * @author Alecs
 */
@RestController
@RequestMapping("api/v1/")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * List all users.
	 * 
	 * @return MaV with the list of all users.
	 */
	@RequestMapping(value = "users/", method = RequestMethod.GET)
	public List<User> listAll() {
		return userService.findAll();
	}

	/**
	 * Show a user with given ID.
	 * 
	 * @param id user's ID.
	 * @return MaV with the user, user may be <code>null</code>.
	 */
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") long id) {
		return userService.get(id);
	}

	/**
	 * Accept form submit for a new user.
	 * 
	 * @param user
	 *            user from the form.
	 * @return MaV to redirect to user display.
	 */
	@RequestMapping(value = "users/create", method = RequestMethod.POST)
	public User createUser(@ModelAttribute("user") @Valid User user, @RequestParam("user.picture") MultipartFile picture) throws ServiceFailureException {
		if (!picture.isEmpty()) {
			try {
				user.setPicture(picture.getBytes());
			} catch (IOException e) {
				throw new ServiceFailureException( "I/O Exception handling uploaded picture.");
			}
		}
		return userService.create(user);
	}

	private static final String IMG_TYPE = "image/jpg";

	@RequestMapping(value = "users/{id}/picture", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(@PathVariable("id") long id) {
		User user = userService.get(id);
		if (user == null || user.getPicture() == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", IMG_TYPE);
		return new ResponseEntity<byte[]>(user.getPicture(), headers, HttpStatus.OK);
	}
}
