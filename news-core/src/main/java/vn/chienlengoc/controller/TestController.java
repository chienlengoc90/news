package vn.chienlengoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testProject() {
		ModelAndView mav = new ModelAndView("test");
		return mav;
	}
}
