package sample.Controllers;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main;
import sample.DataBase.DataBaseConnection;
import sample.Models.Student;
import sample.Models.StudentModel;
import javafx.application.Application;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.Controllers.BasicController.*;

public class StudentsController implements Initializable {
    int i=0;
    private Stage stage;
    private Scene scene ;
    private Parent root ;

    private StudentModel model = new StudentModel();

    String query = null;

    @FXML
    private Button Absence;

    @FXML
    private ImageView AbsenceIcon;

    @FXML
    private Button Calender;

    @FXML
    private ImageView CalenderIcon;

    @FXML
    private TableColumn<Student,String> FirstNameColumn;

    @FXML
    private TableColumn<Student,String> LastNameColumn;

    @FXML
    private TableColumn<Student,String> EmailColumn;

    @FXML
    private TableColumn<Student,String> MatriculeColumn;

    @FXML
    private ImageView CourseIcon;

    @FXML
    private Button Courses;

    @FXML
    private Button Edit;

    @FXML
    private Button Edit1;

    @FXML
    private ImageView EditIcon;

    @FXML
    private Button Grades;

    @FXML
    private ImageView GradesIcon;

    @FXML
    private Button Help;

    @FXML
    private ImageView HelpIcon;

    @FXML
    private Button Home;

    @FXML
    private ImageView HomeIcon;

    @FXML
    private Button Logout;

    @FXML
    private Button Logout1;

    @FXML
    private ImageView LogoutIcon;

    @FXML
    private TextField SearchField;
    @FXML
    private Button MenuBOpen;

    @FXML
    private ImageView MenuIconOpen;

    @FXML
    private Pane MenuSlider;

    @FXML
    private Button Profile;

    @FXML
    private ImageView ProfileIcon;

    @FXML
    private Button Todolist;

    @FXML
    private ImageView TodolistIcon;

    @FXML
    private Button profile;

    @FXML
    private ImageView studentIcon;

    @FXML
    private Label ModifMessage;

    @FXML
    public  TableView<Student> StudentTableView;

    private Student student = new Student();
    ObservableList<Student> StudentObservableList = FXCollections.observableArrayList();


    @FXML
    void Menu(ActionEvent event) {


        i++;


        if (i % 2 != 0) {
            TranslateTransition slideout = new TranslateTransition();
            slideout.setDuration(Duration.seconds(0.4));
            slideout.setNode(MenuSlider);
            System.out.println("1");
            slideout.setToX(-60);
            slideout.play();

        } else if (i % 2 == 0) {
            TranslateTransition slidein = new TranslateTransition();
            slidein.setDuration(Duration.seconds(0.4));
            slidein.setNode(MenuSlider);
            System.out.println("2");
            slidein.setToX(0);

            slidein.play();

        }



    }
    @FXML
    void GoGrades(ActionEvent event) throws IOException {
        checkGrades();

    }

    @FXML
    void GoTodoList(ActionEvent event)throws IOException {
        checkTodoList();

    }

    @FXML
    void GoSchedule(ActionEvent event) throws IOException {
        checkSchedule();
    }
    @FXML
    void Logout(ActionEvent event) throws IOException{
        checkLogout();
    }


    @FXML
    void GoCourse(ActionEvent event) throws IOException {
        checkCourse();
    }
    @FXML
    void LoadData(ActionEvent event) {
       // tableView.setItems(model.getStudentList());
    }


    @FXML
    void GoHelp(ActionEvent event) throws IOException {
        checkHelp();

    }

    @FXML
    void GoProfile(ActionEvent event) throws IOException {
        checkProfile();
    }

    @FXML
    void GoAbsence(ActionEvent event)throws IOException {
        checkAbsence();

    }
    @FXML
    void GoHome (ActionEvent event) throws IOException {
        checkHome();

    }
    @FXML
    void GoStudent(ActionEvent event)throws IOException {
        checkStudent();

    }
    @FXML
    void AddS(ActionEvent event) throws IOException {
        checkAddStudent();
    }

//    @FXML
//    void EditS(ActionEvent event) {
//        Student selected = StudentTableView.getSelectionModel().getSelectedItem();
//        model.updateStudent(selected, nameTextField.getText());
//    }

    //@FXML
   // void DeleteS(ActionEvent event) {
//       Student selected = StudentTableView.getSelectionModel().getSelectedItem();
//        model.deleteStudent(selected);


//        public boolean delete(Student selected) {
//            if(StudentDB.deleteStd(selected.getId()) != 0) {
//                this.studentList.remove(selected);
//                return true;
//            }
//            return false;
//
//
//        }
//        public static int deleteStd(int stdId) {
//            //Declare a DELETE statement
//            String updateStmt =
//                    "   DELETE FROM info\n" +
//                            "         WHERE id = ?;";
//            //Execute UPDATE operation
//            Object[] data = {stdId};
//            return DBUtil.dbExecuteUpdatePrepared(updateStmt, data);
//
//        }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String StudentViewQuery = "SELECT first_name,last_name,email,matricule FROM students;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(StudentViewQuery);

            while (queryOutput.next()){


                String queryFirstName = queryOutput.getString("first_name");
                String queryLastName = queryOutput.getString("last_name");
               String queryEmail = queryOutput.getString("email");
               String queryMatricule = queryOutput.getString("matricule");

                //Populate the Observable list of products
                StudentObservableList.add(new Student( queryFirstName,queryLastName, queryEmail, queryMatricule));

            }

            // Correspending each Column in interface with column in database

                      FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                      LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                      EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
                      MatriculeColumn.setCellValueFactory(new PropertyValueFactory<>("Matricule"));


            // insert Values oF StudentObservableList in the StudentTableView
            StudentTableView.setItems(StudentObservableList);
//
//
//            FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
//            LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
//            EmailColumn.setCellValueFactory(cellData -> cellData.getValue().EmailProperty());
//            MatriculeColumn.setCellValueFactory(cellData -> cellData.getValue().MatriculeProperty());
//

            //initial filtered list
            FilteredList<Student> filteredData = new FilteredList<>(StudentObservableList, b -> true);

            SearchField.textProperty().addListener((observable ,oldValue, newValue)-> {
                filteredData.setPredicate(student -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (student.getFirstName().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (student.getLastName().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (student.getEmail().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (student.getMatricule().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else {
                        return false;
                    }
                });
            });

            SortedList<Student> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(StudentTableView.comparatorProperty());

            StudentTableView.setItems(sortedData);


        }catch (SQLException e){
            Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE , null , e);
            e.printStackTrace();
        }

    }


    public void EditS(ActionEvent event) throws IOException {
//        // Get the selected object from the table
//        Student student = StudentTableView.getSelectionModel().getSelectedItem();
//
//        //checkModifyS();
//        Parent root = FXMLLoader.load(getClass().getResource("EditStudent.fxml"));
//        // Create the scene
//        Scene scene = new Scene(root);
//        // Get the stage and set the scene
//        Stage stage = (Stage) StudentTableView.getScene().getWindow();
//        stage.setScene(scene);
//
//        Label FirstName= (Label) scene.lookup("#FirstNameField");
//        FirstName.textProperty().bind(student.FirstNameProperty());
//
//        Label LastName= (Label) scene.lookup("#LastNameField");
//        LastName.textProperty().bind(student.LastNameProperty());
//
//        Label Email= (Label) scene.lookup("#EmailField");
//        Email.textProperty().bind(student.EmailProperty());
//
//        Label Matricule= (Label) scene.lookup("#MatriculeField");
//        Matricule.textProperty().bind(student.MatriculeProperty());
    }
    public void LoadData() throws  IOException {
        checkStudent();
        StudentObservableList.clear();

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String StudentViewQuery = "SELECT first_name,last_name,email,matricule FROM students;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(StudentViewQuery);

            while (queryOutput.next()) {


                String queryFirstName = queryOutput.getString("first_name");
                String queryLastName = queryOutput.getString("last_name");
                String queryEmail = queryOutput.getString("email");
                String queryMatricule = queryOutput.getString("matricule");

                //Populate the Observable list of products
                StudentObservableList.add(new Student(queryFirstName, queryLastName, queryEmail, queryMatricule));

            }

            // Correspending each Column in interface with column in database

            FirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            LastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            EmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            MatriculeColumn.setCellValueFactory(new PropertyValueFactory<>("Matricule"));


            // insert Values oF StudentObservableList in the StudentTableView
            StudentTableView.setItems(StudentObservableList);
//
//
        } catch (SQLException e){
        Logger.getLogger(StudentsController.class.getName()).log(Level.SEVERE , null , e);
        e.printStackTrace();
    }
    }

   public void DeleteS (ActionEvent event) throws SQLException, IOException {
       DataBaseConnection connectNow = new DataBaseConnection();
       Connection connectDB = connectNow.getConnection();

       // Get the selected object from the table
       Student student1 = StudentTableView.getSelectionModel().getSelectedItem();

// Delete the object from the database
       String deleteSql = "DELETE FROM students WHERE email = ?;" ;
       PreparedStatement pstmt = connectDB.prepareStatement(deleteSql);
       pstmt.setString(1,  student1.getEmail());
       pstmt.executeUpdate();

// Delete the object from the table
       checkStudent();
       StudentTableView.getItems().remove(student1);
       StudentTableView.refresh();

   }

//        DataBaseConnection connectnow = new DataBaseConnection();
//        Connection connectDB = connectnow.getConnection();
//
//        String CodeProduit = SupProdCodeProduitTextField.getText();
//        String ModifyIntoRegister = "DELETE FROM `Managenie_db`.`students` WHERE (`Code_Produit` = '"+CodeProduit+"');" ;
//
//        if (SupProdCodeProduitTextField.getText().isBlank() == false || SupProdCodeProduitTextField.getText().isEmpty() == false ) {
//            try {
//                Statement statement = connectDB.createStatement();
//                statement.executeUpdate(ModifyIntoRegister);
//
//
//                SupMessage.setText("Produit Supprimé Avec Succes !");
//                SupMessage.setTextFill(Color.BLUE);
//
//            }catch (Exception e){
//
//                e.printStackTrace();
//                e.getCause();
//
//            }
//        }else {
//            SupMessage.setText("Entrez Le Code Du Produit !");
//            SupMessage.setTextFill(Color.RED);
//        }

    }


//    }

//
//    @FXML
//    void addButton(ActionEvent event) {
//        Student newS = new Student(nameTextField.getText());
//        model.addStudent(newS);
//    }
//
//    @FXML
//    void deleteButton(ActionEvent event) {
//        Student selected = tableView.getSelectionModel().getSelectedItem();
//        model.deleteStudent(selected);
//    }
//





