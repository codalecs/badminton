/**
 * 
 */
package rs.code9.badminton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.User;
import rs.code9.badminton.repository.UserRepository;
import rs.code9.badminton.service.UserService;

/**
 * @author d.gajic
 *
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see rs.code9.badminton.service.UserService#get(java.lang.Long)
	 */
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see rs.code9.badminton.service.UserService#create(rs.code9.badminton.model.User)
	 */
	@Transactional(readOnly = false)
	public User create(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see rs.code9.badminton.service.UserService#findAll()
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
