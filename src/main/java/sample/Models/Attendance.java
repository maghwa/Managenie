package sample.Models;

import java.util.Date;

public class Attendance {
    //attributes
        private String StudentName;

    public Attendance() {
        super();
    }

    private Date DateofAbsence;

    public Attendance(String studentN, Date dateofAbsence, Boolean absent, Boolean justificated) {
        StudentName = studentN;
        DateofAbsence = dateofAbsence;
        Absent = absent;
        Justificated = justificated;
    }

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
            public String getStudentName() {
                return StudentName;
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
            public void setStudentName(String studentName) {
                StudentName = studentName;
            }
}
