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
    FileHandler file = new FileHandler();


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
        System.out.print("Please enter a project date: ");
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
        while (true) {
            System.out.println(">> (1) Update task\n>> (2) Mark done\n>> (3) Delete Task\n>> (4) Return to previous menu\nPlease choose an option by number: ");
            int choice = Validation.validateMenuInput(scanner.nextLine());
            switch (choice) {
                case 1:  // sorts list by date
                    upDateTask(editTitle);
                    break;

                case 2:  //sort list by project
                    markDone(editTitle);
                    break;

                case 3:  //returns to main menu
                    deleteTask(editTitle);
                    break;

                case 4:  //saveExitTask();
                    return;
            }
        }

    }
    public void upDateTask (String editTitle) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> (1) Task Tile\n>> (2) Project Title\n>> (3) Date \n>> (4) Return to previous menu\nPlease choose an task attribute to change: ");
        int choice = Validation.validateMenuInput(scanner.nextLine());

        switch(choice){
            case 1:  // sorts list by date
                System.out.println("Specify new Title");
                String newTitle = scanner.nextLine();
                while (!checkIfTitleIsUnique(newTitle)) {
                    System.out.println("Warning tile already exists!!!! Please enter a unique title.");
                    System.out.print("Please enter a task title: ");
                    newTitle = scanner.nextLine();
                }
                upDateTaskValue(editTitle, "Title", newTitle);
                break;

            case 2:  //sort list by project
                System.out.println("Specify new Project Title");
                String newProject = scanner.nextLine();
                upDateTaskValue(editTitle, "Project", newProject);
                break;

            case 3:  //returns to main menu
                System.out.println("Specify new Date");
                Date date = null;
                do {                                //Will prompt the user for a valid date until a valid date is entered.
                    date = getDateInput();
                } while (date == null);
                upDateTaskDate(editTitle, date);
                break;

            case 4:  //saveExitTask();

                //Write to file
                //  file.writeAsData(tasked.taskList);
                System.out.println(
                        "Goodbye!");
                //Exits the program
                return;
        }
    }

    private void upDateTaskDate(String editTitle, Date date) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTitle().equals(editTitle)) {
                taskList.get(i).setDate(date);
                return;
            }
        }
    }

    private void upDateTaskValue(String editTitle, String valueType, String updateValue) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTitle().equals(editTitle)){
                if (valueType.equals("Title")){
                    taskList.get(i).setTitle(updateValue);
                }
                else if (valueType.equals("Project")){
                    taskList.get(i).setProject(updateValue);
                }
                return;
        }

    }

}



    private void deleteTask(String editTitle) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTitle().equals(editTitle)) {

                taskList.remove(i);
            }
        }
    }

    private void markDone(String editTitle) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTitle().equals(editTitle)) {

                taskList.get(i).setStatus("Complete");
                return;
            }
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

//    private void refreshFileInfo(){
//
//    }




}