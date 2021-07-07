package br.com.leonardo.blogui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardo.blogui.model.User;
import br.com.leonardo.blogui.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@PreAuthorize("hasRole('ADM')")
	@GetMapping
	public List<User> listar() {
		return repository.findAll(); 
	}
	
	@PreAuthorize("hasRole('ADM')")
	@GetMapping("{id}")
	public User getById(@PathVariable("id") Long id) {
		return repository.findById(id).get(); 
	}
	
	@PostMapping
	public User add(@RequestBody @Validated User form) {
		String senhaCriptografado = new BCryptPasswordEncoder().encode(form.getPassword());
		form.setPassword(senhaCriptografado);
		return repository.save(form); 
	}
}
