package LinkedList_Example;

public class ToDoNode {
    String work;
    ToDoNode next;

    public ToDoNode(String s){
        work = s;
        next = null;
    }

    public static void main(String[] args) {
        ToDoNode toDoList = new ToDoNode("homework");
        toDoList.next = new ToDoNode("training");
        toDoList.next.next = new ToDoNode("cleaning");
        toDoList.next.next.next = new ToDoNode("service");

        System.out.println(">>> To-Do List ");
        ToDoNode position = toDoList;

        while(position!=null){
            System.out.println(position.work);
            position = position.next;
        }

        ToDoNode newWork = new ToDoNode("date");
        newWork.next = toDoList;
        toDoList = newWork;

        System.out.println(">>> New To-Do List");
        position = toDoList;

        while(position!=null){
            System.out.println(position.work);
            position = position.next;
        }
    }
}
