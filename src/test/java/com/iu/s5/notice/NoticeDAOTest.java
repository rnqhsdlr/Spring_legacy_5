package com.iu.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	@Test
	public void boardWriteTest() throws Exception{
		NoticeVO noticeVO= new NoticeVO();
		noticeVO.setTitle("test title");
		noticeVO.setWriter("test writer");
		noticeVO.setContents("test contents");
		int result= noticeDAO.boardWrite(noticeVO);
		
		assertEquals(1, result);
	}
	@Test
	public void boardDeleteTest() throws Exception{
		int result = noticeDAO.boardDelete(7);
		assertNotEquals(0, result);
	}
	@Test
	public void boardUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test2");
		noticeVO.setContents("test2 cont");
		noticeVO.setNum(1);
		
		int result = noticeDAO.boardUpdate(noticeVO);
		assertEquals(1, result);
	}
	
	@Test
	public void hitUpdateTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setHit(0);
		noticeVO.setNum(1);
		
		int result = noticeDAO.hitUpdate(noticeVO);
		assertEquals(1, result);
		
	}
	
}
