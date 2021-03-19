package TodolyGradle;
import java.io.Serializable;
import java.util.Date;

/**
 * This class is the main class of the Todoly Application.
 * It is the class that starts the application and calls the main menu.
 * @Sujan Varma
 */


public class Task implements Serializable, Comparable<Task> {
        /**
         *
         */
        private String title;
        private String status;
        private Date date;
        private String project;

        public void Tasks(String title, String project, Date date, String status){
                this.title = title;
                this.project = project;
                this.date = date;
                this.status = status;
        }

        public String getTitle() {
                return this.title;
        }

        public String getProject() {
                return project;
        }

        public String getStatus() {
                return status;
        }

        public Date getTaskDate() {
                return date;
        }

        @Override
        public String toString( ){
                return "" + title + " \t\t" + project + " \t\t" + date + " \t\t" + status;
        }

        @Override
        public int compareTo(Task t) {
                return getTaskDate().compareTo(t.getTaskDate());
        }

//        @Override
//        public int compare(Task t) {
//               return getProject().compareTo(t.getProject());
//        }


}
