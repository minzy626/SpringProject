package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.dto.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/index")
	public String Index(Model model,HttpSession httpSession) {
		
		return "index";
	}

	
	
	
	@RequestMapping(value="/lock_screen", method = RequestMethod.GET)
	public String Lock_Screen(Model model) {
		return "lock_screen";
	}
	
	@RequestMapping(value="/morris", method = RequestMethod.GET)
	public String Moriss(Model model) {
		return "morris";
	}
	
	@RequestMapping(value="/panels", method = RequestMethod.GET)
	public String Panels(Model model) {
		return "panels";
	}
	
	@RequestMapping(value="/responsive_table", method = RequestMethod.GET)
	public String Responsive_Table(Model model) {
		return "responsive_table";
	}
	
	@RequestMapping(value="/todo_list", method = RequestMethod.GET)
	public String Todo_List(Model model) {
		return "todo_list";
	}
	
	@RequestMapping(value="/general", method = RequestMethod.GET)
	public String General(Model model) {
		return "general";
	}
	@RequestMapping(value="/gallery", method = RequestMethod.GET)
	public String Gallery(Model model) {
		return "gallery";
	}
	@RequestMapping(value="/form_component", method = RequestMethod.GET)
	public String Form_Component(Model model) {
		return "form_component";
	}
	@RequestMapping(value="/chartjs", method = RequestMethod.GET)
	public String Chartjs(Model model) {
		return "chartjs";
	}
	@RequestMapping(value="/calendar", method = RequestMethod.GET)
	public String Calendar(Model model) {
		return "calendar";
	}
	@RequestMapping(value="/buttons", method = RequestMethod.GET)
	public String Buttons(Model model) {
		return "buttons";
	}
	
	@RequestMapping(value="/blank", method = RequestMethod.GET)
	public String Blank(Model model) {
		return "blank";
	}
	
	
	
	@RequestMapping(value="/basic_table", method = RequestMethod.GET)
	public String Basic_Table(Model model) {
		return "basic_table";
	}
	
	
}
