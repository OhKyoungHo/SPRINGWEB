package com.javassem.service;

import java.util.List;
import com.javassem.domain.ReplyVO;

public interface ReplyService {
	
	int insertReply(ReplyVO vo); 
	
	List<ReplyVO> selectAllReply();
	
	int deleteReply(Integer rno);
	
	void updateReply(ReplyVO vo);

}
