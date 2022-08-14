package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true){
            System.out.println("");

            todoListService.showTodoList();
            System.out.println("===== MENU =====");
            System.out.println("1. Add Todo List");
            System.out.println("2. Remove Todo List");
            System.out.println("x. Out");

            var input = InputUtil.input("Input Menu");
            if (input.equals("1")){
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("Miss number!!!");
            }
        }
    }

    public void addTodoList(){
        System.out.println("ADD TODO LIST");

        var todo = InputUtil.input("Todo (x Out)");
        if (!todo.equals("x")){
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("REMOVE TODO LIST");

        var value = InputUtil.input("Number (x Out)");
        if (!value.equals("x")){
            todoListService.removeTodoList(Integer.valueOf(value));
        }
    }

}
