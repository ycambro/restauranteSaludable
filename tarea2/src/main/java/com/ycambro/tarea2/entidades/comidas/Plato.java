/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

/**
 *
 * @author yurgencm
 */
public class Plato {
    private int id;
    private String nombre;
    private int tipo;
    private Acompannamiento acom;
    private Proteina proteina;
    private int caloria;
    private int precio;
    private String en_caloria;
    private String vegetariano;
    private String horario;
    
    public Plato (int id, String nombre, int tipo, Acompannamiento acom, Proteina proteina, int caloria, int precio, String en_caloria, String vegetariano, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.acom = acom;
        this.proteina = proteina;
        this.caloria = caloria;
        this.precio = precio;
        this.en_caloria = en_caloria;
        this.vegetariano = vegetariano;
        this.horario = horario;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public Acompannamiento getAcompannamiento() {
        return this.acom;
    }
    
    public Proteina getProteina() {
        return this.proteina;
    }
    
    public int getCaloria() {
        return this.caloria;
    }
    
    public int getPrecio() {
        return this.precio;
    }
    
    public String getEnCaloria() {
        return this.en_caloria;
    }
    
    public String getVegetariano() {
        return this.vegetariano;
    }
    
    public String getHorario() {
        return this.horario;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public void setAcompannamiento(Acompannamiento acompannamiento) {
        this.acom = acompannamiento;
    }
    
    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }
    
    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public void getEnCaloria(String en_caloria) {
        this.en_caloria = en_caloria;
    }
    
    public void getVegetariano(String vegetariano) {
        this.vegetariano = vegetariano;
    }
    
    public void getHorario(String horario) {
        this.horario = horario;
    }
}
