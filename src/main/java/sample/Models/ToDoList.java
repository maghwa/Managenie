package sample.Models;

import java.util.Date;

public class ToDoList {
    //attributes


    Date CreatDate;
    Date DueDate;
    String List;

    //Methodes
    //contructers
        public ToDoList() {
            super();
        }

        public ToDoList(Date creatDate, Date dueDate, String list) {
            CreatDate = creatDate;
            DueDate = dueDate;
            List = list;
        }
    //Getters
        public Date getCreatDate() {
            return CreatDate;
        }

        public String getList() {
            return List;
        }

        public Date getDueDate() {
            return DueDate;
        }

    //Setters
        public void setCreatDate(Date creatDate) {
            CreatDate = creatDate;
        }
        public void setDueDate(Date dueDate) {
            DueDate = dueDate;
        }

        public void setList(String list) {
            List = list;
        }

}
