package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
  private Connection connect() {
    // SQLite connection string
    String url = "jdbc:sqlite:your_database.db";
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public void insert(String name, double capacity) {
    String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, name);
      pstmt.setDouble(2, capacity);
      pstmt.executeUpdate();
      System.out.println("Data has been inserted.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    InsertData app = new InsertData();
    // insert three new rows
    app.insert("Raw Materials", 3000);
    app.insert("Semifinished Goods", 4000);
    app.insert("Finished Goods", 5000);
  }
}
