package com.mywebsite.todolist.repository;

import com.mywebsite.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
