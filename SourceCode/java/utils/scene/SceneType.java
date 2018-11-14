package utils.scene;

public enum SceneType {

    CREATE_GROUP("/fxml/CreateGroupForm.fxml", "Gruppe erstellen"),
    CREATE_STUDENT("/fxml/CreateStudentForm.fxml", "Studenten erstellen"),
    CREATE_SEMESTER("/fxml/CreateSemesterForm.fxml", "Semester erstellen"),
    CREATE_GROUPAGE("/fxml/CreateGroupageForm.fxml", "Klasse erstellen"),
    EDIT_GROUP("/fxml/EditGroupForm.fxml", "Gruppe bearbeiten"),
    EDIT_STUDENT("/fxml/EditStudentForm.fxml", "Studenten bearbeiten"),
    EDIT_SEMESTER("/fxml/EditSemesterForm.fxml", "Semester bearbeiten"),
    EDIT_GROUPAGE("/fxml/EditGroupageForm.fxml", "Klasse bearbeiten"),
    HOME("/fxml/HomeScreenView.fxml", "SemestervErwaltungsPlan"),
    LOGIN("/fxml/LoginForm.fxml", "SemestervErwaltungsPlan"),
    REGISTER("/fxml/RegisterForm.fxml", "Registrierung"),
    CHAT_APP("/fxml/ChatApp.fxml", "ChatApp"),
    CHAT_WINDOW("/fxml/ChatWindow.fxml", "ChatWindow"),
    NOTEPAD_WINDOW("/fxml/AddNotepadForm.fxml", "NotepadWindow"),
    CHAT_TAB_CONTENT_TEST("/fxml/ChatTabContentTest.fxml", "ChatTabContentTest"),
    CHAT_WINDOW_TAB_PANE_TEST("/fxml/ChatWindowTabPaneTest.fxml", "ChatWindowTabPaneTest");




    private String path, title;

    SceneType(String path, String title) {
        this.path = path;
        this.title = title;
    }

    public String getPath() {
        return this.path;
    }

    public String getTitle() { return this.title; }

}
