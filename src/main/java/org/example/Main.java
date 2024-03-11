package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://hatice-gunay:3306/sys";
        String kullaniciadi = "root";
        String sifre = "test123";

        try (Connection connection = DriverManager.getConnection(url, kullaniciadi, sifre)) {
            // Tablo oluşturma
           /* String createTableSQL = "CREATE TABLE ad_soyad ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "ad VARCHAR(50),"
                    + "soyad VARCHAR(50)"
                    + ")"; */
           /* try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.executeUpdate();
                System.out.println("Table 'ad_soyad' created successfully!");
            } */

            // Veri ekleme
            String insertDataSQL = "INSERT INTO ad_soyad (ad, soyad) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "Doe");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Jane");
                preparedStatement.setString(2, "Doe");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Alice");
                preparedStatement.setString(2, "Smith");
                preparedStatement.executeUpdate();
                System.out.println("Data inserted successfully!");
            }

            // Bir veriyi silme
            String deleteDataSQL = "DELETE FROM ad_soyad WHERE ad = ? AND soyad = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteDataSQL)) {
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "Doe");
                preparedStatement.executeUpdate();
                System.out.println("Data deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}