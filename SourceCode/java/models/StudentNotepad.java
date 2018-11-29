package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = StudentNotepad.TABLE_STUDENT_NOTEPAD)
public class StudentNotepad {
    public static final String TABLE_STUDENT_NOTEPAD = "notepad_student";
    public static final String FIELD_NOTEPAD_ID = "notepad_id";
    public static final String FIELD_USERNAME = "username";

    @DatabaseField(columnName = FIELD_NOTEPAD_ID, foreign = true, foreignAutoRefresh = true,
            columnDefinition = "integer not null references notepad(notepad_id)", id = true)
    private Notepad notepad;

    @DatabaseField(columnName = FIELD_USERNAME, foreign = true, foreignAutoRefresh = true,
            columnDefinition = "varchar not null references student(student_id)", id = true)
    private Student student;

    public Notepad getNotepad() {
        return notepad;
    }

    public void setNotepad(Notepad notepad) {
        this.notepad = notepad;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
