package su.boot.react.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dept2Controller {
	private static final Logger logger = LogManager.getLogger(Dept2Controller.class);
	
	@GetMapping("/DeptSelectView")
	public String selectAllView() {
		logger.info("내용");
		return "dept/dept_axiosreact";
	}
}
