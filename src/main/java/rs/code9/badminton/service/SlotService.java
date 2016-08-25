package rs.code9.badminton.service;

import java.util.Date;
import java.util.List;

import rs.code9.badminton.model.Slot;

/**
 * Service used for working with slots.
 *
 * @author p.stanic
 */
public interface SlotService {

	/**
	 * Returns <code>List</code> of reserved slots for a given court.
	 *
	 * @param courtId Id of the court for which the slots are retrieved.
	 * @param startDate Start date from which the slots are retrieved.
	 * @param endDate End date for which are slots retrieved.
	 * @return <code>List</code> of reserved slots for a given court (can be empty).
	 */
	public List<Slot> findSlotsForCourt(Long courtId, Date startDate, Date endDate);
	
	/**
	 * Returns <code>List</code> of reserved slots for a given court and user.
	 * 
	 * @param courtId
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Slot> findSlotsForCourtAndUser(Long courtId, Long userId, Date startDate, Date endDate);

	/**
	 * Reserves a slot on given date and time (only full hours) and on a given court for the active user.
	 *
	 * @param courtId Id of the court on which the slot is reserved.
	 * @param userId id of the user to reserve slot to.
	 * @param dateAndTime Date and time (full hour) of the slot.
	 * @return Slot object if reservation is successful, <code>null</code> otherwise.
	 */
	public Slot reserveSlotOnCourtForUser(Long courtId, Long userId, Date dateTime);

	/**
	 * Cancels reservation of the slot.
	 *
	 * @param slotId Id of Slot which is cancelled.
	 * @return <code>True</code> if slot is successfully cancelled.
	 */
	public boolean cancelSlot(Long slotId);
}
