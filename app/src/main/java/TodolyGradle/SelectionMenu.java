package TodolyGradle;

import java.util.Scanner;

/**
 * This class is the class of the Todoly Application that displays the various menus in the application.
 * It is the class that starts the application and calls the main menu.
 * @Sujan Varma
 */

public class SelectionMenu {

    /**
     *
     */
    private Scanner scan = new Scanner(System.in);
    private boolean quit = false;
    TaskPanel tasked = new TaskPanel();
    FileHandler file = new FileHandler();
    int choice;



    private static void sleep (int time){
        try {
            Thread.sleep(time);
        } catch (Exception e){}
    }

    public void mainMenu() {        // Displays the main menu of the application
        /** This method displays the main menu that the user can interact with.
         * The method prints out options to the screen and ask the user to select an option by number.
         * A method will be invoked depending on the user input, after the input has been validated.
         * If an invalid input has been entered, it will prompt for a valid input.
         * The application will continue to run until the user inputs the 'Save & Exit' option.
         */
        int choice;
        while (!quit) {
            System.out.println(">> MAIN MENU:");
            System.out.println(">> (1) Show TasK List (by date or project)\n>> (2) Add New Task\n>> (3) Edit Task (mark done, update, delete)\n>> (4) Save & Exit\nPlease choose an option by number: ");
            choice = Validation.validateMenuInput(scan.nextLine());

            switch (choice) {
                case 1:  // Displays the tasks list SUBMENU
                    file.readFromFile();
                    showTaskListMenu();
                    return;

                case 2:  //creates a new task

                    tasked.createTask();
                    mainMenu();
                    return;

                case 3:  //edit saved tasks
                    tasked.editTask();
                    mainMenu();
                    return;

                case 4:  //saveExitTask();

                     //Write to file
                    file.writeAsData(tasked.taskList);
                    System.out.println("Goodbye!");
                    quit = true;    //Exits the program
                    return;

            }
        }
    }

    /**
     *
     */
    public void showTaskListMenu() {

        System.out.println("Here is a list of your tasks: ");
        tasked.displayTaskList();           // Display task list in the order that the tasks were entered.
        while (!quit) {
            System.out.println(">> SUBMENU:\n>> (1) Sort tasks by date \n>> (2) Sort tasks by project\n>> (3) Return to main menu\n>> (4) Save & Exit\nPlease choose an option by number: ");
            int choice = Validation.validateMenuInput(scan.nextLine());

            switch (choice) {
                case 1:  // sorts list by date
                    tasked.displayByDate();
                    mainMenu();
                    break;

                case 2:  //sort list by project
                    tasked.creatTestingtasks();
                    tasked.displayByProject();
                    mainMenu();
                    break;

                case 3:  //returns to main menu
                    mainMenu();
                    break;

                case 4:  //saveExitTask();

                    //Write to file
                    file.writeAsData(tasked.taskList);
                    System.out.println("Goodbye!");
                    quit = true;    //Exits the program
                    return;
            }
        }
    }
}