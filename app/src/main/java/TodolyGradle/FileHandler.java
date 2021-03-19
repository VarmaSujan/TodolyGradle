package TodolyGradle;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class is the main class of the Todoly Application.
 * It is the class that starts the application and calls the main menu.
 * @Sujan Varma
 */


public class FileHandler {      //Class resposnible for writing to file and reading from file
    private String path = "D:\\IntelliJWorkSpace\\TodolyGradle\\app\\src\\main\\resources\\"; //Absolute path included, could not solve the repository path error.

    //Data Stream2
    public void writeAsData1(ArrayList<Task> taskList) {           //method to write to file
       // if()
        try {
            FileWriter filewriter = new FileWriter(new File(path + "taskListFile.txt"));
            BufferedWriter bw = new BufferedWriter(filewriter);

            for (Task t : taskList) {
                bw.write(t.toString() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File not found!" + e.getMessage());
        }
    }

    public ArrayList<Task> readFromFile1() {            //method to read from file
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(path + "taskListFile.txt"));
            BufferedReader br = new BufferedReader(fileReader);

            String line = "";
            String [] data;
            while((line = br.readLine()) != null){
                data = line.split("\t\t ");

                Date date = Validation.validateDate(data[2]);
                // Tasks t = new Tasks(data[0], data[1], data[2], data[3]);

                Task t = new Task();
                t.Tasks(data[0], data[1], date, data[3]);
                taskList.add(t);
            }


        } catch (IOException e) {
            System.out.println("File not found!" + e.getMessage());

        }
        return taskList;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void writeAsData(ArrayList<Task> taskList) {           //method to write to file
        // if()
        try {
            File file = new File(path + "taskListFile.txt");
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileStream);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer.writeObject(taskList);

            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!" + e.getMessage());
        }
    }

    public ArrayList<Task> readFromFile() {           //method to write to file

        ArrayList<Task> taskList = new ArrayList<>();
        try
        {
            File file = new File(path + "taskListFile.txt");
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileStream);

           taskList = (ArrayList<Task>) reader.readObject();

            reader.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("the file has wired to data");
        }
        catch (IOException e) {
            System.out.println("File not found!" + e.getMessage());
        }
        return taskList;
    }
}