/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.bd.consultas;

import com.ycambro.tarea2.bd.ConexionBD;
import com.ycambro.tarea2.entidades.Registro;
import com.ycambro.tarea2.entidades.comidas.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurgencm
 */
public class RegistroDAO {
    public static List<Registro> obtenerTodos() {
        List<Registro> registros = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery("SELECT * FROM RegistroOrden")) {

            while (resultado.next()) {
                String nombre = resultado.getString("nombreOrden");
                int tipo = resultado.getInt("tipo");
                int acompannamientoid = resultado.getInt("acompannamiento_id");
                int proteinaid = resultado.getInt("proteina_id");
                int bebidaid = resultado.getInt("bebida_id");
                int postreid = resultado.getInt("postre_id");
                int platoid = resultado.getInt("plato_id");
                Timestamp timestamp = resultado.getTimestamp("fecha_orden");
                int costo = resultado.getInt("costo");
                LocalDateTime fechaOrden = timestamp.toLocalDateTime();
                
                
                if (tipo == 1) {
                    Object plato = PlatosDAO.obtenerPorId(platoid);
                    Registro registro = new Registro(nombre, tipo, plato, costo, fechaOrden);
                    registros.add(registro);
                } else if (tipo == 2) {
                    Acompannamiento acom = AcompannamientoDAO.obtenerPorId(acompannamientoid);
                    Proteina proteina = ProteinaDAO.obtenerPorId(proteinaid);
                    Bebida bebida = BebidaDAO.obtenerPorId(bebidaid);
                    Postre postre = PostreDAO.obtenerPorId(postreid);
                    Registro registro = new Registro(nombre, tipo, acom, bebida, postre, proteina, costo, fechaOrden);
                    registros.add(registro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }
    
    public static void insertarRegistroTipo1(Registro registro) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO RegistroOrden (nombreOrden, tipo, plato_id, acompannamiento_id, proteina_id, bebida_id, postre_id, costo, fecha_orden) VALUES (?, ?, ?, NULL, NULL, NULL, NULL, ?, ?)")) {

            statement.setString(1, registro.getNombreOrden());
            statement.setInt(2, registro.getTipo());
            if (registro.getPlato() instanceof Plato) {
                Plato temp = (Plato) registro.getPlato();
                statement.setInt(3, temp.getId());
            } else if (registro.getPlato() instanceof PlatoBebida) {
                PlatoBebida temp = (PlatoBebida) registro.getPlato();
                statement.setInt(3, temp.getId());
            } else {
                PlatoCompleto temp = (PlatoCompleto) registro.getPlato();
                statement.setInt(3, temp.getId());
            }
            statement.setInt(4, registro.getCosto());
            statement.setObject(5, registro.getFechaCreacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertarRegistroTipo2(Registro registro) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO RegistroOrden (nombreOrden, tipo, plato_id, acompannamiento_id, proteina_id, bebida_id, postre_id, costo, fecha_orden) VALUES (?, ?, NULL, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, registro.getNombreOrden());
            statement.setInt(2, registro.getTipo());
            statement.setInt(3, registro.getAcompannamiento().getId());
            statement.setInt(4, registro.getProteina().getId());
            statement.setInt(5, registro.getBebida().getId());
            statement.setInt(6, registro.getPostre().getId());
            statement.setInt(7, registro.getCosto());
            statement.setObject(8, registro.getFechaCreacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
