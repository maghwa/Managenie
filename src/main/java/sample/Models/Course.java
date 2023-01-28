package sample.Models;

import java.util.ArrayList;

public class Course {
    //Course Attributs
        private String Description;
        private String Duration;
        private String Name;
        private String NofSession;
        private String Time_Session;
        private String NofStudent;
        private String NofClasses;

    public Course() {
        super();
    }

    private ArrayList<Document> DocumentList;
        private ArrayList<Classe> ClassList;
    //Course Methods

    public Course(String name ,String time_Session,String duration, String nofSession, String description) {
        Description = description;
        Duration = duration;
        Name = name;
        NofSession = nofSession;
        Time_Session = time_Session;

    }
        //getters
            public ArrayList<Classe> getClassList() {
                return ClassList;
            }

            public ArrayList<Document> getDocumentList() {
                return DocumentList;
            }

            public String getDuration() {
                return Duration;
            }

            public String getNofClasses() {
                return NofClasses;
            }

            public String getNofSession() {
                return NofSession;
            }

            public String getNofStudent() {
                return NofStudent;
            }

            public String getTime_Session() {
                return Time_Session;
            }

            public String getDescription() {
                return Description;
            }

            public String getName() {
                return Name;
            }
        //setters

            public void setClassList(ArrayList<Classe> classList) {
                ClassList = classList;
            }

            public void setDescription(String description) {
                Description = description;
            }

            public void setDocumentList(ArrayList<Document> documentList) {
                DocumentList = documentList;
            }

            public void setDuration(String duration) {
                Duration = duration;
            }

            public void setName(String name) {
                Name = name;
            }

            public void setNofClasses(String nofClasses) {
                NofClasses = nofClasses;
            }

            public void setNofSession(String nofSession) {
                NofSession = nofSession;
            }

            public void setNofStudent(String nofStudent) {
                NofStudent = nofStudent;
            }

            public void setTime_Session(String time_Session) {
                Time_Session = time_Session;
            }
}
