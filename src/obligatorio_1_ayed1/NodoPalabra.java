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
public class NodoPalabra {

    NodoPalabra Anterior;
    NodoPalabra Siguiente;
    String palabra;

    public NodoPalabra(String palabra) {
        this.palabra = palabra;
    }

    public NodoPalabra getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoPalabra Ultimo) {
        this.Siguiente = Ultimo;
    }

    public NodoPalabra getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoPalabra Anterior) {
        this.Anterior = Anterior;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

}
