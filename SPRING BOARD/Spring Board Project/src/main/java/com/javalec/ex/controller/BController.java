package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.service.BService;
import com.javalec.ex.service.BContentService;
import com.javalec.ex.service.BDeleteService;
import com.javalec.ex.service.BListService;
import com.javalec.ex.service.BModifyService;
import com.javalec.ex.service.BWriteService;


@Controller
public class BController {
	BService command=null;
	
	@Autowired
	SqlSession sqlsession;
	
	public BController() {
		
	}
	
	
	@RequestMapping("/list") //게시판 글 목록 가져오기
	public String list(Model model) // Controller->Command->DAO를 거쳐서 데이터를 다시 가져오므로 model객체를 인자로 받아야함. 
	{
		command = new BListService();
		command.execute(sqlsession,model); //컨트롤러에서 Command로 제어를 넘김 (모델에 정보를 계속 담아야 하므로 인자로 넣음)
		return "list"; //list.jsp를 실행하기 위함.
	}

	
	
	@RequestMapping(value="/write", method = RequestMethod.POST) //글 작성
	public String write(BDto bDto,Model model) //글 작성시 작성자,내용등 정보를 가져와야되니까 request를 인자로받아야함.  
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:list"; //글 작성 하고나서는 다시 글 목록이 보여야 하므로 list.jsp호출되게끔.
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		return "write_view";} // 글쓰기 메뉴 눌렀을때 바로 화면만 보여주면 되니까 바로 리턴해주면 됨
	
	
	
	@RequestMapping("/content_view") //글 내용 보기
	public String content_view(HttpServletRequest request,Model model) { //list.jsp에서 글 목로 글릭시 ID값에 해당하는 글을 출력 해줘야 하므로 request 필요
		model.addAttribute("request",request);
		command = new BContentService();
		command.execute(sqlsession,model);  
		return "content_view"; //뷰에 뿌려야함,model에는 값이 섲렁된 dto가 들어있음. jsp파일에서 dto값 꺼내서 쓰면됨.
	} 
	
	
	@RequestMapping(value="/modify") //글 수정하기
	public String modify(BDto bDto,Model model) { 
		BModifyService command = new BModifyService();
		command.execute(sqlsession,bDto);  
		return "redirect:list"; //글 수정한뒤 다시 글 목록 출력
	} 
	//GET방식과 POST방식의 차이  https://blog.outsider.ne.kr/312 
	
	@RequestMapping("/delete") //글 삭제하기
	public String delete(HttpServletRequest request,Model model) { //request에는 글의 id가 저장돼있음. 
		model.addAttribute("request",request);
		command = new BDeleteService(); 
		command.execute(sqlsession,model);   
		return "redirect:list"; 
	}
	
	
	
	
	
	
	
}
