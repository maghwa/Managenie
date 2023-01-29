package sample.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Student {

    //attributs
    private String Matricule;
    private String FirstName;
    private String LastName;
    private String Email;
//
//    private final StringProperty FirstNameSP = new SimpleStringProperty();
//    private final StringProperty LastNameSP = new SimpleStringProperty();
//    private final StringProperty EmailSP = new SimpleStringProperty();
//    private final StringProperty MatriculeSP = new SimpleStringProperty();

    //getters


    public Student() {
        super();
    }

    public Student(String FirstName, String LastName, String Email, String Matricule) {
this.FirstName=FirstName;

        this.LastName=LastName;

        this.Email=Email;
        this.Matricule=Matricule;
    }
    public Student(String FirstName, String LastName) {
        this.FirstName=FirstName;

        this.LastName=LastName;

    }
//
//    public String getFirstNameSP() {
//        return FirstNameSP.get();
//    }
//
//    public StringProperty firstNameSPProperty() {
//        return FirstNameSP;
//    }
//
//    public void setFirstNameSP(String firstNameSP) {
//        this.FirstNameSP.set(firstNameSP);
//    }
//
//    public String getLastNameSP() {
//        return LastNameSP.get();
//    }
//
//    public StringProperty lastNameSPProperty() {
//        return LastNameSP;
//    }
//
//    public void setLastNameSP(String lastNameSP) {
//        this.LastNameSP.set(lastNameSP);
//    }
//
//    public String getEmailSP() {
//        return EmailSP.get();
//    }
//
//    public StringProperty emailSPProperty() {
//        return EmailSP;
//    }
//
//    public void setEmailSP(String emailSP) {
//        this.EmailSP.set(emailSP);
//    }
//
//    public String getMatriculeSP() {
//        return MatriculeSP.get();
//    }
//
//    public StringProperty matriculeSPProperty() {
//        return MatriculeSP;
//    }
//
//    public void setMatriculeSP(String matriculeSP) {
//        this.MatriculeSP.set(matriculeSP);
//    }

    public String getEmail() {
        return Email;
    }

    public String getMatricule() {
        return Matricule;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
//setters
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public void setMatricule(String matricule) {
        Matricule = matricule;
    }
//string Properties
//public StringProperty FirstNameProperty() {
//    return FirstNameSP;
//}
//    public StringProperty LastNameProperty() {
//        return LastNameSP;
//    }
//    public StringProperty EmailProperty() {
//        return EmailSP;
//    }
//    public StringProperty MatriculeProperty() {
//        return MatriculeSP;
//    }
}
