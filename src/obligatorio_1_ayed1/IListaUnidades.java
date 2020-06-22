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
public interface IListaUnidades {
    
    public boolean esVacia();
     public void agregarInicio(String Nombre);
     public void agregarFinal(String Nombre);
     public void mostrar();
     public NodoUnidad obtenerElemento(String nombre);
     public void vaciar();
     
}
