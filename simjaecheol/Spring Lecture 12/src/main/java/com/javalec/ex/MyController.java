package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	
	@RequestMapping("/View/")
	public String View() {		
		return "view";
	}
	
	@RequestMapping("/Content/contentView")
	public String ContentView(Model model) {
		model.addAttribute("id","abcde");
		return "/Content/contentView";
	}
	
	@RequestMapping("/model/modelEx")
	public String modelEx(Model model)
	{
		model.addAttribute("data","abcdef");
		return "/model/modelEx";
	}
	
	@RequestMapping("/modelandview/modelview")
	public ModelAndView modelandview() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id","abcde");
		mv.setViewName("modelandview/modelview");
		return mv;
	}
	
	
	
}
