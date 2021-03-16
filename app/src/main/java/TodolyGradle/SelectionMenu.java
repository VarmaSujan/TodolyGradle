package TodolyGradle;

import java.util.Scanner;

public class SelectionMenu {

    private Scanner scan = new Scanner(System.in);
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
        int choice;
        while (!quit) {
            System.out.println(">> MAIN MENU:");
            System.out.println(">> (1) Show TasK List (by date or project)\n>> (2) Add New Task\n>> (3) Edit Task (mark done, update, delete\n>> (4) Exit\nPlease choose an option by number: ");
            choice = Validation.validateMainMenuInput(scan.nextLine());

            switch (choice) {
                case 1:  // Displays the tasks list SUBMENU
                    showTaskListMenu();
                    return;

                case 2:  //creates a new task
                    tasked.createTask();
                    mainMenu();
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
        //tasked.displayTaskList();
       //for (int i=0; i < tasked.getTaskList.
        System.out.println(">> SUBMENU:\n>> (1) Sort tasks by date \n>> (2) Sort tasks by project\n>> (3) Return to main menu\nPlease choose an option by number: ");
        int choice = Validation.validateShowTaskListMenuInput(scan.nextLine());

        switch (choice) {
            case 1:  // sorts list by date
                        System.out.println("test");
                break;

            case 2:  //sort list by project

                break;

            case 3:  //returns to main menu
                mainMenu();
                break;
        }
    }
}