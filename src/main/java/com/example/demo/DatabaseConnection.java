package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  public static Connection connect() {
    Connection conn = null;
    try {
      String url = "jdbc:sqlite:your_database.db";
      conn = DriverManager.getConnection(url);
      System.out.println("Connection to SQLite has been established.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }
}
