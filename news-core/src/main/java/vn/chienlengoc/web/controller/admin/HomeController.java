package vn.chienlengoc.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.chienlengoc.constant.SystemConstant;
import vn.chienlengoc.core.repository.UserRepository;

@Controller(value = "homeOfAdmin")
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		mav.addObject("user", userRepository.findOneByUserName(SystemConstant.ROLE_ADMIN));
		return mav;
	}
}
