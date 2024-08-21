package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTable {
  public static void createNewTable() {
    String url = "jdbc:sqlite:your_database.db";

    // SQL statement for creating a new table
    String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
        + "    id integer PRIMARY KEY,\n"
        + "    name text NOT NULL,\n"
        + "    capacity real\n"
        + ");";

    try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
      // create a new table
      stmt.execute(sql);
      System.out.println("Table has been created.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    createNewTable();
  }
}