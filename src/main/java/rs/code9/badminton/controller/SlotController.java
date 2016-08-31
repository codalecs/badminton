package rs.code9.badminton.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.code9.badminton.model.Slot;
import rs.code9.badminton.model.User;
import rs.code9.badminton.service.SlotService;
import rs.code9.badminton.service.UserService;

/**
 * Controller for handling slot related requests.
 *
 * @author p.stanic
 */
@RestController
@RequestMapping("/courts/{courtId}/slots")
public class SlotController {

	/**
	 * Time slot service for courts.
	 */
	@Autowired
	private SlotService slotService;
	
	@Autowired
	private UserService userService;

	/**
	 * Retrieves reserved slots for a court.
	 *
	 * @param courtId Court ID
	 * @param start Unix time stamp from which slots are retrieved
	 * @param end Unix time stamp until which slots are retrieved
	 * @return <code>List</code> of reserved slots for a given court
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Slot> getSlotsForCourt(
			@PathVariable long courtId,
			@RequestParam(value = "start") Date startDate,
			@RequestParam(value = "end") Date endDate) {
		
		return slotService.findSlotsForCourt(courtId, startDate, endDate);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String reserveSlotForCurrentUser(
			@PathVariable long courtId,
			@RequestParam(value = "start") Date startDate) {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByEmail(principal.getUsername());
		Slot slot = slotService.reserveSlotOnCourtForUser(courtId, user.getId(), startDate);
		String retVal = "Success";
		if (slot == null) {
			retVal = "You are not able to book an appointment.";
		}
		return retVal;
	}

	@RequestMapping(value = "{slotId}", method = RequestMethod.POST, params = "cancel")
	public String cancelSlot(@PathVariable long slotId) {
		String retVal = "Success";
		boolean success = slotService.cancelSlot(slotId);
		if (!success) {
			retVal = "You are not able to cancel appointments.";
		}
		return retVal;
	}
}
