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

    /* This method displays the main menu that the user can interact with.
     * The method prints out options to the screen and ask the user to select an option by number.
     * A method will be invoked depending on the user input, after the input has been validated.
     * If an invalid input has been entered, it will prompt for a valid input.
     * The application will continue to run until the user has inputed the 'Exit' option.
     */

    // Displays the main menu of the application
    public void mainMenu() {

        while (!quit) {
            System.out.println(">> MAIN MENU:");
            System.out.println(">> (1) Show TasK List (by date or project)");
            System.out.println(">> (2) Add New Task");
            System.out.println(">> (3) Edit Task (mark done, update, delete");
            System.out.println(">> (4) Exit");
            System.out.println("Please choose an option by number: ");
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice < 1 ||choice > 4) System.out.println(" Not a valid menu option, please select again");
            } catch (NumberFormatException nfe){
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
            switch (choice) {
                case 1:  // Displays the tasks list SUBMENU
                    showTaskListMenu();
                    return;

                case 2:  //creates a new task
                    tasked.createTask();
                    // switch ()
                    return;

                case 3:  //edit saved tasks
                    return;

                case 4:
                    //   saveExitTask();
                    System.out.println("Goodbye!");
                    quit = true;
                    return;
            }
        }
    }

    public void showTaskListMenu(){
        System.out.println("Here is a list of your tasks: ");
        //display task as they were entered
        System.out.println(">> SUBMENU:\n>> (1) Sort tasks by date \n>> (2) Sort tasks by project\n>> (3) Return to main menu\nPlease choose an option by number: ");
        try {
            choice = Integer.parseInt(scan.nextLine());
            if (choice < 1 ||choice > 3) System.out.println(" Not a valid menu option, please select again");
        } catch (NumberFormatException nfe){
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        switch (choice) {
            case 1:  // sorts list by date

                break;

            case 2:  //sort list by project

                break;

            case 3:  //returns to main menu
                mainMenu();
                break;
        }
    }
}