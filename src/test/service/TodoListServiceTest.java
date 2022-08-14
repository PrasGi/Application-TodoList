package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Prasetyo");
        todoListRepository.data[1] = new TodoList("Putra");
        todoListRepository.data[2] = new TodoList("Pratama");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Prasetyo");
        todoListService.addTodoList("Putra");
        todoListService.addTodoList("Pratama");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Prasetyo");
        todoListService.addTodoList("Putra");
        todoListService.addTodoList("Pratama");

        todoListService.showTodoList();

        todoListService.removeTodoList(1);

        todoListService.showTodoList();

        todoListService.removeTodoList(6);

        todoListService.showTodoList();
    }

}
