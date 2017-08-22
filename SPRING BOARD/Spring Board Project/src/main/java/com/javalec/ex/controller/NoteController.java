package com.javalec.ex.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.ex.dto.CustomUserDetails;
import com.javalec.ex.dto.NoteDto;
import com.javalec.ex.service.NoteServiceImpl;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	SqlSession sqlsession;
	
	NoteServiceImpl service = new NoteServiceImpl();
	
	@RequestMapping("/receivelist")
	public String note(Model model,Principal principal)
	{
		
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//현재 로그인 중인 사용자의 닉네임을 가져오기 위해
		model.addAttribute("list",service.receivelist(sqlsession,user.getbNick()));
		
		return "note";
	}
	
	@RequestMapping("/write_view")
	public String note_write_view(Model model,Principal principal)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//현재 로그인 중인 사용자의 닉네임을 가져오기 위해
		model.addAttribute("sender",user.getbNick());
		return "note_write_view";
	}
	
	@RequestMapping("/reply_view")
	public String note_reply(@RequestParam("Id") int id,Model model)
	{
		model.addAttribute("noteDto",service.content_view(sqlsession, id));
		return "note_reply_view";
	}
	
	@RequestMapping("/content_view")
	public String note_content_view(@RequestParam("Id") int id,Model model)
	{
		model.addAttribute("noteDto",service.content_view(sqlsession, id));
		return "note_content_view";
	}
	
	@RequestMapping("/receive_delete") //받은쪽지함 삭제
	public String note_receive_delete(@RequestParam("Id") int id,Model model)
	{
		service.delete(sqlsession, id);
	    return "redirect:/note/receivelist";
	}
	
	@RequestMapping("/write")
	public String note_write(NoteDto noteDto)
	{
		service.insert(sqlsession, noteDto);
		
		return "redirect:/note/receivelist";
	}
	
	
}
