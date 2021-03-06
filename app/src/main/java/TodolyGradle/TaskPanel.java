package TodolyGradle;

import java.util.ArrayList;

public class TaskPanel {

    private ArrayList taskList = new ArrayList();

    public void setTaskList(ArrayList taskList) {
        this.taskList = taskList;
    }

    public ArrayList getTaskList() {
        return taskList;
    }

    public static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }
    public void createTask(){
        System.out.println("You are about to create a new Task");
        sleep(2000);
        System.out.println("Please enter ");

    }
    public void showList(){
        System.out.println("Here is a list of your tasks:");
        System.out.println("");
        sleep(200);
    }

    public void editTask(){

    }
    public void delTask(){
    }


}