/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades;

public class Mesa {
    private int numeroMesa;
    private int disponible;
    
    public Mesa (int numeroMesa, int disponible) {
        this.numeroMesa = numeroMesa;
        this.disponible = disponible;
    }
    
    public int getMesa() {
        return this.numeroMesa;
    }
    
    public int getDisponibilidad () {
        return this.disponible;
    }
    
    public void setNumeroMesa (int num) {
        this.numeroMesa = num;
    }
    
    public void setDisponibilidad (int disp) {
        this.disponible = disp;
    }
}
