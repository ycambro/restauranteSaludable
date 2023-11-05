/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd;

/**
 *
 * @author yurgencm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/restauranteSaludable?serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String contrasenna = "JUanluis1616*";
    
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(jdbcUrl, usuario, contrasenna);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
