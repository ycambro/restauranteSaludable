/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Comida {
    private int id;
    private String nombre;
    private int calorias;
    private int precio;
    
    public Comida (int id, String nombre, int calorias, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.precio = precio;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getCalorias() {
        return this.calorias;
    }
    
    public int getPrecio() {
        return this.precio;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
