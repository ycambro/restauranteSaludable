/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades.comidas;

public class PlatoCompleto extends Plato {
    private Bebida bebida;
    private Postre postre;
    
    public PlatoCompleto(int id, String nombre, int tipo, Acompannamiento acom, Proteina proteina, Bebida bebida, Postre postre, int caloria, int precio, String en_caloria, String vegetariano, String horario) {
        super(id, nombre, tipo, acom, proteina, caloria, precio, en_caloria, vegetariano, horario);
        this.bebida = bebida;
        this.postre = postre;
    }
    
    public Bebida getBebida() {
        return this.bebida;
    }
    
    public Postre getPostre() {
        return this.postre;
    }
    
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
    
    public void setPostre(Postre postre) {
        this.postre = postre;
    }
}
