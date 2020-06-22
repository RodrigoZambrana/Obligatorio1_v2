/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_1_ayed1;

/**
 *
 * @author rodrigo
 */

public class NodoUnidad {

     String nombreUnidad;
     NodoUnidad Primero;
     NodoUnidad Siguiente;
     NodoUnidad Anterior;

     ListaCarpetas lc;

    public NodoUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
        this.Primero = null;
        this.Siguiente = null;
        this.lc = new ListaCarpetas();
    }

    public NodoUnidad getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoUnidad Anterior) {
        this.Anterior = Anterior;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }


    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public NodoUnidad getPrimero() {
        return Primero;
    }

    public void setPrimero(NodoUnidad Primero) {
        this.Primero = Primero;
    }

    public NodoUnidad getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoUnidad Siguiente) {
        this.Siguiente = Siguiente;
    }

    public ListaCarpetas getLc() {
        return lc;
    }

    public void setLc(ListaCarpetas lc) {
        this.lc = lc;
    }

    
}
