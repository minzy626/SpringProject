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

import com.javalec.ex.BoardService.BoardService;
import com.javalec.ex.BoardService.CommentService;
import com.javalec.ex.dao.NoteDao;
import com.javalec.ex.dto.CDto;

@Repository
public class WebSocketHandler extends TextWebSocketHandler {
	
	@Autowired
	SqlSession sqlsession;
	@Inject
	CommentService cService;
	@Inject
	BoardService bService;
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	// 연결 종료 시(매개변수:WebSocketSession-연결을 끊은 클라이언트, CloseStatus-연결상태)
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
	}
	// 접속관련 이벤트함수(매개변수:WebSocketSession-접속한 사용자)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}

	// send(c to s) emit(s to c) 두 개의 이벤트 처리
	// (매개변수:접속한 사용자, 메시지 내용)
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String bNick=message.getPayload();
		NoteDao dao = sqlsession.getMapper(NoteDao.class);
		// 현재 수신자에게 몇개의 메세지가 와있는지 디비에서 검색함.
		String noteCnt=dao.count_receive_note(bNick);
		// 현재 접속중인 사용자가 아직 읽지않은 댓글의 총 개수를 가져옵니다.
		String notificationCnt=Integer.toString(cService.cGetNewCommentCount(bNick));
		
		//JSON 사용하여 데이터 client로 넘긴다.
		String jsonStr="{\"noteCnt\":"+noteCnt+", \"notificationCnt\":"+notificationCnt+"}";
		
		// 진행중........
		// 이제 jsonStr에 notificationDetails배열을 추가해야함. 한개의 열에 title, nick이 짝을 이루어야....
		for(CDto cdto : cService.cGetNewCommentDetails(bNick)) {
			String title = bService.getBTitleFromBId(cdto.getcBoardNum());
			String nick = cdto.getcNick();
		}
		
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