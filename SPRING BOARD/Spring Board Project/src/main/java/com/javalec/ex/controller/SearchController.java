package com.javalec.ex.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.ex.BoardService.BoardService;
import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BPageDto;
import com.javalec.ex.dto.SearchingPageDto;

@Controller
public class SearchController {

	@Inject
	BoardService service;

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
						Model model)
	{
		logger.info("writeView is called......");
		
		System.out.println("write_view:");
		model.addAttribute("spdto", spdto);
		
	}
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(BDto Dto, RedirectAttributes rttr)
	{
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
