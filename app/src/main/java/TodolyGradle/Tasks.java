package TodolyGradle;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Tasks {

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


}
