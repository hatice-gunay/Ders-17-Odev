package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteMethod {
    public void sil (){
        String url = "jdbc:mysql://hatice-gunay:3306/sys";
        String kullaniciadi = "root";
        String sifre = "test123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, kullaniciadi, sifre);
            String sil = "DELETE FROM ad_soyad WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sil);
            preparedStatement.setInt(1, 3);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Veri silindi.");
            } else {
                System.out.println("Veri silinemedi.");
            }
            preparedStatement.close();
            connection.close();
        }
        catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
