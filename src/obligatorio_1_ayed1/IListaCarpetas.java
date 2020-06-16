
package obligatorio_1_ayed1;


public interface IListaCarpetas {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String Nombre);
    public void agregarFinal(int dato, String Nombre);
    public void borrarInicio(); 
    public boolean buscarelemento(int dato);    
    public void vaciar();
    public void mostrar();  
    public NodoCarpeta obtenercarpeta(int dato);
 
//    public void mostrarREC(Nodo l); // implementar el mostrar recursivo
    
//   public void borrarFin();
//   otros metodos para analizar
//   public void agregarOrd(int n);
//   public void borrarElemento(int n);
//   public NodoLista obtenerElemento(int n);
//   public int cantElementos();   
}
