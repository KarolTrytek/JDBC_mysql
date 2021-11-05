package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_connection {
    public static void main(String[] args) {

        //polaczenie do bazy danych
        Connection connection = null;
        try {
             connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root", "");
                                                //to samo co localhost/wskazujemy baze
        if(connection==null) {
            System.out.println("Brak polaczenia z baza danych");
        } else {
            System.out.println("jest polaczenie.");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close(); //wazne zeby na koncu pracy zamykac polaczenie z baza danych
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
