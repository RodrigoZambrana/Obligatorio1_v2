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

    NodoLinea Primero;
    NodoLinea Ultimo;
    int cantaLineas;

    

    public ListaLineas() {
        this.Primero = null;
        this.Ultimo = null;
    }

    public NodoLinea getPrimero() {
        return Primero;
    }

    public void setPrimero(NodoLinea Primero) {
        this.Primero = Primero;
    }

    public NodoLinea getUltimo() {
        return Ultimo;
    }

    public void setUltimo(NodoLinea Ultimo) {
        this.Ultimo = Ultimo;
    }
    public int getCantaLineas() {
        return cantaLineas;
    }

    public void setCantaLineas(int cantaLineas) {
        this.cantaLineas = cantaLineas;
    }

    @Override
    public boolean esVacia() {
        return (this.Primero == null);
    }
    
     @Override
    public void insertarLinea() {//al inicio
        NodoLinea nuevo = new NodoLinea("");
        if (this.esVacia()) {
            this.Primero = nuevo;
            this.Ultimo = nuevo;
        } else {
            nuevo.siguiente = this.Primero;
            this.Primero = nuevo;
        }
    }

    @Override
    public void agregarInicio(Object dato) {
        NodoLinea nuevo = new NodoLinea(dato);
        if (this.esVacia()) {
            this.Primero = nuevo;
            this.Ultimo = nuevo;
        } else {
            nuevo.siguiente = this.Primero;
            this.Primero = nuevo;
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.Primero == this.Ultimo) {
                this.Primero = null;
                this.Ultimo = null;
            } else {
                this.Primero = this.Primero.siguiente;
            }
        }
    }

    @Override
    public boolean buscarelemento(Object dato) {
        NodoLinea aux = this.Primero;
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public void vaciar() {
        this.Primero = null;
        this.Ultimo = null;
    }

    @Override
    public void mostrar() {
        NodoLinea aux = this.Primero;
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.siguiente;
        }
    }

    @Override
    public void mostrarREC(NodoLinea l) {
        if (l != null) {
            System.out.print(l.getDato() + " - ");
            mostrarREC(l.siguiente);
        }
    }

    @Override
    public void agregarFinal(Object dato) {
        NodoLinea nuevo = new NodoLinea(dato);

        if (this.esVacia()) {
            this.agregarInicio(dato);
        } else {
            nuevo.siguiente = this.Primero;
            Primero.anterior = nuevo;
            this.Primero = nuevo;
            

        }

    }

    @Override
    public void borrarFin() {
        NodoLinea aux = this.getPrimero() ;
        if (this.esVacia() || this.Primero == this.Ultimo) {
            this.borrarInicio();

        } else {
            while (aux.getSiguiente() != this.Ultimo) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
    }

    @Override
    public void agregarOrd(Object dato) {
        
           if (this.esVacia() || (this.getPrimero().getDato().toString().compareTo(dato.toString())>0)) {
            this.agregarInicio(dato);
            return;
        }
        if (this.getUltimo().getDato().toString().compareTo(dato.toString()) < 0) {   //Ã¹ltimo elemento es menor o igual => agrego al final
            this.agregarFinal(dato);
            return;
        }
        NodoLinea aux = this.getPrimero();
        NodoLinea auxant = aux;
        NodoLinea nuevo = new NodoLinea(dato);
       
        while (aux != null && aux.getDato().toString().compareTo(dato.toString()) < 0) {
            auxant = aux;
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(auxant.getSiguiente());
        auxant.setSiguiente(nuevo);
    }


    @Override
    public NodoLinea obtenerElemento(Object n) {
        NodoLinea aux = this.Primero;
        while (aux != null) {
            if (aux.getDato() == n) {
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public int cantElementos() {
        NodoLinea aux = this.Ultimo;
        int cont=0;
        while (aux != null) {
            cont=cont+1;
            aux = aux.getAnterior();
        }   
        return cont;
    }

    @Override
    public void borrarElemento(Object n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
