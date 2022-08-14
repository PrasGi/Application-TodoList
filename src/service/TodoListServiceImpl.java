package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){

            if (model[i] != null){
                System.out.println((i + 1)+". "+model[i].getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public void removeTodoList(Integer num) {
        boolean succes = todoListRepository.remove(num);
        if (succes){
            System.out.println("Succes Remove");
        }else{
            System.out.println("Unsecces Remove");
        }
    }
}
