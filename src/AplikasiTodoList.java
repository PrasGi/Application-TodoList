import java.util.Scanner;
public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodoList();

    }

    /**
     * Show Todo List
     */
    public static void showTodoList(){
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){

            if (model[i] != null){
                System.out.println((i + 1)+". "+model[i]);
            }

        }
    }

    public static void testShowTodoList(){
        model[0] = "Prasetyo";
        model[1] = "Putra";
        model[2] = "Pratama";
        showTodoList();
    }

    /**
     * Add Todo List
     */
    public static void addTodList(String todo){

        var ifFull = true;
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                ifFull = false;
            }
        }

        if (ifFull){
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (var i = 0; i < 15; i++){
            addTodList("Add number : "+i);
        }
        showTodoList();
    }

    /**
     * Remove Todo List
     */
    public static boolean removeTodoList(Integer num){
        var value = true;
        if (num - 1 >= model.length){
            value = false;
        } else if (model[num - 1] == null){
            value = false;
        } else {
            for (var i = num - 1; i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }

            }
            value = true;
        }
        return value;
    }

    public static void testRemoveTodoList(){
        addTodList("Satu");
        addTodList("Due");
        addTodList("Tiga");

        var value = removeTodoList(2);
        System.out.println(value);

        showTodoList();
    }

    public static String input(String warning){
        System.out.print(warning+" : ");
        String data = input.nextLine();

        return data;
    }

    /**
     * View App
     */

    public static void viewShowTodoList(){
        while (true){
            System.out.println("");

            showTodoList();
            System.out.println("===== MENU =====");
            System.out.println("1. Add Todo List");
            System.out.println("2. Remove Todo List");
            System.out.println("x. Out");

            var input = input("Input Menu");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            }else {
                System.out.println("Miss number!!!");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodList("Satu");
        addTodList("Dua");
        addTodList("Tiga");
        addTodList("Empat");
        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("ADD TODO LIST");

        var todo = input("Todo (x Out)");
        if (!todo.equals("x")){
            addTodList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodList("Satu");
        addTodList("Dua");
        addTodList("Tiga");
        addTodList("Empat");

        viewAddTodoList();

        viewShowTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("REMOVE TODO LIST");

        var value = input("Number (x Out)");
        if (!value.equals("x")){
            var succes = removeTodoList(Integer.valueOf(value));
            if (succes){
                System.out.println("Remove Succes");
            } else {
                System.out.println("Remove unsucces wrong number");
            }
        }
    }

    public static void testViewRemoveTodoList(){

        addTodList("Satu");
        addTodList("Dua");
        addTodList("Tiga");
        addTodList("Empat");
        showTodoList();

        viewRemoveTodoList();

        viewShowTodoList();
    }

}
