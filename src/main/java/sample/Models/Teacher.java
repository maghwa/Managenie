package sample.Models;

public class Teacher {
    //teacher attributes
    private String UserName;
    private String FirstName;
    private String LastName ;
    private String Email;
    private String Password;

    //teacher methods

        //getters
            public String getEmail() {
                return Email;
            }

            public String getFirstName() {
                return FirstName;
            }

            public String getLastName() {
                return LastName;
            }

            public String getPassword() {
                return Password;
            }

            public String getUserName() {
                return UserName;
            }
        //setters
            public void setEmail(String email) {
                Email = email;
            }

            public void setFirstName(String firstName) {
                FirstName = firstName;
            }

            public void setLastName(String lastName) {
                LastName = lastName;
            }

            public void setPassword(String password) {
                Password = password;
            }


            public void setUserName(String userName) {
                UserName = userName;
            }
}
