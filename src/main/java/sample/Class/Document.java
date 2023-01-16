package sample.Class;



import java.util.ArrayList;

public class Document extends Course {
    //attributes
        private int idDocuments;
        private int ClassSize;
        private ArrayList<Student> StudentList;
    //methodes

        //getters
            public int getClassSize() {
                return ClassSize;
            }

            public ArrayList<Student> getStudentList() {
                return StudentList;
            }

            public int getIdDocuments() {
                return idDocuments;
            }

        //setters
            public void setStudentList(ArrayList<Student> studentList) {
                StudentList = studentList;
            }

            public void setIdDocuments(int idDocuments) {
                this.idDocuments = idDocuments;
            }

            public void setClassSize(int classSize) {
                ClassSize = classSize;
            }
}
