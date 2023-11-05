/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Postre extends Comida {
    private String tipo;
    private String base;
    private String lacteo;
    
    public Postre(int id, String nombre, int calorias, int precio, String tipo, String base, String lacteo) {
        super(id, nombre, calorias, precio);
        this.tipo = tipo;
        this.base = base;
        this.lacteo = lacteo;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public String getBase() {
        return this.base;
    }
    
    public String getLacteo() {
        return this.lacteo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setBase(String base) {
        this.base = base;
    }
    
    public void setLacteo(String lacteo) {
        this.lacteo = lacteo;
    }
}
