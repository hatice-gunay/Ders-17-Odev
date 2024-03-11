package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateMethod {
    public void degistir()
    {
        String url = "jdbc:mysql://hatice-gunay:3306/sys";
        String kullaniciadi = "root";
        String sifre = "test123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, kullaniciadi, sifre);
            String guncelle = "UPDATE ad_soyad  SET AD = ?, Soyad = ? WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(guncelle);
            preparedStatement.setString(1, "Hatice");
            preparedStatement.setString(2, "Gunay");
            preparedStatement.setString(3, "33");
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Veri güncellendi.");
            } else {
                System.out.println("Veri güncellenemedi.");
            }
            preparedStatement.close();
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
