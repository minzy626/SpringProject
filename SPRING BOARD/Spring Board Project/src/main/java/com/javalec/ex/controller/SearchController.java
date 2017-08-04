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


/*@RequestMapping(value="/searchboard/*")*/
@Controller
public class SearchController {

	@Inject
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGET(SearchingPageDto spdto, Model model){
		
		logger.info("listGET is called......");
		logger.info("SearchingPageDto : " + spdto.toString());
		System.out.println("list:");
		// 현재 cri에 page, perPageNum, searchType, keyword가 있다. 
		// 리스트 만들고
		model.addAttribute("list", service.listSearchCriteria(spdto));
		
		// 페이지네이션 만들고(PageMaker 만들어서 cri 셋해주고, 토탈 카운트 셋해주면 저절로 다 계산된다.)
		BPageDto bPage = new BPageDto();

		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));
		
		model.addAttribute("bPage", bPage);

		// 그러면 이제 화면에서 list는 foreach돌아서 뿌려주면 되고,
		// 하단 페이지네이션은 pageMaker에서 스타트부터 끝까지 순회해서 번호 출력하고, 이전, 이후 버튼 출력
		// 근데 이 페이징 중에서도 page, perPageNum, searchType, keyword가 유지되어야 하므로
		// PageMaker에서 makeSearch라는 이름으로 메소드를 만들어서 UriComponent를 이용해서 uri문자열을 만들어낸다.
	}// listGET()
	
		
	// r
	// /read?bno=?&page=?&perPageNum=?&searchType=?&keyword=?, GET	:	bno, 페이징, 검색결과에 해당하는 게시물을 조회한다.
	@RequestMapping(value="/read", method= RequestMethod.GET)
	public void readGET(@RequestParam("bId") Integer bId, 
						// @ModelAttribute 로 파라미터를 수집하면 지정한 문자열로 화면으로까지 전달 된다.
						@ModelAttribute("spdto") SearchingPageDto spdto, 
						Model model)
	{
		logger.info("readGET is called......");
		
		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " +spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " +spdto.getbKeyword());
		System.out.println("read:");
		model.addAttribute("spdto", spdto);
		model.addAttribute("BDto", service.read(bId));
		
	}// readGET()
		
	// d
	// /delete?bno=?&page=?&perPageNum=?&searchType=?&keyword=?, POST	:	bno에 해당하는 게시글을 삭제한다.
	/*@RequestMapping(value="/delete", method= RequestMethod.POST)
	public String deletePOST(@RequestParam("bId") Integer bId,
					SearchingPageDto spdto,
					RedirectAttributes rttr){
		
		// 삭제하고, 
		service.delete(bId);
		
		logger.info("deletePOST is called......");
		
		logger.info(" page : " + spdto.getPage().toString());
		logger.info(" perPageNum : " + spdto.getPerPageNum().toString());
		logger.info(" searchType : " + spdto.getSearchType());
		logger.info(" keyword : " +spdto.getKeyword());
		
		rttr.addAttribute("page", spdto.getPage());
		rttr.addAttribute("perPageNum", spdto.getPerPageNum());
		rttr.addAttribute("searchType", spdto.getSearchType());
		rttr.addAttribute("keyword", spdto.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		// 리스트페이지로 리다이렉트 하자.
		return "redirect:/sboard/list";
	}// deletePOST()
*/	
	// u
	// /update?bno=?&page=?&perPageNum=?&searchType=?&keyword=?, GET	:	bno에 해당하는 게시물의 내용을 수정하기 위해 조회한다.
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void updateGET(@RequestParam("bId") Integer bId,
				@ModelAttribute("spdto") SearchingPageDto spdto,
				Model model){
		
		logger.info("updateGET is called......");
		
		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " +spdto.getbKeyword());
		
		model.addAttribute("BDto", service.read(bId));		
	
	}// updateGET()
	
	// /update?bno=?&page=?&perPageNum=?&searchType=?&keyword=?, POST		:	게시물을 업데이트한다.
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePOST(BDto Dto, SearchingPageDto spdto, RedirectAttributes rttr){
		
		logger.info("sboard updatePOST is called......");
	
		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " +spdto.getbKeyword());
		
		service.update(Dto);
		
		rttr.addAttribute("bPage", spdto.getbPage());
		rttr.addAttribute("bPerPageNum", spdto.getbPerPageNum());
		rttr.addAttribute("bSearchType", spdto.getbSearchType());
		rttr.addAttribute("bKeyword", spdto.getbKeyword());
		
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/list";	
	}// updatePOST()

	
	// c
	// /create, GET		:	게시물의 등록 페이지를 보여준다.
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public void createGET(){
			
		logger.info("createGET is called......");
			
	}// createGET()
		
		
	// /create, POST	:	게시물을 실제로 등록한다.
	/*@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createPOST(BDto dto, RedirectAttributes rttr){
			
		logger.info("createPOST is called......");
			
		service.create(dto);
			
		// 리다이렉트 시 한 번만 값이 담겨져 뷰로 간다.
		rttr.addFlashAttribute("createMsg", "success");
		
		// 새 게시물 등록 후에는 가장 최근글 등록된 페이지 즉 첫 페이지의 리스트를 보여주면 되므로 그냥 /sboard/list로 리다이렉트 해주면된다.
		return "redirect:/sboard/list";
		
	}// createPOST()
*/
}
