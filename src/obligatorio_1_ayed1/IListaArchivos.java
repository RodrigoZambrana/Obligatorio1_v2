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
public interface IListaArchivos {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String Nombre);
    public void agregarFinal(String Nombre);
    public void borrarInicio(); 
    public boolean buscarelemento(String nombre); 
    public void borrarElemento(String nombre);
    public void vaciar();
    public void mostrar();  
    public NodoCarpeta obtenercarpeta(String nombre);
    public NodoArchivo obtenerArchivo(String nombre);
    public void borrarFin();
//    public void mostrarREC(Nodo l); // implementar el mostrar recursivo
    
//   public void borrarFin();
//   otros metodos para analizar
//   public void agregarOrd(int n);
//   public void borrarElemento(int n);
//   public NodoLista obtenerElemento(int n);
//   public int cantElementos();   
}
