package TodolyGradle;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskPanel {

    public ArrayList<Tasks> taskList = new ArrayList<>();
    private Scanner scannerTP = new Scanner(System.in);

    private static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }

    public void createTask(){
        Date date;
        System.out.println("You are about to create a new Task");
        sleep(1000);
        System.out.print("Please enter a task title: ");
        String title = scannerTP.nextLine();
        System.out.print("Please enter a project title: ");
        String project = scannerTP.nextLine();
        date = getDateInput();
        System.out.print("Please enter a status (Ongoing/Complete): ");
        String status = scannerTP.nextLine();
        Tasks taskObj = new Tasks();
        taskObj.Tasks(title, project, date, status);
        taskList.add(taskObj);
        System.out.println("Success: New task created!");
    }


    public static Date getDateInput(){
        System.out.print("Please enter a date (YYYY-MM-DD): ");
        Scanner scan = new Scanner(System.in);
        Date date = Validation.validateDate(scan.nextLine());
        return date;
    }

//    public void displayTaskList(){
//        for(int i =0; i < taskList.size(); i++){
//            toString(taskList.get(i));
//        }
//    }
//    public void editTask(){
//
//    }
//    public void delTask(){
//    }


}