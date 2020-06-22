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
public class NodoArchivo {
    
    //String unidad;
    String nombre;
    NodoArchivo siguiente;
    NodoArchivo anterior; 
    ListaLineas li;

   

    public NodoArchivo(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
         this.li= new ListaLineas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoArchivo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArchivo siguiente) {
        this.siguiente = siguiente;
    }
    
    public NodoArchivo getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoArchivo anterior) {
        this.anterior = anterior;
    }
    
     public ListaLineas getLi() {
        return li;
    }

    public void setLi(ListaLineas li) {
        this.li = li;
    }
}
