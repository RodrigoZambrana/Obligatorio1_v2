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
public class ListaPalabras implements IListaPalabras {

    NodoPalabra primero;
    NodoPalabra ultimo;
    int cantPalabras;

    public ListaPalabras() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoPalabra getPrimero() {
        return primero;
    }

    public void setPrimero(NodoPalabra primero) {
        this.primero = primero;
    }

    public NodoPalabra getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoPalabra ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantPalabras() {
        return cantPalabras;
    }

    public void setCantPalabras(int cantPalabras) {
        this.cantPalabras = cantPalabras;
    }

    @Override
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public int cantElementos() {
        NodoPalabra aux = this.ultimo;
        int cont = 0;
        while (aux != null) {
            cont = cont + 1;
            aux = aux.getAnterior();
        }
        return cont;
    }

    @Override
    public boolean esVacia() {
        return (this.primero == null);
    }

    @Override
    public void agregarInicio(String dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);
        if (this.esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            this.primero.setAnterior(nuevo);
            this.setPrimero(nuevo);
        }

    }

    @Override
    public void agregarFinal(String dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);
        if (this.esVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;

        }

    }

    @Override
    public void agregarOrd(String n) {

        if (this.esVacia() || (this.getPrimero().getPalabra().compareTo(n) > 0)) {
            this.agregarInicio(n);
            return;
        }
        if (this.getUltimo().getPalabra().compareTo(n) < 0) {   //Ã¹ltimo elemento es menor o igual => agrego al final
            this.agregarFinal(n);
            return;
        }
        NodoPalabra aux = this.getPrimero();
        NodoPalabra auxant = aux;
        NodoPalabra nuevo = new NodoPalabra(n);

        while (aux != null && aux.getPalabra().compareTo(n) < 0) {
            auxant = aux;
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(auxant.getSiguiente());
        auxant.setSiguiente(nuevo);
    }
    
   

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.primero == this.ultimo) {
                this.vaciar();
            } else {
                this.primero = this.primero.getSiguiente();
                this.primero.setAnterior(null);
            }
        }
    }

    @Override
    public void borrarFin() {

        this.ultimo = this.ultimo.getAnterior();
        this.ultimo.setSiguiente(null);

    }

    @Override
    public void borrarElemento(String n) {
        NodoPalabra aux = obtenerElemento(n);
        if (this.primero.palabra.equals(n)) {
            this.borrarInicio();
        } else {
            if (this.ultimo.getPalabra().toString().equals(n)) {
                this.borrarFin();
            } else {
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
            }
        }
    }

    @Override
    public boolean buscarelemento(String dato) {
        NodoPalabra aux = this.primero;
        while (aux != null) {
            if (aux.getPalabra() == dato) {
                return true;
            }

            aux = aux.getSiguiente();
        }
        return false;

    }

    // El elemento existe
    @Override
    public NodoPalabra obtenerElemento(String n) {
        NodoPalabra aux = this.primero;
        while (aux != null && aux.getPalabra() != n) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    @Override
    public void mostrar() {
        NodoPalabra aux = this.primero;
        while (aux != null) {
            System.out.print(aux.getPalabra() + " - ");
            aux = aux.getSiguiente();
        }
    }

    public void mostrar2() {
        NodoPalabra aux = this.ultimo;

        while (aux != null) {
            System.out.print(aux.getPalabra() + " - ");
            aux = aux.getAnterior();
        }
    }

    @Override
    public void mostrarREC(NodoPalabra l) {
        if (l != null) {
            System.out.print(l.getPalabra() + " - ");
            mostrarREC(l.getSiguiente());
        }
    }

    public int cantElementosREC() {
        int cont = 0;
        return cont;
    }

}
