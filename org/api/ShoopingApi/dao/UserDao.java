package org.api.ShoopingApi.dao;

import org.api.ShoopingApi.dto.User;
import org.api.ShoopingApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
    @Autowired
    private UserRepository repository;
    
    public User saveUser(User user) {
    	return repository.save(user);
    }
    
    public User validate(long phone,String password) {
    	return repository.validate(phone, password);
    }
}
