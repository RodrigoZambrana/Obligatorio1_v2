
package obligatorio_1_ayed1;

/**
 *
 * @author marti
 */
public interface IListaLineas {
       public boolean esVacia();
    //public void insertarLinea();
    public void agregarInicio(NodoLinea nuevo);
    public void agregarFinal(NodoLinea nuevo);
    public void borrarInicio(); 
    public boolean buscarelemento(Object dato);    
    public void vaciar();
    public void mostrar();    
    public void mostrarREC(NodoLinea l); // implementar el mostrar recursivo    
    public void borrarFin();
    public void agregarOrd(Object n);
    public void borrarElemento(Object n);
    public NodoLinea obtenerElemento(int n);
    public int cantElementos();
}

