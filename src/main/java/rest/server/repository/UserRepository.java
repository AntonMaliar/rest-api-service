package rest.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
