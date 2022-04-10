package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        getConnection(); }

    public static Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // write your code here
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://cisvm-winsrv-mysql1.unfcsd.unf.edu:3307/?user=n01407405";
        String username = "n01407405";
        String password = "Fall20207405";
        //  Database credentials
        Connection conn = null;
        Statement stmt = null;


        System.out.println("Connecting to a selected database...");
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL,username,password);
        Statement myState = conn.createStatement();
        System.out.println("Connected database successfully...");
        System.out.println("Task_id"+" - " +"title"+" - " + ("Start_date")+ "  - "+" Due_DAte  "+ ("priority")+" - " + ("description") );

        try (ResultSet myRs = myState.executeQuery("select * from group2.tasks")) {
            while (myRs.next()) {

                System.out.println(myRs.getString("task_id") + "       ,"
                        + myRs.getString("title") + " , "
                        + myRs.getString("Start_date") + " , "
                        + myRs.getString("due_date") +"      ,"
                        +myRs.getString("priority")+" ,          "
                        +    myRs.getString("description")); } }
        System.out.print("welcome");
        return conn; }
}


