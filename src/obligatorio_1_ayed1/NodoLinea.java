/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio_1_ayed1;

/**
 *
 * @author marti
 */
public class NodoLinea {
    Object dato;
    NodoLinea siguiente;
    NodoLinea anterior;
    ListaPalabras lp;
      
     public NodoLinea(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.lp = new ListaPalabras();
    }
   

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoLinea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLinea siguiente) {
        this.siguiente = siguiente;
    }
    
    public NodoLinea getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLinea anterior) {
        this.anterior = anterior;
    }

    public ListaPalabras getLp() {
        return lp;
    }

    public void setLp(ListaPalabras lp) {
        this.lp = lp;
    }
    
}
