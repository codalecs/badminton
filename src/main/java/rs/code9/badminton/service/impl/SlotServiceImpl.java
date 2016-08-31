package rs.code9.badminton.service.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.code9.badminton.model.Slot;
import rs.code9.badminton.model.User;
import rs.code9.badminton.repository.CourtRepository;
import rs.code9.badminton.repository.SlotRepository;
import rs.code9.badminton.repository.UserRepository;
import rs.code9.badminton.service.SlotService;

/**
 * Implementation of slot service.
 *
 * @see rs.code9.badminton.service.SlotService
 * @author p.stanic
 */
@Service
@Transactional(readOnly = true)
public class SlotServiceImpl implements SlotService {
	/**
	 * Slot repository.
	 */
	@Autowired
	private SlotRepository slotRepository;
	
	@Autowired
	private CourtRepository courtRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * @see rs.code9.badminton.service.SlotService#findSlotsForCourt(java.lang.Long, java.util.Date, java.util.Date)
	 */
	public List<Slot> findSlotsForCourt(Long courtId, Date startDate, Date endDate) {
		return slotRepository.findByCourt(courtId, startDate, endDate);
	}
	
	public List<Slot> findSlotsForCourtAndUser(Long courtId, Long userId,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see rs.code9.badminton.service.SlotService#cancelSlot(java.lang.Long)
	 */
	public boolean cancelSlot(Long slotId) {
		try {
			slotRepository.delete(slotId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional(readOnly = false)
	public Slot reserveSlotOnCourtForUser(Long courtId, Long userId,
			Date dateTime) {
		Slot slot = null;
		// first check how many slots user reserved for the current day
		DateTime start = new DateTime(dateTime).withMillisOfDay(0);
		DateTime end = start.plusSeconds(24 * 60 * 60 * 1000);
		List<Slot> alreadyReserved = slotRepository.findByUserIdAndDate(userId, start.toDate(), end.toDate());
		
		//alreadyReserved.stream().filter(u -> u.getPaid() == true );
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
	
