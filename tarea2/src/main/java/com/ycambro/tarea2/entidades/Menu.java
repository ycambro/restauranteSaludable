/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades;

import java.util.List;

public class Menu {
    private List<Object> platillos;
    
    public Menu (List<Object> platillos) {
        this.platillos = platillos;
    }
    
    public List<Object> getPlatillos() {
        return this.platillos;
    }
    
    public void setPlatillos (List<Object> platillos) {
        this.platillos = platillos;
    }
}
