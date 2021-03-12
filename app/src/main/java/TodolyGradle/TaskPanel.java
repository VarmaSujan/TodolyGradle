package TodolyGradle;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskPanel {

    private ArrayList<String> taskObj = new ArrayList<>();
    private Scanner scannerTP = new Scanner(System.in);
//    SelectionMenu selectTP = new SelectionMenu();


//    public void setTaskList(ArrayList taskList) {
//        this.taskList = taskList;
//    }
//
//    public ArrayList getTaskList() {
//        return taskList;
//    }

    private static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }
    public void createTask(){
        System.out.println("You are about to create a new Task");
        sleep(1000);
        System.out.print("Please enter a task title: ");
        taskObj.add(scannerTP.nextLine());
        System.out.print("Please enter a project title: ");
        //taskObj.add(scannerTP.nextLine());
        System.out.print("Please enter a date (YYYY-MM-DD): ");
        //taskObj.add(scannerTP.nextLine());
        System.out.print("Please enter a status (D=Done, I=Incomplete ");
        //taskObj.add(scannerTP.nextLine());





    }
//    public void showList(){
//        System.out.println("Here is a list of your tasks");
//        //print task as they were entered
//        System.out.println(">> SUBMENU:");
//        System.out.println(">> (1) Sort tasks by date \n  >> (2) Sort tasks by project");
//        System.out.println(">> (3) Return to main menu");
//        System.out.println("Please choose an option by number: ");
//        sleep(200);
//
//        if (scannerTP.nextInt() > 0 && scannerTP.nextInt() < 3) {
//            switch (scannerTP.nextInt()) {
//                case 1:  // sorts list by date
//
//                    break;
//
//                case 2:  //sort list by project
//
//                    break;
//
//                case 3:  //return to main menu
//                    selectTP.displayMenu();
//                    break;
//            }
//        }
//    }
//
//    public void editTask(){
//
//    }
//    public void delTask(){
//    }


}