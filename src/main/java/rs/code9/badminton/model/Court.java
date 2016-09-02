package rs.code9.badminton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	 * Surface type
	 */
	private SurfaceType surfaceType;

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
	
	/**
	 * @return
	 */
	@Enumerated(EnumType.STRING)
	public SurfaceType getSurfaceType() {
		return surfaceType;
	}

	/**
	 * @param surfaceType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "surface_type", nullable = false )
	public void setSurfaceType(SurfaceType surfaceType) {
		this.surfaceType = surfaceType;
	}

	public enum SurfaceType{
		PVC, WOOD, ACRYLIC, CONCRETE 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surfaceType == null) ? 0 : surfaceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Court other = (Court) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surfaceType != other.surfaceType)
			return false;
		return true;
	}
}
