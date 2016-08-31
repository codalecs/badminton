package rs.code9.badminton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import rs.code9.util.JsonDateSerializer;

/**
 * Entity class representing a time slot for a court.
 *
 * @author d.gajic
 */
@Entity
@Table(name = "slot")
@JsonAutoDetect
public class Slot extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9105725684878706540L;

	/**
	 * Slot title.
	 */
	private String title;

	/**
	 * Court to which the slot belongs.
	 */
	private Court court;

	/**
	 * User who has reserved this slot.
	 */
	private User user;

	/**
	 * Date and time of the slot.
	 */
	private Date start;

	/**
	 * True if slot can be changed.
	 */
	private Boolean editable = Boolean.TRUE;

	/**
	 * True if slot is cancelled.
	 */
	private Boolean cancelled = Boolean.FALSE;

	/**
	 * True if slot is paid.
	 */
	private Boolean paid = Boolean.FALSE;

	/**
	 * @return title
	 */
	@Column(name = "title", length = 50)
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return court
	 */
	@ManyToOne
	public Court getCourt() {
		return court;
	}

	/**
	 * @param court
	 */
	public void setCourt(Court court) {
		this.court = court;
	}

	/**
	 * @return user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return start
	 */
	@Column(name = "date_start")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getStart() {
		return start;
	}

	/**
	 * @param start
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return editable
	 */
	@Transient
	public Boolean getEditable() {
		return editable;
	}

	/**
	 * @param editable
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	/**
	 * @return cancelled
	 */
	@Column(name = "cancelled")
	public Boolean getCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled
	 */
	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}

	/**
	 * @return paid
	 */
	@Column(name = "paid")
	public Boolean getPaid() {
		return paid;
	}

	/**
	 * @param paid
	 */
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
}
