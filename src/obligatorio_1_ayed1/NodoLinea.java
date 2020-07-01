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
    //static int nro = 1;
    int numeroLinea;
    NodoLinea siguiente;
    NodoLinea anterior;
    ListaPalabras lp;
      
     public NodoLinea(int numeroLinea) {
        //this.numeroLinea = NodoLinea.nro++;
        this.lp = new ListaPalabras();
        this.numeroLinea = numeroLinea;
        this.siguiente = null;
        this.lp = new ListaPalabras();
    }

//    public static int getNro() {
//        return nro;
//    }
//
//    public static void setNro(int nro) {
//        NodoLinea.nro = nro;
//    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
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
