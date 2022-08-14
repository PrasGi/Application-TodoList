package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        var isFull = true;
        for (var i = 0; i < data.length; i++){
            if (data[i] == null){
                isFull = false;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        if (isFull()){
            var temp = data;
            data = new TodoList[data.length * 2];

            for (var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        resizeIfFull();

        for (var i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer num) {
        var value = true;
        if (num - 1 >= data.length){
            value = false;
        } else if (data[num - 1] == null){
            value = false;
        } else {
            for (var i = num - 1; i < data.length; i++){
                if (i == (data.length - 1)){
                    data[i] = null;
                }else{
                    data[i] = data[i+1];
                }
            }
            value = true;
        }
        return value;
    }
}
