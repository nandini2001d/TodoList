package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.TodoList;

@Repository
public interface TodoRepository extends JpaRepository<TodoList, Long> {

	List<TodoList> findByEmail(String email);

	
   List<TodoList> findByTitle(String title);


List<TodoList> findByStatus(String status);


List<TodoList> findByStatusAndEmail(String status, String email);

}
