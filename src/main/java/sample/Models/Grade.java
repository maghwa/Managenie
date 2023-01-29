package sample.Models;

public class Grade {

    private Integer idStudent;
    private String TestName;
    private Integer Mark;
    //constructer
    public Grade(int idStudent, int mark) {
        this.idStudent = idStudent;

        Mark = mark;
    }

    public Grade() { super ();
    }


    //getters
    public Integer getIdStudent() {
        return idStudent;
    }
    public Integer getMark() {
        return Mark;
    }
    public String getTestName() {
        return TestName;
    }

    //setters
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    public void setMark(int mark) {
        Mark = mark;
    }
    public void setTestName(String testName) {
        TestName = testName;
    }

}
