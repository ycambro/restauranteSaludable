/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.comidas.Acompannamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurgencm
 */
public class AcompannamientoDAO {
    public static List<Acompannamiento> obtenerTodos() {
        List<Acompannamiento> acompannamientos = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM Acompannamiento")) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String base = resultado.getString("gluten");
                String temperatura = resultado.getString("temperatura");
                int calorias = resultado.getInt("calorias");
                int precio = resultado.getInt("precio");
                Acompannamiento acompannamiento = new Acompannamiento(id, nombre, calorias, precio, tipo, base, temperatura);
                acompannamientos.add(acompannamiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acompannamientos;
    }
     
    public static Acompannamiento obtenerPorId(int id) {
        Acompannamiento acompannamiento = null;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Acompannamiento WHERE id = ?")) {

            statement.setInt(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String tipo = resultado.getString("tipo");
                    String gluten = resultado.getString("gluten");
                    String temp = resultado.getString("temperatura");
                    int calorias = resultado.getInt("calorias");
                    int precio = resultado.getInt("precio");

                    acompannamiento = new Acompannamiento(id, nombre, calorias, precio, tipo, gluten, temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acompannamiento;
    }
    
    public static void insertar(Acompannamiento acompannamiento) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Acompannamiento (nombre, tipo, gluten, temperatura, calorias, precio) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, acompannamiento.getNombre());
            statement.setString(2, acompannamiento.getTipo());
            statement.setString(3, acompannamiento.getGluten());
            statement.setString(4, acompannamiento.getTemperatura());
            statement.setInt(5, acompannamiento.getCalorias());
            statement.setInt(6, acompannamiento.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificar(Acompannamiento acompannamiento) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Acompannamiento SET nombre = ?, tipo = ?, gluten = ?, temperatura = ?, calorias = ?, precio = ? WHERE id = ?")) {

            statement.setString(1, acompannamiento.getNombre());
            statement.setString(2, acompannamiento.getTipo());
            statement.setString(3, acompannamiento.getGluten());
            statement.setString(4, acompannamiento.getTemperatura());
            statement.setInt(5, acompannamiento.getCalorias());
            statement.setInt(6, acompannamiento.getPrecio());
            statement.setInt(7, acompannamiento.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("DELETE FROM Acompannamiento WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
