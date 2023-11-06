/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ycambro.tarea2;

import com.ycambro.tarea2.bd.consultas.*;
import com.ycambro.tarea2.bd.*;
import com.ycambro.tarea2.entidades.comidas.*;
import com.ycambro.tarea2.entidades.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
    private Menu menu;
    private List<Mesa> mesas;
    private List<Registro> registros;
    
    public Aplicacion () {
        this.menu = new Menu(PlatosDAO.obtenerTodos());
        this.mesas = obtenerMesas();
        this.registros = RegistroDAO.obtenerTodos();
    }
    
    private List<Mesa> obtenerMesas(){
        List<Mesa> mesas = new ArrayList<>();
        for (int i = 0; i < 5; i ++) {
            Mesa mesa = new Mesa(i, 1);
            mesas.add(mesa);
        }
        return mesas;
    }
    
    public void cambiarDisponibilidadMesa(Mesa mesa) {
        mesas.set(mesa.getMesa(), mesa);
    }
    
    public Menu getMenu() {
        return this.menu;
    }
    
    public List<Registro> getRegistros() {
        return this.registros;
    }
    
    public List<Mesa> getMesas() {
        return this.mesas;
    }
    
    public int eliminarAcompannamiento(int acom) {
        List<Object> platos = this.menu.getPlatillos();
        for (Object plato : platos) {
            if (plato instanceof Plato) {
                Plato temp = (Plato) plato;
                if (temp.getAcompannamiento().getId() == acom) {
                    return -1;
                }
            } else if (plato instanceof PlatoBebida) {
                PlatoBebida temp = (PlatoBebida) plato;
                if (temp.getAcompannamiento().getId() == acom) {
                    return -1;
                }
            } else if (plato instanceof PlatoCompleto) {
                PlatoCompleto temp = (PlatoCompleto) plato;
                if (temp.getAcompannamiento().getId() == acom) {
                    return -1;
                }
            }
        }
        AcompannamientoDAO.eliminar(acom);
        return 0;
        
    }
    
    public int eliminarProteina(int prot) {
        List<Object> platos = this.menu.getPlatillos();
        for (Object plato : platos) {
            if (plato instanceof Plato) {
                Plato temp = (Plato) plato;
                if (temp.getProteina().getId() == prot) {
                    return -1;
                }
            } else if (plato instanceof PlatoBebida) {
                PlatoBebida temp = (PlatoBebida) plato;
                if (temp.getProteina().getId() == prot) {
                    return -1;
                }
            } else if (plato instanceof PlatoCompleto) {
                PlatoCompleto temp = (PlatoCompleto) plato;
                if (temp.getProteina().getId() == prot) {
                    return -1;
                }
            }
        }
        ProteinaDAO.eliminar(prot);
        return 0;
        
    }
    
    public int eliminarBebida(int bebi) {
        List<Object> platos = this.menu.getPlatillos();
        for (Object plato : platos) {
            if (plato instanceof PlatoBebida) {
                PlatoBebida temp = (PlatoBebida) plato;
                if (temp.getBebida().getId() == bebi) {
                    return -1;
                }
            } else if (plato instanceof PlatoCompleto) {
                PlatoCompleto temp = (PlatoCompleto) plato;
                if (temp.getBebida().getId() == bebi) {
                    return -1;
                }
            }
        }
        BebidaDAO.eliminar(bebi);
        return 0;
        
    }
    
    public int eliminarPostre(int postr) {
        List<Object> platos = this.menu.getPlatillos();
        for (Object plato : platos) {
            if (plato instanceof PlatoCompleto) {
                PlatoCompleto temp = (PlatoCompleto) plato;
                if (temp.getPostre().getId() == postr) {
                    return -1;
                }
            }
        }
        PostreDAO.eliminar(postr);
        return 0;
        
    }
    
    public void eliminarPlato(int plato) {
        PlatosDAO.eliminar(plato);
        this.menu.setPlatillos(PlatosDAO.obtenerTodos());
    }
    
    public void annadirAcom(Acompannamiento acom) {
        AcompannamientoDAO.insertar(acom);
    }
    
    public void annadirProteina(Proteina proteina) {
        ProteinaDAO.insertar(proteina);
    }
    
    public void annadirBebida(Bebida bebida) {
        BebidaDAO.insertar(bebida);
    }
    
    public void annadirPostre(Postre postre) {
        PostreDAO.insertar(postre);
    }
        
    public void annadirPlato(Object plato) {
        List<Object> platos = this.menu.getPlatillos();
        
        if (plato instanceof Plato) {
            Plato temp = (Plato) plato;
            PlatosDAO.insertarPlato(temp);
            platos.add(temp);
        } else if (plato instanceof PlatoBebida) {
            PlatoBebida temp = (PlatoBebida) plato;
            PlatosDAO.insertarPlatoBebida(temp);
            platos.add(temp);
        } else if (plato instanceof PlatoCompleto) {
            PlatoCompleto temp = (PlatoCompleto) plato;
            PlatosDAO.insertarPlatoCompleto(temp);
            platos.add(temp);
        }
        this.menu.setPlatillos(platos);
    }
    
    public void annadirRegistro(Registro registro) {
        RegistroDAO.insertarRegistroTipo1(registro);
        this.registros = RegistroDAO.obtenerTodos();
        
    }
    
    public void actualizarAcom(Acompannamiento acom) {
        AcompannamientoDAO.modificar(acom);
    }
    
    public void actualizarProteina(Proteina prote) {
        ProteinaDAO.modificar(prote);
    }
    
    public void actualizarBebida(Bebida bebida) {
        BebidaDAO.modificar(bebida);
    }
    
    public void actualizarPostre(Postre postre) {
        PostreDAO.modificar(postre);
    }
    
    public void actualizarPlato(Object plato, int precio) {
        if (plato instanceof Plato tmp) {
            tmp.setPrecio(precio);
            PlatosDAO.modificarPlato(tmp);
            this.menu.setPlatillos(PlatosDAO.obtenerTodos());
        } else if (plato instanceof PlatoBebida tmp) {
            tmp.setPrecio(precio);
            PlatosDAO.modificarPlato(tmp);
            this.menu.setPlatillos(PlatosDAO.obtenerTodos());
        } else if (plato instanceof PlatoCompleto tmp) {
            tmp.setPrecio(precio);
            PlatosDAO.modificarPlato(tmp);
            this.menu.setPlatillos(PlatosDAO.obtenerTodos());
        }
    }
    
    
    
}
