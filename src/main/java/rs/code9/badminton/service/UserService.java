package rs.code9.badminton.service;

import java.util.List;

import rs.code9.badminton.model.User;

/**
 * User service, giving basic CRUD access to {@link User} repository.
 * 
 * @author Nikola Milutinovic
 */
public interface UserService {
	/**
	 * Get user with the given ID.
	 * 
	 * @param id user ID.
	 * @return User with given ID or <code>null</code>.
	 */
	public User get(Long id);
	
	/**
	 * Get all users registered.
	 * 
	 * @return list of all users on the system.
	 */
	public List<User> findAll();
	
	/**
	 * Create given user in the repository.
	 * 
	 * @param user user to create
	 * @return user with assigned ID
	 */
	public User create(User user);
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	
}
