package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.service.BContentService;
import com.javalec.ex.service.BDeleteService;
import com.javalec.ex.service.BModifyService;
import com.javalec.ex.service.BService;
import com.javalec.ex.service.BWriteService;


@Controller
@RequestMapping("/board")
public class BController {
	BService command=null;
	
	@Autowired
	SqlSession sqlsession;
	
	public BController() {
		
	}
	
<<<<<<< HEAD
	
	/*@RequestMapping("/list") //占쌉쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙
	public String list(Model model) // Controller->Command->DAO占쏙옙 占쏙옙占식쇽옙 占쏙옙占쏙옙占싶몌옙 占쌕쏙옙 占쏙옙占쏙옙占쏙옙占실뤄옙 model占쏙옙체占쏙옙 占쏙옙占쌘뤄옙 占쌨아억옙占쏙옙. 
	{
		command = new BListService();
		command.execute(sqlsession,model); //占쏙옙트占싼뤄옙占쏙옙占쏙옙 Command占쏙옙 占쏙옙占쏘를 占싼깍옙 (占쏜델울옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙틴占� 占싹므뤄옙 占쏙옙占쌘뤄옙 占쏙옙占쏙옙)
		return "list"; //list.jsp占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙.
	}*/

	
	
	@RequestMapping(value="/write", method = RequestMethod.POST) //占쏙옙 占쌜쇽옙
	public String write(BDto bDto,Model model) //占쏙옙 占쌜쇽옙占쏙옙 占쌜쇽옙占쏙옙,占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싶야되니깍옙 request占쏙옙 占쏙옙占쌘로받아억옙占쏙옙.  
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:/board/list"; //占쏙옙 占쌜쇽옙 占싹곤옙占쏙옙占쏙옙 占쌕쏙옙 占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싹므뤄옙 list.jsp호占쏙옙품途占�.
=======
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(BDto bDto,Model model)
	{
		BWriteService command= new BWriteService();
		command.execute(sqlsession,bDto);
		return "redirect:list";
>>>>>>> 0deb6e1e6383add36e31f689112c1196cc272caf
	}
	
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
<<<<<<< HEAD
		return "write_view";} // 占쌜억옙占쏙옙 占쌨댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌕뤄옙 화占썽만 占쏙옙占쏙옙占쌍몌옙 占실니깍옙 占쌕뤄옙 占쏙옙占쏙옙占쏙옙占쌍몌옙 占쏙옙
	
	
	
	@RequestMapping("/content_view") //占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
	public String content_view(HttpServletRequest request,Model model) { //list.jsp占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쌜몌옙占쏙옙 ID占쏙옙占쏙옙 占쌔댐옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占� 占싹므뤄옙 request 占십울옙
		model.addAttribute("request",request);
		command = new BContentService();
		command.execute(sqlsession,model);  
		return "content_view"; //占썰에 占싼뤄옙占쏙옙占쏙옙,model占쏙옙占쏙옙 占쏙옙占쏙옙 占폗占쏙옙占쏙옙 dto占쏙옙 占쏙옙占쏙옙占쏙옙占�. jsp占쏙옙占싹울옙占쏙옙 dto占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占�.
=======
		return "write_view";} 
	
	
	
	@RequestMapping("/content_view") 
	public String content_view(HttpServletRequest request,Model model) { 
		model.addAttribute("request",request);
		command = new BContentService();
		command.execute(sqlsession,model);  
		return "content_view";
>>>>>>> 0deb6e1e6383add36e31f689112c1196cc272caf
	} 
	
	
	@RequestMapping(value="/modify") //占쏙옙 占쏙옙占쏙옙占싹깍옙
	public String modify(BDto bDto,Model model) { 
		BModifyService command = new BModifyService();
		command.execute(sqlsession,bDto);  
<<<<<<< HEAD
		return "redirect:/board/list"; //占쏙옙 占쏙옙占쏙옙占싼듸옙 占쌕쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
	} 
	//GET占쏙옙캅占� POST占쏙옙占쏙옙占� 占쏙옙占쏙옙  https://blog.outsider.ne.kr/312 
	
	@RequestMapping("/delete") //占쏙옙 占쏙옙占쏙옙占싹깍옙
	public String delete(HttpServletRequest request,Model model) { //request占쏙옙占쏙옙 占쏙옙占쏙옙 id占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占�. 
=======
		return "redirect:list";
	} 

	
	@RequestMapping("/delete") //�� �����ϱ�
	public String delete(HttpServletRequest request,Model model) { 
>>>>>>> 0deb6e1e6383add36e31f689112c1196cc272caf
		model.addAttribute("request",request);
		command = new BDeleteService(); 
		command.execute(sqlsession,model);   
		return "redirect:/board/list"; 
	}
	
	
	
	
	
	
	
}
