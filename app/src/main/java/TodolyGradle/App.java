/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TodolyGradle;
/**
 * This class is the main class of the Todoly Application.
 * It is the class that starts the application and calls the main menu.
 * @Sujan Varma
 */


public class App {

    public String getGreeting() {
        return ">> Welcome to Todoly!";
    }

    public static void main(String[] args) {

        System.out.println(new App().getGreeting());
        SelectionMenu select = new SelectionMenu();
        // calls the mainMenu
        select.mainMenu();


    }

}
