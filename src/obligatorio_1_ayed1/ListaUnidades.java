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
public class ListaUnidades implements IListaUnidades {

    NodoUnidad Primero;
    NodoUnidad Ultimo;
    NodoUnidad Siguiente;
    ListaCarpetas listaCarpetas;

    @Override
    public boolean esVacia() {
        return this.Primero == null;
    }
    
    public NodoUnidad getPrimero() {
        return Primero;
    }

    public void setPrimero(NodoUnidad Primero) {
        this.Primero = Primero;
    }

    public NodoUnidad getUltimo() {
        return Ultimo;
    }

    public void setUltimo(NodoUnidad Ultimo) {
        this.Ultimo = Ultimo;
    }

    @Override
    public void agregarInicio(String nodo) {
        NodoUnidad nuevo = new NodoUnidad(nodo);
        if (this.esVacia()) {
            this.Primero = nuevo;
            this.Ultimo = nuevo;
        } else {
            nuevo.Siguiente=this.Primero;
            Primero.Anterior=nuevo;
            this.Primero=nuevo;
        }
    }
    
     @Override
    public void agregarFinal(String unidad) {
        NodoUnidad nuevo=new NodoUnidad(unidad);
        if(this.esVacia()){
            this.Primero=nuevo;
            this.Ultimo=nuevo;            
        }else{
            this.Ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.Ultimo);
            this.Ultimo=nuevo;
            
        }
   }
    
    
    
//     @Override
//    public void agregarFinal(String unidad, String carpeta) {
//        NodoCarpeta nuevo=new NodoCarpeta(unidad, carpeta);
//        if(this.esVacia()){
//            this.Primero=nuevo;
//            this.Ultimo=nuevo;            
//        }else{
//            this.Ultimo.setSiguiente(nuevo);
//            nuevo.setAnt(this.Ultimo);
//            this.ultimo=nuevo;
//            
//        }
//   }
//    
    
    
    @Override
    public void mostrar() {
        NodoUnidad aux = this.Primero;
        while (aux!=null) {            
            System.out.print(aux.getNombreUnidad());
            aux=aux.getSiguiente();
        }
    }

    @Override
    public NodoUnidad obtenerElemento(String nombre) {
           NodoUnidad aux= this.getPrimero();          
          while (aux!=null){
              if (aux.getNombreUnidad()==nombre)
                  return aux;
              
              aux=aux.getSiguiente();
          }
          
         return null;         
    }
    
    
    @Override
    public void vaciar() {
        this.Primero=null;
        this.Ultimo=null;
    }

}
