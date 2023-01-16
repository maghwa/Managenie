package sample.Class;

import java.util.Date;

public class Attendance {
    //attributes
        private int StudentMatricule;
        private Date DateofAbsence;
        private  Boolean Absent;
        private Boolean Justificated;

    //methods
        //getters
            public Boolean getAbsent() {
                return Absent;
            }
            public Boolean getJustificated() {
                return Justificated;
            }
            public Date getDateofAbsence() {
                return DateofAbsence;
            }
            public int getStudentMatricule() {
                return StudentMatricule;
            }
        //setters
            public void setAbsent(Boolean absent) {
                Absent = absent;
            }
            public void setDateofAbsence(Date dateofAbsence) {
                DateofAbsence = dateofAbsence;
            }
            public void setJustificated(Boolean justificated) {
                Justificated = justificated;
            }
            public void setStudentMatricule(int studentMatricule) {
                StudentMatricule = studentMatricule;
            }
}
