package TodolyGradle;

import java.util.ArrayList;
import java.util.*;

/**
 *
 *
 * @Sujan Varma
 */


public class TaskPanel {
    public ArrayList<Task> taskList = new ArrayList<>();


//    Thought it would be nice to have a short delay between prompts but decided to keep the application simple.
//    private static void sleep (int time){
//        try {
//            Thread.sleep(time);
//        } catch (Exception e){}

    //    }
    public TaskPanel() {
        FileHandler file = new FileHandler();
        taskList = file.readFromFile();
    }

    public void createTask() {   //This method creates a task and add it to the task list
        Scanner scanner = new Scanner(System.in);
        Date date;
        System.out.println("You are about to create a new Task");
//        sleep(1000);
        System.out.print("Please enter a unique task title: ");
        String title = scanner.nextLine();
        while (!checkIfTitleIsUnique(title)) {
            System.out.println("Warning tile already exists!!!! Please enter a unique title.");
            System.out.print("Please enter a task title: ");
            title = scanner.nextLine();
        }
        System.out.print("Please enter a project title: ");
        String project = scanner.nextLine();
        do {                                //Will prompt the user for a valid date until a valid date is entered.
            date = getDateInput();
        } while (date == null);
        System.out.print("Please enter a status (Ongoing/Complete): ");
        String status = scanner.nextLine();
        Task taskObj = new Task();
        taskObj.Tasks(title, project, date, status);
        taskList.add(taskObj);
        System.out.println("Success: New task created!");
        scanner.close();
    }

    private boolean checkIfTitleIsUnique(String title) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getTitle().equals(title))
                return false;
        }
        return true;
    }


    public static Date getDateInput() {  //prompts for date input and invokes validation method
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a date (YYYY-MM-DD): ");
        Date date = Validation.validateDate(scanner.nextLine());
        scanner.close();
        return date;
    }

    public void displayTaskList() {

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Task ID:" + i + " \t\t" + taskList.get(i).toString());
        }
    }

    public void displayByDate() {        //Displays the task list in order of the deadline date.
        Collections.sort(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(taskList.get(i).toString());
            ;

        }
    }

    public void displayByProject() {
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getProject().compareTo(o2.getProject());
            }
        });
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(taskList.get(i).toString());
            ;

        }
    }

//    public void displayByStatus() {
//        Collections.sort(taskList, new Comparator<Task>() {
//            @Override
//            public int compare(Task o1, Task o2) {
//                return o1.getStatus().compareTo(o2.getStatus());
//            }
//        });
//        for (int i = 0; i < taskList.size(); i++) {
//            System.out.println(taskList.get(i).toString());;
//
//        }
//    }


    public void creatTestingtasks() {
        Task taskObj = new Task();
        Task taskObj1 = new Task();
        Task taskObj2 = new Task();
        taskObj.Tasks("Atitle1", "Aproject1", Validation.validateDate("2020-11-05"), "Ongoing");
        taskList.add(taskObj);
        taskObj1.Tasks("Btitle23", "project23", Validation.validateDate("2020-12-05"), "Incomplete");
        taskList.add(taskObj1);
        taskObj2.Tasks("Ctitle3", "project3", Validation.validateDate("2020-07-05"), "Ongoing");
        taskList.add(taskObj2);
    }


    public void editTask() {
        displayTaskList();
        System.out.println("Please enter the title of the task you would like to edit");
        Scanner scanner = new Scanner(System.in);
        String editTitle = scanner.nextLine();
        Task task = getTaskByTitle(editTitle);
        if (task == null) {
            System.out.println("No task found");
            return;
        }
        System.out.println("Task found");
        System.out.println(">> (1) Update task\n>> (2) Mark done\n>> (3) Delete Task\n>> (4) Save & Exit\nPlease choose an option by number: ");
        int choice = Validation.validateMenuInput(scanner.nextLine());
        while (true)
            switch (choice) {
                case 1:  // sorts list by date
//                updateTask;
                    return;

                case 2:  //sort list by project
//                markDone;
//                mainMenu();
                    return;

                case 3:  //returns to main menu
//                deleteTask;
//                mainMenu();
                    return;

                case 4:  //saveExitTask();

                    //Write to file
                    //  file.writeAsData(tasked.taskList);
                    System.out.println("Goodbye!");
                    //Exits the program
                    scanner.close();
                    return;
            }

    }

    private Task getTaskByTitle(String editTitle) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTitle().equals(editTitle)) {
                return taskList.get(i);
            }
        }
        return null;

    }
    public void delTask () {
    }

}