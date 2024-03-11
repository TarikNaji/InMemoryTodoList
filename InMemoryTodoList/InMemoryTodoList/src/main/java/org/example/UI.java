package org.example;

import java.util.Scanner;

public class UI {
    private final Repo repo;
    private final Scanner scanner;

    public UI(Repo repo) {
        this.repo = repo;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Add ToDo");
            System.out.println("2. Show ToDos");
            System.out.println("3. Update ToDo");
            System.out.println("4. Delete ToDo");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    repo.add(task);
                    break;
                case 2:
                    System.out.println("ToDos:");
                    repo.getAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ToDo ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new task: ");
                    String newTask = scanner.nextLine();
                    Todo updateTodo = new Todo(updateId, newTask, false);
                    repo.update(updateTodo);
                    break;
                case 4:
                    System.out.print("Enter ToDo ID to delete: ");
                    int deleteId = scanner.nextInt();
                    repo.delete(deleteId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
