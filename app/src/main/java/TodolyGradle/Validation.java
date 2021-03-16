package TodolyGradle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import java.util.Scanner;

public class Validation {


    public static int validateMainMenuInput(String input){
        int choice =-1;
        try {
            choice = Integer.parseInt(input);
            if (choice < 1 ||choice > 4) System.out.println(" Not a valid menu option, please select again");
            return choice;
        } catch (NumberFormatException nfe){
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return choice;
    }

    public static int validateShowTaskListMenuInput(String input){
        int choice = -1;
        try {
            choice = Integer.parseInt(input);
            if (choice < 1 ||choice > 3) System.out.println(" Not a valid menu option, please select again");
        } catch (NumberFormatException nfe){
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return choice;
    }
/*
what happens if the date is in wrong format. Will create a new class to call and request a new date.
 */
    public static Date validateDate(String input){
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    try{
        date = dateformat.parse(input);
    } catch (ParseException e){
            System.out.println("ParseException e");
        TaskPanel.getDateInput();
        }
    return date;
    }

//    public Date getValidDate(String input){
//        Date date = new Date();
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//        try{
//            date = dateformat.parse(input);
//        } catch (ParseException e){
//            System.out.println("ParseException e");
//
//        }
//        return date;
//    }

}
