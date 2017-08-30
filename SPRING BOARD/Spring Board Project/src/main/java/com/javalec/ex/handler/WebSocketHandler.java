package com.javalec.ex.handler;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.javalec.ex.BoardService.CommentService;
import com.javalec.ex.dao.NoteDao;

@Repository
public class WebSocketHandler extends TextWebSocketHandler {
	
	@Autowired
	SqlSession sqlsession;
	@Inject
	CommentService service;
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	// ���� ���� ��(�Ű�����:WebSocketSession-������ ���� Ŭ���̾�Ʈ, CloseStatus-�������)
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
	}
	// ���Ӱ��� �̺�Ʈ�Լ�(�Ű�����:WebSocketSession-������ �����)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}

	// send(c to s) emit(s to c) �� ���� �̺�Ʈ ó��
	// (�Ű�����:������ �����, �޽��� ����)
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		NoteDao dao = sqlsession.getMapper(NoteDao.class);
//		this.logger.info(message.getPayload());
//		session.sendMessage(new TextMessage(dao.count_receive_note(message.getPayload()))); //���� �����ڿ��� ��� �޼����� ���ִ��� ��񿡼� �˻���.	
//	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String bNick=message.getPayload();
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		// ���� �����ڿ��� ��� �޼����� ���ִ��� ��񿡼� �˻���.
		String noteCnt=dao.count_receive_note(bNick);
		// ���� �������� ����ڰ� ���� �������� ����� �� ������ �����ɴϴ�.
		String notificationCnt=Integer.toString(service.cGetNewCommentCount(bNick));
		
		String jsonStr="{\"noteCnt\":"+noteCnt+", \"notificationCnt\":"+notificationCnt+"}";
		session.sendMessage(new TextMessage(jsonStr));
	}

}
/*var info='{\
  "font-size":30,\
  "font":"arial",\
  "a":"A"\
}
var jsonStr="{\"noteCnt\":"+noteCnt+", \"alarmCnt\":"+alarmCnt+"}"
*/