package utils.scene;

public enum SceneType {

    CREATE_GROUP("/fxml/form/basic/CreateGroupForm.fxml", "Gruppe erstellen"),
    CREATE_STUDENT("/fxml/form/basic/CreateStudentForm.fxml", "Studenten erstellen"),
    CREATE_SEMESTER("/fxml/form/basic/CreateSemesterForm.fxml", "Semester erstellen"),
    CREATE_GROUPAGE("/fxml/form/basic/CreateGroupageForm.fxml", "Klasse erstellen"),
    EDIT_GROUP("/fxml/form/basic/EditGroupForm.fxml", "Gruppe bearbeiten"),
    EDIT_STUDENT("/fxml/form/basic/EditStudentForm.fxml", "Studenten bearbeiten"),
    EDIT_SEMESTER("/fxml/form/basic/EditSemesterForm.fxml", "Semester bearbeiten"),
    EDIT_GROUPAGE("/fxml/form/basic/EditGroupageForm.fxml", "Klasse bearbeiten"),
    HOME("/fxml/HomeScreenView.fxml", "SemestervErwaltungsPlan"),
    LOGIN("/fxml/form/login/LoginForm.fxml", "SemestervErwaltungsPlan"),
    REGISTER("/fxml/form/login/RegisterForm.fxml", "Registrierung"),
    CHAT_APP("/fxml/chat/ChatTabContent.fxml", "ChatApp"),
    CHAT_WINDOW("/fxml/chat/ChatWindowTabPane.fxml", "ChatWindow"),
    CREATE_NOTEPAD_WINDOW("/fxml/form/notepad/CreateNotepadForm.fxml", "CreateNotepadWindow"),
    EDIT_NOTEPAD_WINDOW("/fxml/form/notepad/EditNotepadForm.fxml", "EditNotepadWindow"),
    NOTESTAB_WINDOW("/fxml/form/notepad/NotesTabForm.fxml", "NotesTabWindow"),
    NOTE_WINDOW("/fxml/form/notepad/NoteWindowForm.fxml", "NoteWindow"),
    USER_ADMIN("/fxml/form/useradmin/UserAdministrationForm.fxml", "User Administration"),
    EDIT_USER ("/fxml/form/useradmin/EditUserForm.fxml","User bearbeiten"),
    CREATE_TIMETABLE("/fxml/form/calendar/CreateTimetable.fxml","Kalender"),
    TIMETABLE_WINDOW("/fxml/form/calendar/TimetableWindow.fxml","Stundenplan"),
    INVITE_CODE("/fxml/form/useradmin/InviteCode.fxml", "Einwahlcodes"),
    PASSWORD_RESET("/fxml/form/useradmin/PasswordResetForm.fxml","Passwort ändern"),
    CREATE_TERM_ORGANISATION("/fxml/form/calendar/CreateTermOrganisation.fxml","Semesterplan erstellen"),
    EDIT_AND_CREATE_SEMESTERPLAN("/fxml/form/calendar/Semesterplan.fxml","Semesterplan"),
    TARDY_VIEW("/fxml/form/calendar/TardyView.fxml","Anwesenheitsplan"),
    WEEK_CALENDAR("/fxml/alt/WeekCalendarView.fxml", "Wochenplan"),
    SEND_MAIL("/fxml/mail/SendMail.fxml","Email senden"),
    RECEIVE_MAIL("/fxml/mail/ReceiveMail.fxml","Email empfangen"),
    READ_MAIL("/fxml/mail/ReadMail.fxml","Email lesen"),
    NOTEPAD_VIEW("/fxml/alt/NoteView.fxml", "Notizen");



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
