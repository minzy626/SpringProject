package com.javalec.ex.BoardService;

import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface BoardService {

	public BDto read(Integer bno);
	
	public void update(BDto dto);
	// �������� ��ȸ
	public List<BDto> listNotice();
	
	// �Խù�( ��� �Խù� ��ȸ )
	public List<BDto> listAll();

	// �Խù� ( ����¡ ó�� �Խù� ��ȸ)
	public List<BDto> listCriteria(BSearchDto sdto);

	// �� �Խù� �� ���
	public Integer boardTotalCount();

	// �Խù� ( ����¡ ó�� + �˻���� �Խù� ��ȸ)
	public List<BDto> listSearchCriteria(SearchingPageDto spdto);

	// �� �˻� ��� �Խù� �� ���
	public Integer searchBoardTotalCount(SearchingPageDto spdto);

	// �� �����ϱ�
	public void delete(Integer bId);
}
