/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author yurgencm
 */
public class Orden {
    private String identificador;
    private int mesa;
    private int tipoPago;
    private List<Persona> pedidos;
    private LocalDateTime fechaOrden;
    
    public Orden(String identificador, int mesa, int tipoPago, List<Persona> pedidos) {
        this.identificador = identificador;
        this.mesa = mesa;
        this.tipoPago = tipoPago;
        this.pedidos = pedidos;
        this.fechaOrden = LocalDateTime.now();
    }
    
    public String getIdentificador() {
        return this.identificador;
    }
    
    public int getMesa() {
        return this.mesa;
    }
    
    public int getTipoPago() {
        return this.tipoPago;
    }
    
    public List<Persona> getPersonas() {
        return this.pedidos;
    }
    
    public LocalDateTime getFechaOrden() {
        return this.fechaOrden;
    }
    
    public void setIdentificador(String id) {
        this.identificador = id;
    }
    
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    public void setPersonas(List<Persona> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void setFechaOrden(LocalDateTime fecha) {
        this.fechaOrden = fecha;
    }
}
