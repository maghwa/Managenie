package sample.Models;

import java.util.ArrayList;

public class Course {
    //Course Attributs
        private String Description;
        private int Duration;
        private String Name;
        private int NofSession;
        private int Time_Session;
        private int NofStudent;
        private int NofClasses;
        private ArrayList<Document> DocumentList;
        private ArrayList<Classe> ClassList;
    //Course Methods
        //getters
            public ArrayList<Classe> getClassList() {
                return ClassList;
            }

            public ArrayList<Document> getDocumentList() {
                return DocumentList;
            }

            public int getDuration() {
                return Duration;
            }

            public int getNofClasses() {
                return NofClasses;
            }

            public int getNofSession() {
                return NofSession;
            }

            public int getNofStudent() {
                return NofStudent;
            }

            public int getTime_Session() {
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

            public void setDuration(int duration) {
                Duration = duration;
            }

            public void setName(String name) {
                Name = name;
            }

            public void setNofClasses(int nofClasses) {
                NofClasses = nofClasses;
            }

            public void setNofSession(int nofSession) {
                NofSession = nofSession;
            }

            public void setNofStudent(int nofStudent) {
                NofStudent = nofStudent;
            }

            public void setTime_Session(int time_Session) {
                Time_Session = time_Session;
            }
}
