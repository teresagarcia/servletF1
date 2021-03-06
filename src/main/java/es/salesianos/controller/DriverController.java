package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Driver;
import es.salesianos.model.Nationality;
import es.salesianos.model.Team;
import es.salesianos.service.DriverService;
import es.salesianos.service.NationalityService;
import es.salesianos.service.TeamService;

@Controller
public class DriverController {

	@Autowired
	private DriverService driverService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private NationalityService nationService;

	@RequestMapping(path = "/addDriver", method = RequestMethod.POST)
	public ModelAndView addDriver(Driver driver) {
		driverService.insert(driver);
		return loadDriversList();
	}

	@RequestMapping(path = "/addDriver", method = RequestMethod.GET)
	public ModelAndView addDriver() {
		List<Team> teamsList = teamService.listAllTeams();
		List<Nationality> nationsList = nationService.listAllNations();
		ModelAndView model = new ModelAndView("addDriver");
		model.addObject("teams", teamsList);
		model.addObject("nations", nationsList);
		return model;
	}

	@RequestMapping(path = "/driver", method = RequestMethod.GET)
	public ModelAndView loadDriversList() {
		List<Driver> driversList = driverService.listAllDrivers();
		ModelAndView model = new ModelAndView("driver");
		model.addObject("listAllDrivers", driversList);
		return model;
	}

	@GetMapping("/confirmDeleteDriver")
	public ModelAndView confirmDeleteDriver(@RequestParam Integer id) {
		ModelAndView model = new ModelAndView("deleteDriver");
		model.addObject("id", id);
		return model;
	}

	@GetMapping("/deleteDriver")
	public ModelAndView deleteDriver(@RequestParam String answer, @RequestParam Integer id) {
		if (answer.equals("SI"))
			driverService.deleteDriver(id);
		return loadDriversList();
	}

	@GetMapping("/editDriver")
	public ModelAndView getDataToEditDriver(@RequestParam Integer id) {
		Driver driver = driverService.search(id);
		ModelAndView model = new ModelAndView("editDriver");
		model.addObject("driver", driver);
		List<Team> teamsList = teamService.listAllTeams();
		List<Nationality> nationsList = nationService.listAllNations();
		model.addObject("teams", teamsList);
		model.addObject("nations", nationsList);
		return model;
	}

}
