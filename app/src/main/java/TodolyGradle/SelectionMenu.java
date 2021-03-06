package TodolyGradle;

import java.util.Scanner;

public class SelectionMenu {

    public Scanner scan = new Scanner(System.in);
    private boolean quit = false;
    TaskPanel tasked = new TaskPanel();
    int choice;


    public void displayMenu() {
        while (!quit) {
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show TasK List (by date or project)");
            System.out.println(">> (2) Add New Task");
            System.out.println(">> (3) Edit Task (mark done, update, delete");
            System.out.println(">> (4) Exit");
            System.out.print("Please choose an option by number: ");
            choice = scan.nextInt();


            if (choice > 0 && choice < 5) {
                switch (choice) {
                    case 1:  // Displays the Task List
                        tasked.showList();
                        break;

                    case 2:  //creates a new task
                        tasked.createTask();
                        // switch ()
                        break;

                    case 3:  //Display all tasks in ArrayList
                        //   simpleTodoList.displayToDoList();
                        break;

                    case 4:  //remove any task in ArrayList
                        //   removeAnyTask();
                        break;

                    case 5:
                        //   saveExitTask();
                        System.out.println("Goodbye!");
                        quit = true;
                        break;
                }
            }
            else System.out.println("Invalid entry, please try again.");
        }
        scan.close();
    }
}