package com.javalec.ex.BoardService;

import java.util.List;

import com.javalec.ex.dto.CDto;

public interface CommentService {
	// 새 댓글 등록
		public void cWrite(CDto cdto);
		// 댓글 수정하기
		public void cUpdate(CDto cdto);
		// 댓글 삭제하기
		public void cDelete(Integer cId);
		// bId 번째 게시물에 해당하는 댓글 리스트 가져오기
		public List<CDto> cListAll(Integer bId);
		// 댓글 읽음 처리(게시물 작성자가 자신의 게시물 읽은 경우)
		public void isSeenToTrue(Integer cBoardNum);
		// 아직 읽지않은 댓글 수 가져오기(새로운 댓글 알림용)
		public int cGetNewCommentCount(String bName);
		// 아직 읽지않은 댓글의 cDto객체를 가져오기(알림 상세내용 보여주기용)
		public List<CDto> cGetNewCommentDetails(String bName);
}
