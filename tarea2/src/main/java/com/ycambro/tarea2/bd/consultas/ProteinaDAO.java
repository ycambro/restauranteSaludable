/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.comidas.Proteina;
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
public class ProteinaDAO {
    public static List<Proteina> obtenerTodos() {
        List<Proteina> proteinas = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM Proteina")) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String origen = resultado.getString("origen");
                String preparacion = resultado.getString("preparación");
                int calorias = resultado.getInt("calorias");
                int precio = resultado.getInt("precio");
                Proteina proteina = new Proteina(id, nombre, calorias, precio, tipo, origen, preparacion);
                proteinas.add(proteina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proteinas;
    }
     
    public static Proteina obtenerPorId(int id) {
        Proteina proteina = null;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Proteina WHERE id = ?")) {

            statement.setInt(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String tipo = resultado.getString("tipo");
                    String origen = resultado.getString("origen");
                    String preparacion = resultado.getString("preparación");
                    int calorias = resultado.getInt("calorias");
                    int precio = resultado.getInt("precio");

                    proteina = new Proteina(id, nombre, calorias, precio, tipo, origen, preparacion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proteina;
    }
    
    public static void insertar(Proteina proteina) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Proteina (nombre, tipo, origen, preparación, calorias, precio) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, proteina.getNombre());
            statement.setString(2, proteina.getTipo());
            statement.setString(3, proteina.getOrigen());
            statement.setString(4, proteina.getPreparacion());
            statement.setInt(5, proteina.getCalorias());
            statement.setInt(6, proteina.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificar(Proteina proteina) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Proteina SET nombre = ?, tipo = ?, origen = ?, preparación = ?, calorias = ?, precio = ? WHERE id = ?")) {

            statement.setString(1, proteina.getNombre());
            statement.setString(2, proteina.getTipo());
            statement.setString(3, proteina.getOrigen());
            statement.setString(4, proteina.getPreparacion());
            statement.setInt(5, proteina.getCalorias());
            statement.setInt(6, proteina.getPrecio());
            statement.setInt(7, proteina.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("DELETE FROM Proteina WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
