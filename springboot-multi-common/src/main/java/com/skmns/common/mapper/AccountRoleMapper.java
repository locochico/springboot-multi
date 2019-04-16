package com.skmns.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRoleMapper {

  public List<String> selectAuthority(Long no);

}
