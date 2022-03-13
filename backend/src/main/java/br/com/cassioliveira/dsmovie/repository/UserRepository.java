package br.com.cassioliveira.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cassioliveira.dsmovie.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
