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
public class ListaLineas implements IListaLineas{

    NodoLinea primero;
    NodoLinea ultimo;

    public ListaLineas() {
        this.primero = new NodoLinea(0);
        this.ultimo = new NodoLinea(0);
    }

    public NodoLinea getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLinea primero) {
        this.primero = primero;
    }

    public NodoLinea getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLinea ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public void agregarFinal() {
        NodoLinea nuevo = new NodoLinea(ultimo.numeroLinea++);
        if (this.esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
            this.setUltimo(nuevo);
        }
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }
}
