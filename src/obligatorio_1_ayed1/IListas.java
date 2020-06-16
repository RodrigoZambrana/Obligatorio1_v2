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
public interface IListas {
    public boolean esVacia();
    public void agregarInicio(String nombre);
    public void agregarFinal(String nombre);
    public void borrarInicio();
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public boolean buscarelemento(String nombre);
    public void mostrarREC(Nodo l);   
    public void agregarOrd(int n);
    public void borrarElemento(String nombre);
    public int cantElementos();
//    public NodoLista obtenerElemento(String nombre);
//    public void mostrarREC(NodoLista l);
    
}
