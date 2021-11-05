package org.example;

import java.sql.*;

public class JDBC_like_example {
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

            String sqlSelect = "SELECT * FROM employees WHERE name LIKE '%ko%'; ";
                                                    //wybiera elementy z lancuchem znakow "ko"
            resultSet = statement.executeQuery(sqlSelect); //wywolanie zapytania i pobranie wynikow

            while (resultSet.next() ) { //pobranie wartosci kolejnego wiersza 
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int salary = resultSet.getInt("salary");
                System.out.println("id: " +id+" name: " + name + " salary: " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close(); //zamykamy polaczenia w odwrotnej kolejnosci niz je tworzylismy
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
