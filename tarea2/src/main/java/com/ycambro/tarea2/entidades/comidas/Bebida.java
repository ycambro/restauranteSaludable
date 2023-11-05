/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Bebida extends Comida {
    private String tipo;
    private String base;
    private String temperatura;
    
    public Bebida(int id, String nombre, int calorias, int precio, String tipo, String base, String temperatura) {
        super(id, nombre, calorias, precio);
        this.tipo = tipo;
        this.base = base;
        this.temperatura = temperatura;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public String getBase() {
        return this.base;
    }
    
    public String getTemperatura() {
        return this.temperatura;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setBase(String base) {
        this.base = base;
    }
    
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}