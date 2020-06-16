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
public class ListaArchivos implements IListaArchivos{
    NodoArchivo primero;
    NodoArchivo ultimo;

    public ListaArchivos() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoArchivo getPrimero() {
        return primero;
    }

    public void setPrimero(NodoArchivo primero) {
        this.primero = primero;
    }

    public NodoArchivo getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoArchivo ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public boolean esVacia() {
        return this.primero==null;
    }

    @Override
    public void agregarInicio(String nombre) {
        NodoArchivo nuevo = new NodoArchivo(nombre);
        
        if (this.esVacia()) {
            this.primero=nuevo;
            this.ultimo=nuevo;
        }
        else{
            nuevo.siguiente=this.primero;
            this.primero=nuevo;
        }
    }

    @Override
    public void agregarFinal(String nombre) {
        NodoArchivo nuevo = new NodoArchivo(nombre);
        
        if(this.esVacia())
            this.agregarInicio(nombre);
        else{
            ultimo.siguiente=nuevo;
            ultimo=nuevo;
        }
    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarelemento(String nombre) {
        NodoArchivo aux=this.primero;
        while (aux!=null) {            
            if (aux.getNombre()==nombre) {
                return true;
            }
            aux=aux.siguiente;
        }
        return false;
    }

    @Override
    public void vaciar() {
        this.primero=null;
        this.ultimo=null;
    }

    @Override
    public void mostrar() {
        NodoArchivo aux = this.primero;
        while (aux!=null) {            
            aux=aux.siguiente;
        }
    }

    @Override
    public NodoCarpeta obtenercarpeta(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
