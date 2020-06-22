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
    int numeroLinea;
    ListaPalabras lp;
    NodoLinea siguiente;
    NodoLinea anterior;
    
    public NodoLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
        this.lp = new ListaPalabras();
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public ListaPalabras getLp() {
        return lp;
    }

    public void setLp(ListaPalabras lp) {
        this.lp = lp;
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
    
}
