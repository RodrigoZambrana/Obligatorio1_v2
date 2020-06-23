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
public interface IListaPalabras {
    
    public boolean esVacia();
    public void agregarInicio(String dato);
    public void agregarFinal(String dato);
    public void agregarOrd(String n);
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(String n);
    public boolean buscarelemento(String dato);    
    public NodoPalabra obtenerElemento(String n); 
    public void vaciar();
    public void mostrar();    
    public void mostrarREC(NodoPalabra l); // implementar el mostrar recursivo    
    public int cantElementos();  
    
}
