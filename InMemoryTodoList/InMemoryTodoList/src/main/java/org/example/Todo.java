package org.example;

public class Todo {
    private int id;
    private String task;
    private boolean completed;

    public Todo(int id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return  String.format("ID: %d\nTask: %s\nCompleted?: %b",id,task,completed);
    }
}
