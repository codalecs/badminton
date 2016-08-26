package rs.code9.badminton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entity class representing a user.
 *
 * @author d.gajic
 */
@Entity
@Table(name = "account")
public class User extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7904460940872624174L;

	/**
	 * E-mail address of the user.
	 */
	@NotNull
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is not of proper format")
	private String email;

	/**
	 * First name of the user.
	 */
	@Size(min = 3, max = 10, message = "Firstname length is out of bounds")
	private String firstName;

	/**
	 * Last name of the user.
	 */
	@Size(min = 3, max = 20, message = "Lastname length is out of bounds")
	private String lastName;
	
	@NotNull
	@Size(min = 5, max = 10, message = "Password must be between 5 and 10 characters long")
	private String password;
	
	private byte[] picture;

	/**
	 * @return email
	 */
	@Column(name = "email", nullable = false, length = 100, unique = true)
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return firstName
	 */
	@Column(name = "first_name", length = 20)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName
	 */
	@Column(name = "last_name", length = 20)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return user's picture.
	 */
	@Lob
	@Column(name = "image_data")
	public byte[] getPicture() {
		return picture;
	}
	
	/**
	 * @param picture user's picture.
	 */
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	@Column(name = "password", length = 10)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
