package rs.code9.badminton.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.Slot;
import rs.code9.badminton.model.User;
import rs.code9.badminton.repository.CourtJpaRepository;
import rs.code9.badminton.repository.SlotJpaRepository;
import rs.code9.badminton.repository.UserJpaRepository;

/**
 * Implementation of slot service.
 *
 * @see rs.code9.badminton.service.SlotService
 * @author p.stanic
 */
@Service
@Transactional(readOnly = true)
public class SlotService {
	/**
	 * Slot repository.
	 */
	@Autowired
	private SlotJpaRepository slotRepository;
	
	@Autowired
	private CourtJpaRepository courtRepository;
	
	@Autowired
	private UserJpaRepository userRepository;

	/**
	 * Returns <code>List</code> of reserved slots for a given court.
	 *
	 * @param courtId Id of the court for which the slots are retrieved.
	 * @param startDate Start date from which the slots are retrieved.
	 * @param endDate End date for which are slots retrieved.
	 * @return <code>List</code> of reserved slots for a given court (can be empty).
	 */
	public List<Slot> findSlotsForCourt(Long courtId, Date startDate, Date endDate) {
		return slotRepository.findByCourt(courtId, startDate, endDate);
	}
	
	/**
	 * Returns <code>List</code> of reserved slots for a given court and user.
	 * 
	 * @param courtId
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Slot> findSlotsForCourtAndUser(Long courtId, Long userId,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cancels reservation of the slot.
	 *
	 * @param slotId Id of Slot which is cancelled.
	 * @return <code>True</code> if slot is successfully cancelled.
	 */
	public boolean cancelSlot(Long slotId) {
		try {
			slotRepository.delete(slotId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	/**
	 * Reserves a slot on given date and time (only full hours) and on a given court for the active user.
	 *
	 * @param courtId Id of the court on which the slot is reserved.
	 * @param userId id of the user to reserve slot to.
	 * @param dateAndTime Date and time (full hour) of the slot.
	 * @return Slot object if reservation is successful, <code>null</code> otherwise.
	 */
	@Transactional(readOnly = false)
	public Slot reserveSlotOnCourtForUser(Long courtId, Long userId,
			Date dateTime) {
		Slot slot = null;
		// first check how many slots user reserved for the current day
		DateTime start = new DateTime(dateTime).withMillisOfDay(0);
		DateTime end = start.plusSeconds(24 * 60 * 60 * 1000);
		List<Slot> alreadyReserved = slotRepository.findByUserIdAndDate(userId, start.toDate(), end.toDate());
		
		if (alreadyReserved == null || alreadyReserved.size() < 2) {
			slot = new Slot();
			slot.setCancelled(false);
			slot.setCourt(courtRepository.findOne(courtId));
			slot.setPaid(false);
			slot.setStart(dateTime);		
			User user = userRepository.findOne(userId);
			slot.setTitle(user.getFirstName());
			slot.setUser(user);
			
			slot = slotRepository.save(slot);
		}
		return slot;
	}
}
	
