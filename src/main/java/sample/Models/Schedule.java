package sample.Models;

import java.util.Date;

public class Schedule {
    //attributes
        private String ScheduleName;
        private Date AddedDate;
        //picture or table info of the schedule??
   //Methods
        //getters
             public Date getAddedDate() {
                 return AddedDate;
             }
             public String getScheduleName(){
                 return ScheduleName;
             }
        //setters
            public void setAddedDate(Date addedDate) {
                AddedDate = addedDate;
            }

            public void setScheduleName(String scheduleName) {
                ScheduleName = scheduleName;
            }
}
