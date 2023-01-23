package sample.Models;

import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

public class Student{
    //attributes
    private SimpleStringProperty firstname = new SimpleStringProperty();
    private SimpleStringProperty lastname = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleStringProperty matricule = new SimpleStringProperty();

    //attributs
    private String Matricule;
    private String FirstName;
    private String LastName;
    private String Email;

    //getters
    public String getFirstName() {
        return firstname.get();
    }
    public String getLastName() {
        return lastname.get();
    }
    public String getEmail() {
        return email.get();
    }
    public String getMatricule() {
        return matricule.get();
    }
    //setters
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
    public void setLastname(String lastname) {this.lastname.set(lastname);}
    public void setEmail(String email) {this.email.set(email);}
    public void setMatricule(String matricule) {this.matricule.set(matricule);}


    //Constructors
    public Student() {
        super();
    }
    public Student(String FirstName,String LastName,String Email,String Matricule) {

        this.firstname.set(FirstName);
        this.lastname.set(LastName);
        this.email.set(Email);
        this.matricule.set(Matricule);
    }
    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }
    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }
    public SimpleStringProperty emailProperty() {
        return email;
    }
    public SimpleStringProperty matriculeProperty() {
        return matricule;
    }


}
