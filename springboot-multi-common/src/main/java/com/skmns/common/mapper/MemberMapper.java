package com.skmns.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.skmns.common.model.Member;

@Mapper
public interface MemberMapper {
	
	public Member selectMember(String userName);
	
  public List<String> selectAuthority(String userName);
}
