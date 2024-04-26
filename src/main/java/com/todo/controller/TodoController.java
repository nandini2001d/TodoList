package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.TodoList;
import com.todo.repository.TodoRepository;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	@PostMapping("/todolists")
	public ResponseEntity<TodoList> postdata(@RequestBody TodoList list){
		
		try {
		return ResponseEntity.ok().body(repository.save(list));
		} catch (Exception e) {
			
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/todolists/email/{email}")
	public ResponseEntity<?> getDataByemail(@PathVariable("email") String email){
		
		try {
		return ResponseEntity.ok().body(repository.findByEmail(email));
		} catch (Exception e) {
			
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/todolists/title/{title}")
	public ResponseEntity<?> getDataByTitle(@PathVariable("title") String title){
		
		try {
		return ResponseEntity.ok().body(repository.findByTitle(title));
		} catch (Exception e) {
			
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/todolists/status/{status}/{email}")
	public ResponseEntity<?> getDataByStatus(@PathVariable("status") String status,@PathVariable("email") String email){
		
		try {
		return ResponseEntity.ok().body(repository.findByStatusAndEmail(status,email));
		} catch (Exception e) {
			
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/todolists/status/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable("id")Long id ,
			@RequestParam("status")String status){
		
		try {
			
			TodoList t=repository.findById(id).get();
			
			   t.setId(id);
			   t.setStatus(status);
			   
		return ResponseEntity.ok().body(repository.save(t));
		
		} catch (Exception e) {
			
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
