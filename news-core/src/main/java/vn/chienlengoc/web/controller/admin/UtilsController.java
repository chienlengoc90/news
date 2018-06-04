package vn.chienlengoc.web.controller.admin;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "utilsControllerOfAdmin")
public class UtilsController {
	private static final Logger log = Logger.getLogger(UtilsController.class);
	
	@RequestMapping(value = "/admin/utils/upload", method = RequestMethod.GET)
	public ModelAndView getUpload() {
		ModelAndView mav = new ModelAndView("admin/utils/upload");
		return mav;
	}

	@RequestMapping(value = "/admin/utils/upload", method = RequestMethod.POST)
	public ModelAndView postUpload(@RequestParam("fileUploads") MultipartFile multipartFile) {
	 try {
	
//		for (MultipartFile f : multipartFile) {
//			String fileName = f.getOriginalFilename();
//			File file = new File("E:/files", fileName);
//			f.transferTo(file);
//		}
		 String fileName = multipartFile.getOriginalFilename();
	      File file = new File("E:/files", fileName);
	      multipartFile.transferTo(file);
		 } catch (Exception e) {
			 log.error(e);
		 }
		ModelAndView mav = new ModelAndView("admin/utils/upload");
		return mav;

	}
}
