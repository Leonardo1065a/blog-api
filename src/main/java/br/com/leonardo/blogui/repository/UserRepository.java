package br.com.leonardo.blogui.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leonardo.blogui.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
