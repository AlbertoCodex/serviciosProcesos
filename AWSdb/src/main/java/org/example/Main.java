package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<String> subscribers = new ArrayList<>();

    public static void main(String[] args) {

    }
    public List<String> handleRequest(){
        // Añadir endpoint DB
        String jdbcURL="jdbc:postgresql://   :5423/DATABASENAME";
        try {
            // Cambiar USER y PASSWORD
            Connection conn = DriverManager.getConnection(jdbcURL,"", "");
            if (!conn.isValid(0)){
                System.out.println("No es posible la conexion" + jdbcURL);
                System.exit(0);
            }
            // Añadir tabla
            PreparedStatement selectStatement = conn.prepareStatement("select * from TABLE");
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
                subscribers.add(nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscribers;
    }
}