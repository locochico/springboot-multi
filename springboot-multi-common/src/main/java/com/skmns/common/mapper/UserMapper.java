package com.skmns.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.skmns.common.model.User;

@Mapper
public interface UserMapper {
	List<User> selectAll();

	User select(int id);

  User selectAuthenticate(String name);

	int insert(User user);

	int update(User user);

	int delete(int id);
}
