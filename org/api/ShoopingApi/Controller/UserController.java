package org.api.ShoopingApi.Controller;

import org.api.ShoopingApi.Service.UserService;
import org.api.ShoopingApi.dto.ResponseStructure;
import org.api.ShoopingApi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping("/users/verfi")
	public ResponseEntity<ResponseStructure<String>> validate(@RequestParam long phone, @RequestParam String password) {
		System.out.println("login");
		return service.validate(phone, password);
	}

}
