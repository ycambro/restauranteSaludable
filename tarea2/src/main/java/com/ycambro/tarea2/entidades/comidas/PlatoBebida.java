/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

public class PlatoBebida extends Plato {
    private Bebida bebida;
    
    public PlatoBebida(int id, String nombre, int tipo, Acompannamiento acom, Proteina proteina, Bebida bebida, int caloria, int precio, String en_caloria, String vegetariano, String horario) {
        super(id, nombre, tipo, acom, proteina, caloria, precio, en_caloria, vegetariano, horario);
        this.bebida = bebida;
    }
    
    public Bebida getBebida() {
        return this.bebida;
    }
    
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
