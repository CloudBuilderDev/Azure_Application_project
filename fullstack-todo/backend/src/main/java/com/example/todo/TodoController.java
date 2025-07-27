package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") // React에서 접근 허용
public class TodoController {

    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    @GetMapping
    public Collection<Todo> getTodos() {
        return todos.values();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        Long id = counter.getAndIncrement();
        todo.setId(id);
        todos.put(id, todo);
        return todo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updated) {
        Todo existing = todos.get(id);
        if (existing != null) {
            existing.setTask(updated.getTask());
            existing.setCompleted(updated.isCompleted());
        }
        return existing;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todos.remove(id);
    }
}
