/*
 * Copyright Levi9 Global Sourcing, 2012
 */
package rs.code9.badminton.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import rs.code9.badminton.model.User;
import rs.code9.badminton.service.UserService;

/**
 * User RESTful controller.
 * 
 * @author Nikola
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * List all users.
	 * 
	 * @return MaV with the list of all users.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listAll() {
		return new ModelAndView("users-list", "users", userService.findAll());
	}
	
	/**
	 * Show a user with given ID.
	 * 
	 * @param id user's ID.
	 * @return MaV with the user, user may be <code>null</code>.
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView showUser(@PathVariable("id") long id) {
		return new ModelAndView("user-show", "user", userService.get(id));
	}
	
	/**
	 * Display empty form for new user.
	 * 
	 * @return MaV for edit form with an empty User.
	 */
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView showNewForm() {
		return new ModelAndView("user-edit", "user", new User()).addObject("newUser", true);
	}
	
	/**
	 * Accept form submit for a new user.
	 * 
	 * @param user user from the form.
	 * @return MaV to redirect to user display.
	 */
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ModelAndView newUser(
			@ModelAttribute("user") @Valid User user,
			BindingResult result,
			@RequestParam("user.picture") MultipartFile picture) {
		if (result.hasErrors()) {
			return new ModelAndView("user-edit", "user", user).addObject("newUser", true);
		}
		if (!picture.isEmpty()) {
			try {
				user.setPicture(picture.getBytes());
			} catch (IOException e) {
				result.rejectValue("user.picture", "", "I/O Exception handling uploaded picture.");
				return new ModelAndView("user-edit", "user", user).addObject("newUser", true);
			}
		}
		User newUser = userService.create(user);
		return new ModelAndView("redirect:/users/" + newUser.getId());
	}
	
	private static final String IMG_TYPE = "image/jpg";
	
	@RequestMapping(value = "{id}/picture", method = RequestMethod.GET)
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
