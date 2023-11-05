/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.comidas.Postre;
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
public class PostreDAO {
    public static List<Postre> obtenerTodos() {
        List<Postre> postres = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM Postre")) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String lacteo = resultado.getString("lacteo");
                String base = resultado.getString("base");
                int calorias = resultado.getInt("calorias");
                int precio = resultado.getInt("precio");
                Postre postre = new Postre(id, nombre, calorias, precio, tipo, base, lacteo);
                postres.add(postre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postres;
    }
     
    public static Postre obtenerPorId(int id) {
        Postre postre = null;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Postre WHERE id = ?")) {

            statement.setInt(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String tipo = resultado.getString("tipo");
                    String base = resultado.getString("base");
                    String lacteo = resultado.getString("lacteo");
                    int calorias = resultado.getInt("calorias");
                    int precio = resultado.getInt("precio");

                    postre = new Postre(id, nombre, calorias, precio, tipo, base, lacteo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postre;
    }
    
    public static void insertar(Postre postre) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Postre (nombre, tipo, lacteo, base, calorias, precio) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, postre.getNombre());
            statement.setString(2, postre.getTipo());
            statement.setString(3, postre.getLacteo());
            statement.setString(4, postre.getBase());
            statement.setInt(5, postre.getCalorias());
            statement.setInt(6, postre.getPrecio());
            statement.setInt(7, postre.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificar(Postre postre) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Postre SET nombre = ?, tipo = ?, lacteo = ?, base = ?, calorias = ?, precio = ? WHERE id = ?")) {

            statement.setString(1, postre.getNombre());
            statement.setString(2, postre.getTipo());
            statement.setString(3, postre.getLacteo());
            statement.setString(4, postre.getBase());
            statement.setInt(5, postre.getCalorias());
            statement.setInt(6, postre.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("DELETE FROM Postre WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
