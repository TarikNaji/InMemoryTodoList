package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repo {
    private final List<Todo> todos = new ArrayList<>();
    private int currentId = 1;

    public Todo add(String task) {
        Todo todo = new Todo(currentId++, task, false);
        todos.add(todo);
        return todo;
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

    public Optional<Todo> get(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    public void update(Todo todo) {
        get(todo.getId()).ifPresent(originalTodo -> {
            originalTodo.setTask(todo.getTask());
            originalTodo.setCompleted(todo.isCompleted());
        });
    }

    public void delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
