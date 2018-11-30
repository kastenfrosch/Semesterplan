package controller;

import com.j256.ormlite.dao.Dao;
import connection.DBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modal.ConfirmationModal;
import modal.ErrorModal;
import modal.InfoModal;
import models.*;
import utils.scene.SceneManager;
import utils.scene.SceneType;

import java.sql.SQLException;

public class EditNotepadController {

    private Object objectType;
    private Notepad notepad;
    private DBManager db;

    {
        try {
            db = DBManager.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public TextArea editNotepadTextarea;
    @FXML
    public Label editNotepadLabel;
    @FXML
    public TextField editNotepadName;
    @FXML
    public ComboBox<String> editNotepadPriorityComboBox;
    @FXML
    public Button editNotepadSaveButton;
    @FXML
    public Button editNotepadCancelButton;

    public void initialize() throws SQLException { //Initializing ComboBox
        ObservableList<String> prioritaet = FXCollections.observableArrayList("Hoch", "Mittel",
                                                                                   "Niedrig", "Neutral");
        editNotepadPriorityComboBox.setItems(prioritaet);

        Dao<Notepad, Integer> notepadDao = db.getNotepadDao(); //Testing
        Notepad notepad = notepadDao.queryForId(8);

        Dao<StudentNotepad, Integer> studentNotepad = db.getStudentNotepadDao(); //Testing
        StudentNotepad studentNote = studentNotepad.queryForId(2);
        /*
        this.notepad.setNotepadName(studentNote.getNotepad().getNotepadName());
        this.notepad.setNotepadPriority(studentNote.getNotepad().getNotepadPriority());
        this.notepad.setNotepadContent(studentNote.getNotepad().getNotepadContent());

        editNotepadTextarea.setText(this.notepad.getNotepadContent());
        editNotepadName.setText(this.notepad.getNotepadName());

        if(this.notepad.getNotepadPriority().equals("Hoch")) {
            editNotepadTextarea.setStyle("-fx-background-color: red");
            editNotepadPriorityComboBox.getSelectionModel().select("Hoch");
        }
        else if(this.notepad.getNotepadPriority().equals("Mittel")) {
            editNotepadTextarea.setStyle("-fx-background-color: yellow");
            editNotepadPriorityComboBox.getSelectionModel().select("Mittel");
        }
        else if(this.notepad.getNotepadPriority().equals("Niedrig")) {
            editNotepadTextarea.setStyle("-fx-background-color: green");
            editNotepadPriorityComboBox.getSelectionModel().select("Niedrig");
        }
        else if(this.notepad.getNotepadPriority().equals("Neutral")) {
            editNotepadTextarea.setStyle("-fx-background-color: grey");
            editNotepadPriorityComboBox.getSelectionModel().select("Neutral");
        } */
    }

    public void setPriority(ActionEvent actionEvent) { //Setting Colors in relation to the chosen priority
        if (editNotepadPriorityComboBox.getSelectionModel().getSelectedItem().equals("Hoch")) {
            editNotepadTextarea.setStyle("-fx-background-color: red");
        } else if (editNotepadPriorityComboBox.getSelectionModel().getSelectedItem().equals("Mittel")) {
            editNotepadTextarea.setStyle("-fx-background-color: yellow");
        } else if (editNotepadPriorityComboBox.getSelectionModel().getSelectedItem().equals("Niedrig")) {
            editNotepadTextarea.setStyle("-fx-background-color: green");
        } else if (editNotepadPriorityComboBox.getSelectionModel().getSelectedItem().equals("Neutral")) {
            editNotepadTextarea.setStyle("-fx-background-color: grey");
        }
    }

    public void editNotepadSave(ActionEvent actionEvent) { //Updating notepad changes
        String noteName;
        if (editNotepadName == null || editNotepadName.getText().isBlank()) {
            InfoModal.show("FEHLER!", null, "Bitte Bezeichnung eingeben!");
            return;
        }
        noteName = editNotepadName.getText();

        String priority;
        if (editNotepadPriorityComboBox.getSelectionModel().getSelectedItem() == null) {
            InfoModal.show("FEHLER!", null, "Bitte Priorität bestimmen!");
            return;
        }
        priority = editNotepadPriorityComboBox.getSelectionModel().getSelectedItem();

        String textContent;
        if (editNotepadTextarea == null || editNotepadTextarea.getText().isBlank()) {
            InfoModal.show("FEHLER!", null, "Bitte Notiz eingeben");
            return;
        }
        textContent = editNotepadTextarea.getText();

        Dao<Notepad, Integer> notepadDao = db.getNotepadDao();

        this.notepad.setNotepadName(noteName);
        this.notepad.setNotepadPriority(priority);
        this.notepad.setNotepadContent(textContent);

        try {
            notepadDao.update(this.notepad);

            if(this.objectType instanceof Student) {
                StudentNotepad studentNotepad = new StudentNotepad();
                studentNotepad.setStudent((Student) this.objectType);
                studentNotepad.setNotepad(notepad);

                Dao<StudentNotepad, Integer> studentNotepadDao = db.getStudentNotepadDao();
                studentNotepadDao.update(studentNotepad);
            }
            else if(this.objectType instanceof Groupage) {
                GroupageNotepad groupageNotepad = new GroupageNotepad();
                groupageNotepad.setGroupage((Groupage) this.objectType);
                groupageNotepad.setNotepad(notepad);

                Dao<GroupageNotepad, Integer> groupageNotepadDao = db.getGroupageNotepadDao();
                groupageNotepadDao.update(groupageNotepad);
            }
            else if(this.objectType instanceof Group) {
                GroupNotepad groupNotepad = new GroupNotepad();
                groupNotepad.setGroup((Group) this.objectType);
                groupNotepad.setNotepad(notepad);

                Dao<GroupNotepad, Integer> groupNotepadDao = db.getGroupNotepadDao();
                groupNotepadDao.update(groupNotepad);
            }

            InfoModal.show("Notiz" + editNotepadName.getText() + " wurde geändert!");
        } catch (SQLException e) {
            ErrorModal.show(e.getMessage());
            e.printStackTrace();
        }
        SceneManager.getInstance().closeWindow(SceneType.EDIT_NOTEPAD_WINDOW);
    }

    public void editNotepadCancel(ActionEvent actionEvent) { //When Cancel Button is pressed
        SceneManager.getInstance().closeWindow(SceneType.EDIT_NOTEPAD_WINDOW);
    }

    public void setNotepad(Notepad notepad) { //Getting the given Notepad config
        this.notepad = notepad;
        editNotepadName.setText(notepad.getNotepadName());
        editNotepadPriorityComboBox.getSelectionModel().select(notepad.getNotepadPriority());
        editNotepadTextarea.setText(notepad.getNotepadContent());
    }

    public void setObject(Object object) {
        this.objectType = object;
    }
}
