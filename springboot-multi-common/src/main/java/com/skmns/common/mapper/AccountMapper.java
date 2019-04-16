package com.skmns.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.skmns.common.model.Account;

@Mapper
public interface AccountMapper {
  List<Account> selectAll();

  Account select(String account);

  int insert(Account account);

  int update(Account account);

	int delete(int id);
}
