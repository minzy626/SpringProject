package com.javalec.ex.dao;

import java.util.List;

import com.javalec.ex.dto.CDto;

public interface CommentDao {
	// �� ��� ���
	public void cWrite(CDto cdto);
	// ��� �����ϱ�
	public void cUpdate(CDto cdto);
	// ��� �����ϱ�
	public void cDelete(Integer cId);
	// bId ��° �Խù��� �ش��ϴ� ��� ����Ʈ ��������
	public List<CDto> cListAll(Integer bId);
}
