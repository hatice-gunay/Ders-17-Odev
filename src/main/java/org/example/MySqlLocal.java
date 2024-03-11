package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlLocal {
    public static void main(String[] args) {

        CreateMethod tabloekle = new CreateMethod();
        tabloekle.create();

        SelectMethod tabloliste = new SelectMethod();
        tabloliste.select();

        UpdateMethod tablodegistir = new UpdateMethod();
        tablodegistir.degistir();

        tabloliste = new SelectMethod();
        tabloliste.select();

        DeleteMethod deletemethod = new DeleteMethod();
        deletemethod.sil();
    }
}