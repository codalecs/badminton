/**
 * 
 */
package rs.code9.badminton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.User;
import rs.code9.badminton.repository.UserJpaRepository;
import rs.code9.badminton.service.UserService;

/**
 * @author d.gajic
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService {
	
	@Autowired
	private UserJpaRepository userRepository;

	/**
	 * Get user with the given ID.
	 * 
	 * @param id user ID.
	 * @return User with given ID or <code>null</code>.
	 */
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	/**
	 * Create given user in the repository.
	 * 
	 * @param user user to create
	 * @return user with assigned ID
	 */
	@Transactional(readOnly = false)
	public User create(User user) {
		return userRepository.save(user);
	}

	/**
	 * Get all users registered.
	 * 
	 * @return list of all users on the system.
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
