package sample.Class;

import java.util.ArrayList;

public class Classe extends Course {
   //Classe Attributes
        private int idClasse;
        private int SizeClasse;
        private ArrayList<Student> StudentList;
    //Classe Methods
        //getters

            public int getIdClasse() {
                return idClasse;
            }

            public int getSizeClasse() {
                return SizeClasse;
            }

            public ArrayList<Student> getStudentList() {
                return StudentList;
            }
        //setters

            public void setIdClasse(int idClasse) {
                this.idClasse = idClasse;
            }

            public void setSizeClasse(int sizeClasse) {
                SizeClasse = sizeClasse;
            }

            public void setStudentList(ArrayList<Student> studentList) {
                StudentList = studentList;
            }
}




/* overriding Course getters and setters if needed

    @Override
    public ArrayList<Classe> getClassList() {
        return super.getClassList();
    }

    @Override
    public ArrayList<Document> getDocumentList() {
        return super.getDocumentList();
    }

    @Override
    public int getDuration() {
        return super.getDuration();
    }

    @Override
    public int getNofClasses() {
        return super.getNofClasses();
    }

    @Override
    public int getNofSession() {
        return super.getNofSession();
    }

    @Override
    public int getNofStudent() {
        return super.getNofStudent();
    }

    @Override
    public int getTime_Session() {
        return super.getTime_Session();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }
    //setters

    @Override
    public void setClassList(ArrayList<Classe> classList) {
        super.setClassList(classList);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public void setDocumentList(ArrayList<Document> documentList) {
        super.setDocumentList(documentList);
    }

    @Override
    public void setDuration(int duration) {
        super.setDuration(duration);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setNofClasses(int nofClasses) {
        super.setNofClasses(nofClasses);
    }

    @Override
    public void setNofSession(int nofSession) {
        super.setNofSession(nofSession);
    }

    @Override
    public void setNofStudent(int nofStudent) {
        super.setNofStudent(nofStudent);
    }

    @Override
    public void setTime_Session(int time_Session) {
        super.setTime_Session(time_Session);
    }
    */
