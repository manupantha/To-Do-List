package com.mywebsite.todolist.controller;


import com.mywebsite.todolist.entity.Todo;
import com.mywebsite.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable long id) {
        return todoService.findById(id);
    }

    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo) {
       return todoService.saveOrUpdate(todo);


    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteTodo(@PathVariable long id) {
        todoService.delete(id);
        return  ResponseEntity.ok("List deleted successfully");
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
        todo.setId(id);
        todoService.saveOrUpdate(todo);
        return  ResponseEntity.ok("List updated successfully");
    }
}
