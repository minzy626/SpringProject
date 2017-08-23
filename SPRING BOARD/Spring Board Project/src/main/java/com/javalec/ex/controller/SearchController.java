package com.javalec.ex.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.BoardService.BoardService;
import com.javalec.ex.BoardService.CommentService;
import com.javalec.ex.UserService.WriteCountService;
import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BPageDto;
import com.javalec.ex.dto.CustomUserDetails;
import com.javalec.ex.dto.SearchingPageDto;

@Controller
public class SearchController {

	@Inject
	BoardService service;
	@Inject
	CommentService cService;
	@Autowired
	SqlSession sqlsession;

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_club", method = RequestMethod.GET)
	public void listClubGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_club", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_contest", method = RequestMethod.GET)
	public void listContestGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_contest", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_Slanguage", method = RequestMethod.GET)
	public void listLanguageGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_Slanguage", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_Sjob", method = RequestMethod.GET)
	public void listJobGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_Sjob", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_Smajor", method = RequestMethod.GET)
	public void listMajorGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_Smajor", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value = "/list_Setc", method = RequestMethod.GET)
	public void listEtcGET(SearchingPageDto spdto, Model model) {

		
		model.addAttribute("list_Setc", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);

	}
	
	@RequestMapping(value="/content_view", method= RequestMethod.GET)
	public void readGET(@RequestParam("bId") Integer bId, @ModelAttribute("spdto") SearchingPageDto spdto, Model model)
	{
		
		logger.info("readGET is called......");
		
		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " +spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " +spdto.getbKeyword());
		System.out.println("read:");
		service.upHit(bId);
		model.addAttribute("spdto", spdto);
		model.addAttribute("BDto", service.read(bId));
		model.addAttribute("commentList", cService.cListAll(bId));
		
	}// readGET()
	
	@RequestMapping(value="/modify_view", method= RequestMethod.GET)
	public void writeView(@RequestParam("bId") Integer bId, 
						@ModelAttribute("spdto") SearchingPageDto spdto, 
						Model model)
	{
		logger.info("modify_view is called......");
		
		System.out.println("modify_view:");
		model.addAttribute("spdto", spdto);
		model.addAttribute("BDto", service.read(bId));
	}// readGET()
	
	@RequestMapping(value="/write_view", method= RequestMethod.GET)
	public void writeView(
						@ModelAttribute("spdto") SearchingPageDto spdto, 
						Model model, Principal principal)
	{
		logger.info("writeView is called......");
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();
		System.out.println("write_view:");
		model.addAttribute("spdto", spdto);
		model.addAttribute("connectedUser", user.getbNick());
	}
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(BDto Dto, RedirectAttributes rttr)
	{
		try {
			WriteCountService wService = new WriteCountService();
			wService.execute(sqlsession, Dto);
		}
		catch (Exception e) {
			return "redirect:/list";
		}
		service.write(Dto);
		return "redirect:/list";
	}
	
		@RequestMapping(value="/delete", method= RequestMethod.POST)
		public String deletePOST(@RequestParam("bId") Integer bId,
						SearchingPageDto spdto,
						RedirectAttributes rttr){
			
			service.delete(bId);
			
			logger.info("deletePOST is called......");
			
			logger.info(" page : " + spdto.getbPage().toString());
			logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
			logger.info(" searchType : " + spdto.getbSearchType());
			logger.info(" keyword : " +spdto.getbKeyword());
			
			rttr.addFlashAttribute("bPage", spdto.getbPage());
			rttr.addFlashAttribute("bPerPageNum", spdto.getbPerPageNum());
			rttr.addFlashAttribute("bSearchType", spdto.getbSearchType());
			rttr.addFlashAttribute("bMeetingGroup", spdto.getbMeetingGroup());
			rttr.addFlashAttribute("bSearchRType", spdto.getbSearchRType());
			rttr.addFlashAttribute("bKeyword", spdto.getbKeyword());
			//rttr.addFlashAttribute("spdto", spdto);
//			BPageDto bPage = new BPageDto();
//			bPage.setSdto(spdto);
//			bPage.setTotalCount(service.searchBoardTotalCount(spdto));
//
//			rttr.addAttribute("bPage", bPage);
			
			rttr.addFlashAttribute("msg", "SUCCESS");
			
			return "redirect:/list";
		}// deletePOST()

//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public void updateGET(@RequestParam("bId") Integer bId, @ModelAttribute("spdto") SearchingPageDto spdto,
//			Model model) {
//
//		logger.info("updateGET is called......");
//
//		logger.info(" page : " + spdto.getbPage().toString());
//		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
//		logger.info(" searchType : " + spdto.getbSearchType());
//		logger.info(" keyword : " + spdto.getbKeyword());
//
//		model.addAttribute("BDto", service.read(bId));
//
//	}// updateGET()

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(BDto Dto, SearchingPageDto spdto, RedirectAttributes rttr) {

		logger.info("sboard updatePOST is called......");

		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " + spdto.getbKeyword());
		logger.info(" bTitle : " + Dto.getbTitle());
		service.update(Dto);

		rttr.addFlashAttribute("bPage", spdto.getbPage());
		rttr.addFlashAttribute("bPerPageNum", spdto.getbPerPageNum());
		rttr.addFlashAttribute("bSearchType", spdto.getbSearchType());
		rttr.addFlashAttribute("bSearchMType", spdto.getbMeetingGroup());
		rttr.addFlashAttribute("bSearchRType", spdto.getbSearchRType());
		rttr.addFlashAttribute("bKeyword", spdto.getbKeyword());

		rttr.addFlashAttribute("updateMsg", "success");

		return "redirect:/list";
	}// updatePOST()
	
//	@RequestMapping(value="/write", method = RequestMethod.POST)
//	public String write()

}
