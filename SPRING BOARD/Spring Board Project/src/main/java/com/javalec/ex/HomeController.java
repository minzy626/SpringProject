package com.javalec.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.BoardService.BoardService;
import com.javalec.ex.dto.BPageDto;
import com.javalec.ex.dto.CustomUserDetails;
import com.javalec.ex.dto.NoteDto;
import com.javalec.ex.dto.SearchingPageDto;
import com.javalec.ex.service.NoteService;
import com.javalec.ex.service.NoteServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	BoardService service;
	@Autowired
	SqlSession sqlsession;
	@Autowired
	NoteServiceImpl noteservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Principal principal) {
		
		return "redirect:/index";
	}
	
	

	@RequestMapping(value = "/index")
	public String listGET(SearchingPageDto spdto, Model model,Principal principal) {
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));
		//CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();
		model.addAttribute("bPage", bPage);
		//model.addAttribute("count",noteservice.note_count(user.getbNick())); //메시지 몇개 왔는지
		return "index";
	}
	
	
	
}