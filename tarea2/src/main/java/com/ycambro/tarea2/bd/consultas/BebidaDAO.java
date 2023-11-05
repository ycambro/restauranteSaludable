/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.comidas.Bebida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurgencm
 */
public class BebidaDAO {
    
    public static List<Bebida> obtenerTodos() {
        List<Bebida> bebidas = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM Bebida")) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String base = resultado.getString("base");
                String temperatura = resultado.getString("temperatura");
                int calorias = resultado.getInt("calorias");
                int precio = resultado.getInt("precio");
                Bebida bebida = new Bebida(id, nombre, calorias, precio, tipo, base, temperatura);
                bebidas.add(bebida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bebidas;
    }
     
    public static Bebida obtenerPorId(int id) {
        Bebida bebida = null;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Bebida WHERE id = ?")) {

            statement.setInt(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String tipo = resultado.getString("tipo");
                    String base = resultado.getString("base");
                    String temperatura = resultado.getString("temperatura");
                    int calorias = resultado.getInt("calorias");
                    int precio = resultado.getInt("precio");

                    bebida = new Bebida(id, nombre, calorias, precio, tipo, base, temperatura);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bebida;
    }
    
    public static void insertar(Bebida bebida) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Bebida (nombre, tipo, base, temperatura, calorias, precio) VALUES (?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, bebida.getNombre());
            statement.setString(2, bebida.getTipo());
            statement.setString(3, bebida.getBase());
            statement.setString(4, bebida.getTemperatura());
            statement.setInt(5, bebida.getCalorias());
            statement.setInt(6, bebida.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificar(Bebida bebida) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Bebida SET nombre = ?, tipo = ?, base = ?, temperatura = ?, calorias = ?, precio = ? WHERE id = ?")) {

            statement.setString(1, bebida.getNombre());
            statement.setString(2, bebida.getTipo());
            statement.setString(3, bebida.getBase());
            statement.setString(4, bebida.getTemperatura());
            statement.setInt(5, bebida.getCalorias());
            statement.setInt(6, bebida.getPrecio());
            statement.setInt(7, bebida.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("DELETE FROM Bebida WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
