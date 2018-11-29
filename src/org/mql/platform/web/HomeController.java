package org.mql.platform.web;


import org.mql.platform.business.RoleService;
import org.mql.platform.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mehdithe
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private RoleService rs;
	
	Role rol = new Role();

	@GetMapping("/demo")
	public String get() {
		
		return "test";
	}
	
	@GetMapping("/roletest")
	public ModelAndView getroletest() {
		ModelAndView mav = new ModelAndView("roletest");
		mav.addObject("list", rs.getAllRoles());
		return mav;
	}

	/*@GetMapping("/showrole")
	public ModelAndView getshowrole() {
		ModelAndView mav = new ModelAndView("roletest");
		
		r = rr.findAll();
		for (Role role : r) {
			System.out.println("Id : " + role.getId() + " // Name : " + role.getName());
		}
		mav.addObject("list", r);
		return mav;
	}*/

	@RequestMapping(value = "/addrole", method = RequestMethod.GET)
	public ModelAndView addRole(@RequestParam("role") String role) {
		ModelAndView mav = new ModelAndView("roletest");
		rs.addRole(new Role(role));
		String msg = "Bien Ajouter";
		mav.addObject("message", msg);
		mav.addObject("list", rs.getAllRoles());
		return mav;
	}
	
	@RequestMapping(value = "/deleterole", method = RequestMethod.GET)
	public ModelAndView deleteRole(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("roletest");
		rs.deleteRole(id);
		String msg = "Bien Supprumer";
		mav.addObject("message", msg);
		mav.addObject("list", rs.getAllRoles());
		return mav;
	}
	
	@RequestMapping(value = "/getrole", method = RequestMethod.GET)
	public ModelAndView getRole(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("roletest");
		mav.addObject("getrole", rs.getRoleById(id));
		mav.addObject("list", rs.getAllRoles());
		return mav;
	}
}
