package connection;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import models.*;

import java.sql.SQLException;

public class DBUtils {

	public static void clearTables(ConnectionSource conn) throws SQLException {
		TableUtils.clearTable(conn, Semester.class);
		TableUtils.clearTable(conn, Person.class);
        TableUtils.clearTable(conn, User.class);
        TableUtils.clearTable(conn, Groupage.class);
        TableUtils.clearTable(conn, Group.class);
        TableUtils.clearTable(conn, Student.class);
	}


    public static void dropTables(ConnectionSource conn) throws SQLException {
        TableUtils.dropTable(conn, Student.class, false);
        TableUtils.dropTable(conn, Group.class, false);
        TableUtils.dropTable(conn, Groupage.class, false);
        TableUtils.dropTable(conn, User.class, false);
        TableUtils.dropTable(conn, Person.class, false);
        TableUtils.dropTable(conn, Semester.class, false);
    }

    public static void createTables(ConnectionSource conn) throws SQLException {
        TableUtils.createTable(conn, Semester.class);
        TableUtils.createTable(conn, Person.class);
        TableUtils.createTable(conn, User.class);
        TableUtils.createTable(conn, Groupage.class);
        TableUtils.createTable(conn, Group.class);
        TableUtils.createTable(conn, Student.class);
    }

    public static void resetDB(ConnectionSource conn, boolean withDummyData) throws SQLException {
	    dropTables(conn);
	    createTables(conn);
	    if(withDummyData) {
            insertDummyData(conn);
        }
    }

    public static void insertDummyData(ConnectionSource conn) throws SQLException {

        DBManager manager = DBManager.getInstance();

        Semester WS1819 = new Semester("WS1819", "Wintersemester 2018/2019");
        Semester SS19 = new Semester("SS19", "Sommersemester 2019");
        Semester WS1920 = new Semester("WS1920", "Wintersemester 2019/2020");
        Semester SS20 = new Semester("SS20", "Sommersemester 2020");

        Dao<Semester, String> semesterDao = manager.getSemesterDao();
        semesterDao.create(WS1819);
        semesterDao.create(SS19);
        semesterDao.create(WS1920);
        semesterDao.create(SS20);

        Groupage one = new Groupage("Eins", WS1819);
        Groupage two = new Groupage("Zwei", SS19);
        Groupage three = new Groupage("Drei", WS1920);
        Groupage four = new Groupage("Vier", SS20);

        Dao<Groupage, Integer> groupageDao = manager.getGroupageDao();
        groupageDao.create(one);
        groupageDao.create(two);
        groupageDao.create(three);
        groupageDao.create(four);

        Group g1 = new Group("Die Pummelbären", one, WS1819);
        Group g2 = new Group("Die Knatterkasten", one, WS1819);
        Group g3 = new Group("Der Gerät", two, SS19);
        Group g4 = new Group("Hurr Durr", two, SS19);
        Group g5 = new Group("/r/animemes", three, WS1920);
        Group g6 = new Group("87 Zoll TV", three, WS1920);
        Group g7 = new Group("Elektroroller", four, SS20);
        Group g8 = new Group("Dickes Gerät", four, SS20);

        Dao<Group, Integer> groupDao = manager.getGroupDao();
        groupDao.create(g1);
        groupDao.create(g2);
        groupDao.create(g3);
        groupDao.create(g4);
        groupDao.create(g5);
        groupDao.create(g6);
        groupDao.create(g7);
        groupDao.create(g8);

        Person p1 = new Person("Hans", "Elektriker", "hans.elektriker@example.com");
        Person p2 = new Person("Dieter", "Requirements Engineering", "dieter.re@example.com");
        Person p3 = new Person("Eins Nices", "Bier", "1nice.bier@example.com");
        Person p4 = new Person("Dieses", "Quadrat", "viereck@example.com");
        Person p5 = new Person("2d >", "3d", "djeetapeek@example.com");
        Person p6 = new Person("Yuru", "Yuri", "nonexistent@example.com");
        Person p7 = new Person("I Bless", "The Rains", "downinafrica@example.com");
        Person p8 = new Person("Not", "Aus", "meep@example.com");
        Person p9 = new Person("Godsworn", "Alexiel", "bigsord@example.com");
        Person p10 = new Person("Sasuga", "Ainz", "sama@example.com");
        Person p11 = new Person("But How", "Do It", "Know@example.com");
        Person p12 = new Person("Choo", "Choo", "iliketrains@example.com");
        Person p13 = new Person("Half Treasure", "Cost", "event@example.com");

        Dao<Person, Integer> personDao = manager.getPersonDao();
        personDao.create(p1);
        personDao.create(p2);
        personDao.create(p3);
        personDao.create(p4);
        personDao.create(p5);
        personDao.create(p6);
        personDao.create(p7);
        personDao.create(p8);
        personDao.create(p9);
        personDao.create(p10);
        personDao.create(p11);
        personDao.create(p12);
        personDao.create(p13);

        User u1 = new User("besttutor", "7A2A74526720526A0E438D027A6AD7B6", "E9506988FBCBBD1414970314455E9091", p12);

        Dao<User, String> userDao = manager.getUserDao();
        userDao.create(u1);

        Student s1 = new Student("0000001", p1, g1, WS1819);
        Student s2 = new Student("0000002", p2, g1, WS1819);
        Student s3 = new Student("0000003", p3, g1, WS1819);
        Student s4 = new Student("0000004", p4, g1, WS1819);
        Student s5 = new Student("0000005", p5, g2, SS19);
        Student s6 = new Student("0000006", p6, g2, SS19);
        Student s7 = new Student("0000007", p7, g3, SS19);
        Student s8 = new Student("0000008", p8, g4, SS19);
        Student s9 = new Student("0000009", p9, g5, WS1920);
        Student s10 = new Student("0000010", p10, g6, WS1920);
        Student s11 = new Student("0000011", p11, g7, SS20);
        Student s12 = new Student("0000012", p13, g8, SS20);

        Dao<Student, Integer> studentDao = manager.getStudentDao();
        studentDao.create(s1);
        studentDao.create(s2);
        studentDao.create(s3);
        studentDao.create(s4);
        studentDao.create(s5);
        studentDao.create(s6);
        studentDao.create(s7);
        studentDao.create(s8);
        studentDao.create(s9);
        studentDao.create(s10);
        studentDao.create(s11);
        studentDao.create(s12);

    }
}