package com.javalec.ex.controller;

import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.javalec.ex.dao.UserDaoImpl;
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
	UserDaoImpl dao;
	
	SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
	String todate =  formatter.format(new Date());
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(SearchingPageDto spdto, Model model) {

		model.addAttribute("list", service.listSearchCriteria(spdto));
		model.addAttribute("listNotice", service.listNotice());
		
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));
		model.addAttribute("serverTime", todate);
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
	public void readGET(@RequestParam("bId") Integer bId, @ModelAttribute("spdto") SearchingPageDto spdto, Model model, Principal principal)
	{
		
		logger.info("readGET is called......");
		
		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " +spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " +spdto.getbKeyword());
		System.out.println("read:");
		service.upHit(bId);
		model.addAttribute("spdto", spdto);
		//BDto 객체를 저장하고 나중에 추가, 여기서 게시물 작성자의 정보를 가져온다.
		BDto dto=new BDto();
		dto=service.read(bId);
		model.addAttribute("BDto", dto);
		model.addAttribute("commentList", cService.cListAll(bId));
		if(principal==null) System.out.println("read: if(principal==null) 로그인 안되어있으면 여기에 걸림!!");
		else
		{
			System.out.println("read: if(principal!=null) 로그인 되어있으면 여기에 걸림!!");
			CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();
			// 디버그용!
			System.out.println("접속중인사람: "+user.getbNick());
			System.out.println("글쓴사람: "+dto.getbName());
			if(user.getbNick().equals(dto.getbName())) {
				cService.isSeenToTrue(bId);
				String equal = "true";
				model.addAttribute("equal", equal);
				System.out.println("read: if(principal!=null) if(user.getbNick()==dto.getbName()) 둘다 걸림!!!");
			}
		}
		// 자신이 쓴 글을 읽는경우, 해당 게시물의 댓글을 모두 읽음 처리한다.
		
	}// readGET()
	
	@RequestMapping(value="/modify_view", method= RequestMethod.GET)
	public void modifyView(@RequestParam("bId") Integer bId, 
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
	public String write(BDto Dto, RedirectAttributes rttr,HttpServletRequest request, HttpServletResponse response)
	{
		int count = service.writeCount(Dto);
		if(count >= 5) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('하루 글 작성 가능 개수는 5개까지입니다.');history.go(-1);</script>");
				out.flush();
				logger.info(request.getRemoteAddr());
				dao.insert_ip_ban(request.getRemoteAddr());
				return "write_view";
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		else
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
