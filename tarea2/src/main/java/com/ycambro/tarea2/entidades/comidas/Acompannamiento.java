/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Acompannamiento extends Comida {
    private String tipo;
    private String temperatura;
    private String gluten;
    
    public Acompannamiento(int id, String nombre, int calorias, int precio, String tipo, String gluten, String temperatura) {
        super(id, nombre, calorias, precio);
        this.tipo = tipo;
        this.gluten = gluten;
        this.temperatura = temperatura;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public String getGluten() {
        return this.gluten;
    }
    
    public String getTemperatura() {
        return this.temperatura;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setGluten(String gluten) {
        this.gluten = gluten;
    }
    
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
