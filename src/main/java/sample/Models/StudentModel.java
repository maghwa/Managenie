package sample.Models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentModel {
    ObservableList<Student> studentList;

    public StudentModel() {
        studentList = FXCollections.observableArrayList();
        studentList.add(new Student("Marwa","El Kamil","mima@gmail.com","AZAZkk"));
        studentList.add(new Student("Nila","El Amrani","nino@gmail.com","jjajaj"));

    }

    public StudentModel(ObservableList<Student> studentList) {
        super();
        this.studentList = studentList;
    }

    public ObservableList<Student> getStudentList() {
        return studentList;
    }

    public void deleteStudent(Student s) {
        studentList.remove(s);
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public void updateStudent(Student s, String name) {
        int index = studentList.indexOf(s);
        studentList.get(index).setLastname(name);
    }
}
