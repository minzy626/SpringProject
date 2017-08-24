package com.javalec.ex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UrlPathHelper;

import com.javalec.ex.dto.CustomUserDetails;
import com.javalec.ex.dto.NoteDto;
import com.javalec.ex.service.NoteServiceImpl;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	NoteServiceImpl service;

	@RequestMapping("/receivelist") //���� ������.
	public String receivelist(Model model,Principal principal)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//���� �α��� ���� ������� �г����� �������� ����
		model.addAttribute("list",service.receivelist(user.getbNick()));
		
		return "note";
	}
	
	@RequestMapping("/sendlist") //���� ������
	public String sendlist(Model model,Principal principal)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//���� �α��� ���� ������� �г����� �������� ����
		model.addAttribute("list",service.sendlist(user.getbNick()));
		
		return "send_note";
	}
	
	@RequestMapping("/write_view") 
	public String note_write_view(Model model,Principal principal)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//���� �α��� ���� ������� �г����� �������� ����
		model.addAttribute("sender",user.getbNick());
		return "note_write_view";
	}
	
	@RequestMapping("/reply_view")
	public String note_reply(@RequestParam("Id") int id,Model model)
	{
		model.addAttribute("noteDto",service.receive_content_view( id));
		return "note_reply_view";
	}
	
	@RequestMapping("/content_view") //�����Կ��� ���� �о�����.
	public String note_content_view(@RequestParam("Id") int id,Model model)
	{
		NoteDto noteDto = service.receive_content_view( id);
		model.addAttribute("noteDto",noteDto);
		service.update_send_check(id); //����������� �� �о��ٰ� �˷���
		service.update_receive_check( id);//���� �о��ٰ� üũ��.
		return "note_content_view";
	}
	
	@RequestMapping("/content_view2") // ���� �����Կ��� ���� �о�����
	public String note_content_view2(@RequestParam("Id") int id,Model model)
	{
		model.addAttribute("noteDto",service.send_content_view( id));
		return "note_content_view2";
	}
	
	@RequestMapping("/receive_delete") //���������� ����
	public String note_receive_delete(@RequestParam("Id") int id,Model model)
	{
		service.receive_delete( id);
	    return "redirect:/note/receivelist";
	}
	
	@RequestMapping("/send_delete") //���������� ����
	public String note_send_delete(@RequestParam("Id") int id,Model model)
	{
		service.send_delete( id);
	    return "redirect:/note/sendlist";
	}
	
	@RequestMapping("/receive_delete_all") //���������� ��ü ����
	public String note_receive_delete_all(Principal principal,Model model)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//���� �α��� ���� ������� �г����� �������� ����
		service.delete_receive_all( user.getbNick());
	    return "redirect:/note/receivelist";
	}
	
	@RequestMapping("/send_delete_all") //���� ������ ��ü ����
	public String note_send_delete_all(Principal principal,Model model)
	{
		CustomUserDetails user = (CustomUserDetails)((Authentication)principal).getPrincipal();//���� �α��� ���� ������� �г����� �������� ����
		service.delete_send_all( user.getbNick());
	    return "redirect:/note/sendlist";
	}
	
	
	@RequestMapping("/write")
	public void note_write(NoteDto noteDto,HttpServletResponse response) throws IOException
	{
		service.insert(noteDto);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('���������� ������ ���� �Ǿ����ϴ�.');opener.parent.location.reload();window.close();</script>");
        out.flush();

        return;
	}
	
	
}
