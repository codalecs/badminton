package rs.code9.badminton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class representing a court.
 *
 * @author d.gajic
 */
@Entity
@Table(name = "court")
public class Court extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8171921033716510631L;

	/**
	 * Court name
	 */
	private String name;

	/**
	 * @return name
	 */
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
