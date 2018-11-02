package controller;

import com.j256.ormlite.dao.Dao;
import connection.DBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modal.InfoModal;
import models.Groupage;
import models.Semester;

import java.sql.SQLException;



public class CreateGroupageController {

    @FXML
    public Label AddGroupageLabel;
    @FXML
    public Button cancelButton;
    @FXML
    public Button addSaveButton;
    @FXML
    public TextField nameTextfield;
    @FXML
    public Label nameLabel;
    @FXML
    public Label semesterLabel;

    @FXML
    public ComboBox addChooseSemesterComboBox;

    private DBManager db;

    {
        try {
            db = DBManager.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void groupList() {

        try {


            ObservableList<String> semesterList = FXCollections.observableArrayList();
            Dao<Semester, String> semester = db.getSemesterDao();

            for (Semester s : semester.queryForAll()) {
                semesterList.add(s.getDescription());
            }

            addChooseSemesterComboBox.setItems(semesterList);

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGroupageCancelButton(ActionEvent actionEvent) {
    }

    public void addGroupageAddSafeButton(ActionEvent actionEvent) {

        String name;
        if (nameTextfield.getText() == null || nameTextfield.getText().isBlank()) {
            InfoModal.show("FEHLER!", null, "Kein Klassenname eingegeben!");
            return;
        }
        name = nameTextfield.getText();

        String semesterString;
        if(addChooseSemesterComboBox.getSelectionModel().getSelectedItem() == null|| addChooseSemesterComboBox == null) {
            InfoModal.show("FEHLER!", null, "Bitte Semester angeben!");
            return;
        }
        semesterString = (String) addChooseSemesterComboBox.getSelectionModel().getSelectedItem();



        try {

            Dao<Semester, String> semesterDao = db.getSemesterDao();
            Semester semester = semesterDao.queryForEq(Semester.FIELD_SEMESTER_DESCRIPTION, semesterString).get(0);

            models.Groupage newGroupage = new Groupage();

            newGroupage.setDescription(name);
            newGroupage.setSemester(semester);

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        InfoModal.show("Klasse \"" + name + "\" erstellt!");
    }
}