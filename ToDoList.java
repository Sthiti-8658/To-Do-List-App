package java_projects;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks =new ArrayList<>();
    private static Scanner scanner =new Scanner(System.in);
    public static void main(String[]args){
        while(true){
            System.out.println("\n===TO-DO LIST MENU ===");
            System.out.println("1. Add Task");
            System.out.println("2.View Tasks");
            System.out.println("3.Mark Task as Done");
            System.out.println("4.Remove Task");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");

            int choice =scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting To-Do List.Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice! please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter a new task:");
        String task =scanner.nextLine();
        tasks.add("[ ]"+task);
        System.out.println("Task added successfully!");
    }
    private static void viewTasks() {
        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n=== Your Tasks ===");
        for(int i=0;i<tasks.size();i++){
            System.out.println((i+1)+"."+tasks.get(i));
        }
    }
    private static void markTaskAsDone() {
        viewTasks();
        if(tasks.isEmpty())return;

        System.out.print("Enter the task number to mark as done: ");
        int index =scanner.nextInt()-1;
        scanner.nextLine();//consume newline

        if(index >=0 && index < tasks.size()){
            tasks.set(index,"[√]"+tasks.get(index).substring(4));
            System.out.println("Task marked as done!");
        }else{
            System.out.println("Invalid task number!");
        }
    }
    private static void removeTask() {
        viewTasks();
        if(tasks.isEmpty())return;

        System.out.print("Enter the task number to remove: ");
        int index = scanner.nextInt()-1;
        scanner.nextLine();//consume newline

        if(index >=0 && index < tasks.size()){
            tasks.remove(index);
            System.out.println("Task removed successfully!");
        }else{
            System.out.println("Invalid task number!");
        }
    }
}
