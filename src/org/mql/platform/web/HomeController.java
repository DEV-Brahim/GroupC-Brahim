package org.mql.platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
