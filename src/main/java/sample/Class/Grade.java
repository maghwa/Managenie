package sample.Class;

public class Grade {
    private int idStudent;
    private String TestName;
    private int Mark;
//getters
    public int getIdStudent() {
        return idStudent;
    }
    public int getMark() {
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
