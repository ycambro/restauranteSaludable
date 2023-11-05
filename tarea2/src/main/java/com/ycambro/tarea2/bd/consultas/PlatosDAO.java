/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.comidas.*;
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
public class PlatosDAO {
    public static List<Object> obtenerTodos() {
        List<Object> platos = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM Platos")) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                int tipo = resultado.getInt("tipo");
                int acompannamientoid = resultado.getInt("acompannamiento_id");
                int proteinaid = resultado.getInt("proteina_id");
                int bebidaid = resultado.getInt("bebida_id");
                int postreid = resultado.getInt("postre_id");
                int calorias = resultado.getInt("caloria");
                int precio = resultado.getInt("precio");
                String en_caloria = resultado.getString("en_caloria");
                String vegetariano = resultado.getString("vegetariano");
                String horario = resultado.getString("horario");
                
                Acompannamiento acom = AcompannamientoDAO.obtenerPorId(acompannamientoid);
                Proteina proteina = ProteinaDAO.obtenerPorId(proteinaid);
                    
                if (tipo == 1) {
                    Plato plato = new Plato(id, nombre, tipo, acom, proteina, calorias, precio, en_caloria, vegetariano, horario);
                    platos.add(plato);
                } else if (tipo == 2) {
                    Bebida bebida = BebidaDAO.obtenerPorId(bebidaid);
                    PlatoBebida plato = new PlatoBebida(id, nombre, tipo, acom, proteina, bebida, calorias, precio, en_caloria, vegetariano, horario);
                    platos.add(plato);
                } else if (tipo == 3) {
                    Bebida bebida = BebidaDAO.obtenerPorId(bebidaid);
                    Postre postre = PostreDAO.obtenerPorId(postreid);
                    PlatoCompleto plato = new PlatoCompleto(id, nombre, tipo, acom, proteina, bebida, postre, calorias, precio, en_caloria, vegetariano, horario);
                    platos.add(plato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platos;
    }
     
    public static Object obtenerPorId(int id) {
        Object plato = null;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Platos WHERE id = ?")) {

            statement.setInt(1, id);
            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    int tipo = resultado.getInt("tipo");
                    int acompannamientoid = resultado.getInt("acompannamiento_id");
                    int proteinaid = resultado.getInt("proteina_id");
                    int bebidaid = resultado.getInt("bebida_id");
                    int postreid = resultado.getInt("postre_id");
                    int calorias = resultado.getInt("caloria");
                    int precio = resultado.getInt("precio");
                    String en_caloria = resultado.getString("en_caloria");
                    String vegetariano = resultado.getString("vegetariano");
                    String horario = resultado.getString("horario");
                    
                    Acompannamiento acom = AcompannamientoDAO.obtenerPorId(acompannamientoid);
                    Proteina proteina = ProteinaDAO.obtenerPorId(proteinaid);

                    if (tipo == 1) {
                        plato = new Plato(id, nombre, tipo, acom, proteina, calorias, precio, en_caloria, vegetariano, horario);
                    } else if (tipo == 2) {
                        Bebida bebida = BebidaDAO.obtenerPorId(bebidaid);
                        plato = new PlatoBebida(id, nombre, tipo, acom, proteina, bebida, calorias, precio, en_caloria, vegetariano, horario);
                    } else if (tipo == 3) {
                        Bebida bebida = BebidaDAO.obtenerPorId(bebidaid);
                        Postre postre = PostreDAO.obtenerPorId(postreid);
                        plato = new PlatoCompleto(id, nombre, tipo, acom, proteina, bebida, postre, calorias, precio, en_caloria, vegetariano, horario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plato;
    }
    
    public static void insertarPlato(Plato plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Platos (nombre, tipo, acompannamiento_id, proteina_id, bebida_id, postre_id, caloria, precio, en_caloria, vegetariano, horario) VALUES (?, ?, ?, ?, NULL, NULL, ?, ?, ?, ?, ?)")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getCaloria());
            statement.setInt(6, plato.getPrecio());
            statement.setString(7, plato.getEnCaloria());
            statement.setString(8, plato.getVegetariano());
            statement.setString(9, plato.getHorario());
            statement.setInt(10, plato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarPlatoBebida(PlatoBebida plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Platos (nombre, tipo, acompannamiento_id, proteina_id, bebida_id, postre_id, caloria, precio, en_caloria, vegetariano, horario) VALUES (?, ?, ?, ?, ?, NULL, ?, ?, ?, ?, ?)")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getBebida().getId());
            statement.setInt(6, plato.getCaloria());
            statement.setInt(7, plato.getPrecio());
            statement.setString(8, plato.getEnCaloria());
            statement.setString(9, plato.getVegetariano());
            statement.setString(10, plato.getHorario());
            statement.setInt(11, plato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarPlatoCompleto(PlatoCompleto plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO Platos (nombre, tipo, acompannamiento_id, proteina_id, bebida_id, postre_id, caloria, precio, en_caloria, vegetariano, horario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getBebida().getId());
            statement.setInt(6, plato.getPostre().getId());
            statement.setInt(7, plato.getCaloria());
            statement.setInt(8, plato.getPrecio());
            statement.setString(9, plato.getEnCaloria());
            statement.setString(10, plato.getVegetariano());
            statement.setString(11, plato.getHorario());
            statement.setInt(12, plato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificarPlato(Plato plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Plato SET nombre = ?, tipo = ?, acompannamiento_id = ?, proteina_id = ?, bebida_id = NULL, postre_id = NULL, caloria = ?, precio = ?, en_caloria = ?, vegetariano = ?, horario = ? WHERE id = ?")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getCaloria());
            statement.setInt(6, plato.getPrecio());
            statement.setString(7, plato.getEnCaloria());
            statement.setString(8, plato.getVegetariano());
            statement.setString(9, plato.getHorario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void modificarPlatoBebida(PlatoBebida plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Plato SET nombre = ?, tipo = ?, acompannamiento_id = ?, proteina_id = ?, bebida_id = ?, postre_id = NULL, caloria = ?, precio = ?, en_caloria = ?, vegetariano = ?, horario = ? WHERE id = ?")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getBebida().getId());
            statement.setInt(6, plato.getCaloria());
            statement.setInt(7, plato.getPrecio());
            statement.setString(8, plato.getEnCaloria());
            statement.setString(9, plato.getVegetariano());
            statement.setString(10, plato.getHorario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void modificarPlatoCompleto(PlatoCompleto plato) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("UPDATE Plato SET nombre = ?, tipo = ?, acompannamiento_id = ?, proteina_id = ?, bebida_id = ?, postre_id = ?, caloria = ?, precio = ?, en_caloria = ?, vegetariano = ?, horario = ? WHERE id = ?")) {

            statement.setString(1, plato.getNombre());
            statement.setInt(2, plato.getTipo());
            statement.setInt(3, plato.getAcompannamiento().getId());
            statement.setInt(4, plato.getProteina().getId());
            statement.setInt(5, plato.getBebida().getId());
            statement.setInt(6, plato.getPostre().getId());
            statement.setInt(7, plato.getCaloria());
            statement.setInt(8, plato.getPrecio());
            statement.setString(9, plato.getEnCaloria());
            statement.setString(10, plato.getVegetariano());
            statement.setString(11, plato.getHorario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("DELETE FROM Platos WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
