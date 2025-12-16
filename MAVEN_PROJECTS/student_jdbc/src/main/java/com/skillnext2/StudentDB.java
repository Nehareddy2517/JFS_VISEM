package com.skillnext2;

import java.sql.*;

public class StudentDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_jdbc"
                   + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        String user = "root";
        String password = "NEHA05";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("course")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
