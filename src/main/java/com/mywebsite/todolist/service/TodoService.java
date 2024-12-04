package com.mywebsite.todolist.service;

import com.mywebsite.todolist.entity.Todo;
import com.mywebsite.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }



    public Todo saveOrUpdate(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(Long id){
        return todoRepository.findById(id).orElse(null);
    }
    public void delete(Long id){
        todoRepository.deleteById(id);
    }
}
