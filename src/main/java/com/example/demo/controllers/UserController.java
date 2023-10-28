package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	//pesquisar sobre injeção de dependência. É um método que depende do serviço de outro para poder continuar. É um conceito de POO.
	//Agora precisa sinalizar pro SpringBoot que esse método é uma injeção de método, para isso, usa o @Autowired
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll() {
		//acesso ao UserRepository
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")//sinalizando para o Spring o que o GetMapping vai receber
	//método para retornar somente 1 usuário
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	
	@GetMapping
	//método que vêm do cliente para o servidor
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}
	
}
