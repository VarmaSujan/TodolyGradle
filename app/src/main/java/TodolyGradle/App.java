/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TodolyGradle;

import java.util.Scanner;

public class App {

    public String getGreeting() {
        return ">> Welcome to Todoly!";
    }


    public static void main(String[] args) {

        System.out.println(new App().getGreeting());
        SelectionMenu select = new SelectionMenu();
        select.displayMenu();

    }
}
