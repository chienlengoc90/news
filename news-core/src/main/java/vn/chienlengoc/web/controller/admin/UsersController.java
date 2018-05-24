package vn.chienlengoc.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.chienlengoc.constant.SystemConstant;
import vn.chienlengoc.dto.UserDTO;
import vn.chienlengoc.service.impl.UserService;
import vn.chienlengoc.utils.DisplayTagUtils;

@Controller(value ="usersControllerOfAdmin")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private IRoleService roleService;
	
	@RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO model,
									 HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		DisplayTagUtils.initSearchBean(request, model);
		List<UserDTO> news = userService.getUsers(model.getUserName() , new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
		model.setListResult(news);
		model.setTotalItems(userService.getTotalItems(model.getUserName()));
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}
	
/*	// khi sửa xong trong javax gọi lại
	@RequestMapping(value = "/admin/news/{id}", method = RequestMethod.GET)
	public ModelAndView getNewsById(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		mav.addObject(SystemConstant.MODEL, newsService.findNewsById(id));
		return mav;s
	}
	*/
	
	// khi tạo mới gọi tới
	@RequestMapping(value = "/admin/user/modal", method = RequestMethod.GET)
	public ModelAndView editNewsPage() {
	//	ModelAndView mav = new ModelAndView("admin/user/edit");
		ModelAndView mav = new ModelAndView("admin/user/Modal");
		/*NewsDTO news = new NewsDTO();
		news.setCategories(categoryService.getCategories());
		mav.addObject(SystemConstant.MODEL, news);*/
		return mav;
	}
}
