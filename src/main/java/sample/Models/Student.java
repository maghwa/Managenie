package sample.Models;



public class Student {

    //attributs
    private String Matricule;
    private String FirstName;
    private String LastName;
    private String Email;

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
}
