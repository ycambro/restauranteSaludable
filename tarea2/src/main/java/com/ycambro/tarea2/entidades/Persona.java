/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades;

/**
 *
 * @author yurgencm
 */
public class Persona {
    private Object plato;
    private int tipo;
    private int id;
    
    public Persona (Object plato, int id, int tipo) {
        this.plato = plato;
        this.tipo = tipo;
        this.id = id;
    }
    
    public Object getPlato() {
        return this.plato;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setPlato(Object plato) {
        this.plato = plato;
    }
    
    public void setTipo (int tipo) {
        this.tipo = tipo;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
