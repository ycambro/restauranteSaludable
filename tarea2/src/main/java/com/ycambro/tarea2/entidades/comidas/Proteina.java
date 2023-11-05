/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Proteina extends Comida {
    private String tipo;
    private String origen;
    private String preparacion;
    
    public Proteina(int id, String nombre, int calorias, int precio, String tipo, String origen, String preparacion) {
        super(id, nombre, calorias, precio);
        this.tipo = tipo;
        this.origen = origen;
        this.preparacion = preparacion;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public String getOrigen() {
        return this.origen;
    }
    
    public String getPreparacion() {
        return this.preparacion;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
    
}
