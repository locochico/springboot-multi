package com.skmns.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.skmns.common.mapper.UserMapper;
import com.skmns.common.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(int id) {
        return userMapper.select(id);
    }

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    public void addUser(User user) {
    	userMapper.insert(user);
    }
    
    public void updateUser(User user) {
    	userMapper.update(user);
    }
    
    public void deleteUser(int id) {
    	userMapper.delete(id);
    }

  public User authenticate(String id) {
    return userMapper.selectAuthenticate(id);
  }

}
