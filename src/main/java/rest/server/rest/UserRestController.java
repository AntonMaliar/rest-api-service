package rest.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.server.model.User;
import rest.server.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	@GetMapping("/{id}")
	public User getOneUser(@PathVariable("id")int id) {
		return userService.getOneUser(id);
	}
	@PostMapping
	public List<User> saveUser(@RequestBody User user) {
		userService.addUser(user);
		return userService.getAllUsers();
	}
	@PutMapping("/{id}")
	public List<User> updateUser(@PathVariable int id, @RequestBody User user) {
		userService.updateUser(id, user);
		return userService.getAllUsers();
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id")int id) {
		userService.deleteUser(id);
	}
	
}
