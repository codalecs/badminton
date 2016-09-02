/**
 * 
 */
package rs.code9.badminton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.badminton.model.User;

/**
 * @author d.gajic
 *
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
}
