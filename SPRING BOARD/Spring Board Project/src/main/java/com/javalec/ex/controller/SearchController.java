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

		
		System.out.println("list:");
		// ���� SearchingPageDto�� page, perPageNum, searchType, keyword�� ����. ����Ʈ ����
		model.addAttribute("list", service.listSearchCriteria(spdto));
		
		// ������ ����(���)
		BPageDto bPage = new BPageDto();
		bPage.setSdto(spdto);
		bPage.setTotalCount(service.searchBoardTotalCount(spdto));

		model.addAttribute("bPage", bPage);
		// ������ �߿��� page, perPageNum, searchType, keyword�� �����Ǿ�� �ϹǷ�
		// BPageDto���� makeSearch��� �̸����� �޼ҵ带 ���� UriComponent�� �̿��ؼ� uri���ڿ��� ������.
	}
	
	// /read?bno=?&page=?&perPageNum=?&searchType=?&keyword=?(�̷� ���·�) bId,������,�˻������ �ش��ϴ� �Խù��� ��ȸ�ϴ� ���.
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	// @ModelAttribute �� �Ķ���͸� �����ϸ� ������ ���ڿ��� ȭ�����α��� ���� ��.
	public void readGET(@RequestParam("bId") Integer bId, @ModelAttribute("spdto") SearchingPageDto spdto,
			Model model) {
		
		System.out.println("read:");
		model.addAttribute("spdto", spdto);
		model.addAttribute("BDto", service.read(bId));

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("bId") Integer bId, @ModelAttribute("spdto") SearchingPageDto spdto,
			Model model) {

		logger.info("updateGET is called......");

		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " + spdto.getbKeyword());

		model.addAttribute("BDto", service.read(bId));

	}// updateGET()

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(BDto Dto, SearchingPageDto spdto, RedirectAttributes rttr) {

		logger.info("sboard updatePOST is called......");

		logger.info(" page : " + spdto.getbPage().toString());
		logger.info(" perPageNum : " + spdto.getbPerPageNum().toString());
		logger.info(" searchType : " + spdto.getbSearchType());
		logger.info(" keyword : " + spdto.getbKeyword());

		service.update(Dto);

		rttr.addAttribute("bPage", spdto.getbPage());
		rttr.addAttribute("bPerPageNum", spdto.getbPerPageNum());
		rttr.addAttribute("bSearchType", spdto.getbSearchType());
		rttr.addAttribute("bKeyword", spdto.getbKeyword());

		rttr.addFlashAttribute("updateMsg", "success");

		return "redirect:/list";
	}// updatePOST()

}
