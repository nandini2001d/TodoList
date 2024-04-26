package com.todo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Todo_List")
public class TodoList {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	
	private String description;
	
	private String email;
	
	private String status;
	
}
