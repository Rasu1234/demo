package org.api.ShoopingApi.Service;

import org.api.ShoopingApi.dao.UserDao;
import org.api.ShoopingApi.dto.ResponseStructure;
import org.api.ShoopingApi.dto.User;
import org.api.ShoopingApi.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
   private UserDao dao;
   
   public ResponseEntity<ResponseStructure<User>> saveUser(User user){
	   user=dao.saveUser(user);
	   ResponseStructure<User> structure=new ResponseStructure<User>();
	   structure.setBody(user);
	   structure.setMessage(user.getName()+""+"saved Sucessfully");
	   structure.setCode(HttpStatus.ACCEPTED.value());
	   return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
   }
   public ResponseEntity<ResponseStructure<String>> validate(long phone,String password){
	   User user=dao.validate(phone, password);
	   
	   if (user !=null) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setBody(user.getName()+" "+"Login Sucessfully");
		structure.setMessage(user.getName()+" "+"is Found");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FOUND);
		
	}
	 throw new InvalidCredentialsException();  
   }
}
