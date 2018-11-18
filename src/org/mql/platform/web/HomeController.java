package org.mql.platform.web;

import org.mql.platform.business.RoleService;
import org.mql.platform.business.impl.DefaultRoleService;
import org.mql.platform.models.Role;
import org.springframework.data.repository.query.Param;
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

  @GetMapping("/demo")
  public String get() {
  	// added a comment
    return "test";
  }
  
  @GetMapping("/roletest")
  public String getroletest() {
  	// added a comment
    return "roletest";
  }
  
  @RequestMapping(value = "/addrole", method = RequestMethod.GET)
  public ModelAndView addRole(@RequestParam("role") String role) {
	  ModelAndView mav = new ModelAndView("resultrole");
	  RoleService rs = new DefaultRoleService();
	  /*Role rolet = new Role(1, "m2");
	  rs.addRole(rolet);*/
	  Role resultrole = new Role();
	  resultrole = rs.getRoleById(1);
	  String msg = "Bien Ajouter";
	  mav.addObject("message", msg);
	  mav.addObject("role", resultrole);
	  return mav;
  }
}
