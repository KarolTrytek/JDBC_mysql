package org.example;

import java.sql.*;

public class JDBC_update_table_example {
    public static void main(String[] args) {


        Connection connection = null;
        Statement statement = null;//obiekt na zasadzie klasy statement, do wykonywania zapytan
        ResultSet resultSet = null;
        try {
             connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root", "");

            if(connection==null) {
            System.out.println("Brak polaczenia z baza danych");
        } else {
            System.out.println("jest polaczenie.");
        }

            statement = connection.createStatement();
            String sql = "UPDATE employees SET address = 'Wrocław' where id in (1,2)";
                            //zmieniamy dwa podane rekordy
            statement.executeUpdate(sql); //dodanie elementow z executeUpdate()

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //resultSet.close(); //zamykamy polaczenia w odwrotnej kolejnosci niz je tworzylismy
            }catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();//wazne, zeby zamnkac tez statement
            }catch (Exception e){
                e.printStackTrace();
            };
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
