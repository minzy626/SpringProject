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
}
