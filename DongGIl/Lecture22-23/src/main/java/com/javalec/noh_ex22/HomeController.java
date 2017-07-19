package com.javalec.noh_ex22;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.noh_ex22.Dto.Dto;
import com.javalec.noh_ex22.com.ITicketCom;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private Dao dao;
	private ITicketCom ticketCom;
//	@Autowired
//	public void setDao(Dao dao) {
//		this.dao = dao;
//	}
	
	@Autowired
	public void setITicketCom(ITicketCom ticketCom) {
		this.ticketCom = ticketCom;
	}
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
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
		
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(Dto ticketDto, Model model) {
		System.out.println( "buy_ticket_card" );
		System.out.println( "ticketDto : " + ticketDto.getConsumerID() );
		System.out.println( "ticketDto : " + ticketDto.getAmount() );
		
	//	dao.buyTicket(ticketDto);
		ticketCom.execute(ticketDto);
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}
	
}
