package rs.code9.badminton.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rs.code9.badminton.model.Slot;
import rs.code9.badminton.model.User;
import rs.code9.badminton.service.SlotService;
import rs.code9.badminton.service.UserService;
import rs.code9.util.FullCalendarCustomDateEditor;

/**
 * Controller for handling slot related requests.
 *
 * @author p.stanic
 */
@Controller
@RequestMapping("/courts/{courtId}/slots")
public class SlotController {

	/**
	 * Time slot service for courts.
	 */
	@Autowired
	private SlotService slotService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new FullCalendarCustomDateEditor());
	}

	/**
	 * Retrieves reserved slots for a court.
	 *
	 * @param courtId Court ID
	 * @param start Unix time stamp from which slots are retrieved
	 * @param end Unix time stamp until which slots are retrieved
	 * @return <code>List</code> of reserved slots for a given court
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Slot> getSlotsForCourt(
			@PathVariable long courtId,
			@RequestParam(value = "start") Date startDate,
			@RequestParam(value = "end") Date endDate) {
		
		return slotService.findSlotsForCourt(courtId, startDate, endDate);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String reserveSlotForCurrentUser(
			@PathVariable long courtId,
			@RequestParam(value = "start") Date startDate) {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByEmail(principal.getUsername());
		Slot slot = slotService.reserveSlotOnCourtForUser(courtId, user.getId(), startDate);
		String retVal = "Success";
		if (slot == null) {
			retVal = "Niste u mogucnosti da rezervisete termin.";
		}
		return retVal;
	}

	@RequestMapping(value = "{slotId}", method = RequestMethod.POST, params = "cancel")
	public @ResponseBody String cancelSlot(@PathVariable long slotId) {
		String retVal = "Success";
		boolean success = slotService.cancelSlot(slotId);
		if (!success) {
			retVal = "Niste u mogucnosti da otkazete termin.";
		}
		return retVal;
	}
}
