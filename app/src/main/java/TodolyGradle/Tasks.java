package TodolyGradle;


import java.time.LocalDate;

public class Tasks {

        private String title;
        private String status;
        private String date;
        private String project;

        public void Tasks(String title, String project, String date, String status){
                this.title = title;
                this.project = project;
                this.date = date;
                this.status = status;
        }
}
