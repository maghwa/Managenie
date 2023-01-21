package sample.Class;
import java.util.ArrayList;
import java.util.Date;

public class Student {
    //attributes
        private int Matricule;
        private String FirstName;
        private String LastName;
        private Date Birthday;
        private Date StartingDate;
        private ArrayList<Attendance> AttendanceList;
        private  double PhoneNum;
        private String Email;
        private ArrayList<Course> CourseList;
    //methods
        //getters


            public String getLastName() {
                return LastName;
            }

            public String getFirstName() {
                return FirstName;
            }

            public String getEmail() {
                return Email;
            }

            public ArrayList<Attendance> getAttendanceList() {
                return AttendanceList;
            }

            public ArrayList<Course> getCourseList() {
                return CourseList;
            }

            public Date getBirthday() {
                return Birthday;
            }

            public Date getStartingDate() {
                return StartingDate;
            }

            public double getPhoneNum() {
                return PhoneNum;
            }

            public int getMatricule() {
                return Matricule;
            }
        //setters

            public void setPhoneNum(double phoneNum) {
                PhoneNum = phoneNum;
            }

            public void setLastName(String lastName) {
                LastName = lastName;
            }

            public void setFirstName(String firstName) {
                FirstName = firstName;
            }

            public void setEmail(String email) {
                Email = email;
            }

            public void setAttendanceList(ArrayList<Attendance> attendanceList) {
                AttendanceList = attendanceList;
            }

            public void setBirthday(Date birthday) {
                Birthday = birthday;
            }

            public void setCourseList(ArrayList<Course> courseList) {
                CourseList = courseList;
            }

            public void setMatricule(int matricule) {
                Matricule = matricule;
            }

            public void setStartingDate(Date startingDate) {
                StartingDate = startingDate;
            }

}
