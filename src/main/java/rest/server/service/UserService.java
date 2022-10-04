package rest.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.server.model.User;
import rest.server.repository.UserRepository;
@Service
public class UserService {
	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.repository = userRepository;
	}
	public void addUser(User user) {
		repository.save(user);
	}
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	public User getOneUser(Integer id) {
		return repository.getReferenceById(id);
	}
	public User updateUser(int id, User user) {
		User userFromDB = repository.getReferenceById(id);
		
		userFromDB.setName(user.getName());
		userFromDB.setSurname(user.getSurname());
		userFromDB.setAge(user.getAge());
		
		repository.save(userFromDB);
		
		return userFromDB;
	}
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}
}
