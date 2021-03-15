package TodolyGradle;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskPanel {

    public ArrayList<Tasks> taskList = new ArrayList<>();
    private Scanner scannerTP = new Scanner(System.in);

    private static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }

    public void createTask(){
        System.out.println("You are about to create a new Task");
        sleep(1000);
        System.out.print("Please enter a task title: ");
        String title = scannerTP.nextLine();
        System.out.print("Please enter a project title: ");
        String project = scannerTP.nextLine();
        System.out.print("Please enter a date (YYYY-MM-DD): ");
        String date = scannerTP.nextLine();
        System.out.print("Please enter a status (D=Done, I=Incomplete): ");
        String status = scannerTP.nextLine();
        Tasks taskObj = new Tasks();
        taskList.add(taskObj);
    }

  public void displayTaskList(){

    }
//    public void editTask(){
//
//    }
//    public void delTask(){
//    }


}