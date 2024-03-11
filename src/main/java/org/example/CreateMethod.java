package org.example;

import java.sql.*;

public class CreateMethod {
    public void create ()
    {
        String url = "jdbc:mysql://hatice-gunay:3306/sys";
        String kullaniciadi = "root";
        String sifre = "test123";
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        //ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, kullaniciadi, sifre);
            String ekle = "INSERT INTO ad_soyad (id, Ad, Soyad) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(ekle);
            preparedStatement.setString(1, "33");
            preparedStatement.setString(2, "Duru");
            preparedStatement.setString(3, "Gunay");

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows>0) {
                System.out.println("Veri eklendi.");
            }else {
                System.out.println("Veri eklenemedi.");

                preparedStatement.close();
                connection.close();
            }
        } catch(
                SQLException e) {
            e.printStackTrace();
        }
    }
}