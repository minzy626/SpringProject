package com.javalec.ex.dao;

import java.util.List;

import com.javalec.ex.dto.BDto;
import com.javalec.ex.dto.BSearchDto;
import com.javalec.ex.dto.SearchingPageDto;

public interface BoardDao {
	
	// �Խù� ��ȸ(bId�� �ش��ϴ� ���� �Խù� ��ȸ)
	public BDto read(Integer bId);
	// �Խù� ������Ʈ
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
}
