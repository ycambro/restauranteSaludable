/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2.entidades;

import com.ycambro.tarea2.entidades.comidas.*;
import java.time.LocalDateTime;

/**
 *
 * @author yurgencm
 */
public class Registro {
    private String nombreOrden;
    private int tipo;
    private Object plato = null;
    private Acompannamiento acom = null;
    private Bebida bebida = null;
    private Postre postre = null;
    private Proteina proteina = null;
    private int costo;
    private LocalDateTime fechaCreacion;
    
    public Registro (String nombreOrden, int tipo, Object plato, int costo, LocalDateTime fechaCreacion) {
        this.nombreOrden = nombreOrden;
        this.tipo = tipo;
        this.plato = plato;
        this.costo = costo;
        this.fechaCreacion = fechaCreacion;
    }
    
    public Registro (String nombreOrden, int tipo, Acompannamiento acom, Bebida bebida, Postre postre, Proteina proteina, int costo, LocalDateTime fechaCreacion) {
        this.nombreOrden = nombreOrden;
        this.tipo = tipo;
        this.acom = acom;
        this.bebida = bebida;
        this.proteina = proteina;
        this.postre = postre;
        this.costo = costo;
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getNombreOrden () {
        return this.nombreOrden;
    }
    
    public int getTipo() {
        return this.tipo;
    }
    
    public Object getPlato() {
        return this.plato;
    }
    
    public Acompannamiento getAcompannamiento() {
        return this.acom;
    }
    
    public Bebida getBebida() {
        return this.bebida;
    }
    
    public Proteina getProteina() {
        return this.proteina;
    }
    
    public Postre getPostre() {
        return this.postre;
    }
    
    public int getCosto() {
        return this.costo;
    }
    
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setNombreOrden (String nombreOrden) {
        this.nombreOrden = nombreOrden;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public void setPlato(Object plato) {
        this.plato = plato;
    }
    
    public void setAcompannamiento(Acompannamiento acom) {
        this.acom = acom;
    }
    
    public void setProteina(Proteina proteina) {
        this.proteina = proteina;
    }
    
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
    
   public void setPostre(Postre postre) {
       this.postre = postre;
   }
   
   public void setCosto(int costo) {
       this.costo = costo;
   }
   
   public void setFechaOrden(LocalDateTime fechaOrden) {
       this.fechaCreacion = fechaOrden;
   }
}
