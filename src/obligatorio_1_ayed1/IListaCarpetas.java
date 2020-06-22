
package obligatorio_1_ayed1;


public interface IListaCarpetas {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String nombre, String unidad);
    public void agregarFinal(String Nombre,String unidad);
    public void borrarInicio();
    public void borrarFin();
    public boolean buscarelemento(String nombre);    
    public void vaciar();
    public void mostrar();  

    public NodoCarpeta obtenercarpeta(String dato);

    public NodoCarpeta obtenerCarpeta(String nombre);
    public void borrarElemento(String nombre);

 
//    public void mostrarREC(Nodo l); // implementar el mostrar recursivo
    
//   public void borrarFin();
//   otros metodos para analizar
//   public void agregarOrd(int n);
//   public void borrarElemento(int n);
//   public NodoLista obtenerElemento(int n);
//   public int cantElementos();   
}
