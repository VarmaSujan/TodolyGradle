package TodolyGradle;

import java.util.Scanner;

public class SelectionMenu {

    public Scanner scan = new Scanner(System.in);
    private boolean quit = false;
    TaskPanel tasked = new TaskPanel();
    int choice;

    private static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }


    public void displayMenu() {
        while (!quit) {
            System.out.println(">> MAIN MENU:");
            System.out.println(">> (1) Show TasK List (by date or project)");
            System.out.println(">> (2) Add New Task");
            System.out.println(">> (3) Edit Task (mark done, update, delete");
            System.out.println(">> (4) Exit");
            System.out.println("Please choose an option by number: ");
      //      sleep(2000);
            choice = scan.nextInt();
            scan.nextLine();

            //while(quit!=
//            if (choice > 0 && choice < 5) {
//                switch (choice) {
//                    case 1:  // Displays all tasks in ArrayList
//                        tasked.showList();
//                        break;
//
//                    case 2:  //creates a new task
//                        tasked.createTask();
//                        // switch ()
//                        break;
//
//                    case 3:  //Display
//                        //   simpleTodoList.displayToDoList();
//                        break;
//
//                    case 4:
//                        //   saveExitTask();
//                        System.out.println("Goodbye!");
//                        quit = true;
//                        break;
//                }
//            }
//            else System.out.println("Invalid entry, please try again.");
        }
        scan.close();
    }
}