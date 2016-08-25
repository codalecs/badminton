/**
 * 
 */
package rs.code9.badminton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.code9.badminton.service.CourtService;

/**
 * @author d.gajic
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private CourtService courtService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handle() {
		return new ModelAndView("home", "courts", courtService.findAll());
	}
}
