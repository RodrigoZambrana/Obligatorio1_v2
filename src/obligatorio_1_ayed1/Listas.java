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
public class Listas implements IListas {
Nodo Primero;
Nodo Ultimo;

 public Listas() {
        this.Primero = null;
        this.Ultimo = null;
    }
 
 
     @Override
    public boolean esVacia() {
            return (this.Primero==null);
    }

    @Override
    public void agregarInicio(String nombre) {
           Nodo nuevo= new Nodo(nombre);
           if (this.esVacia())
               this.Primero=nuevo;
           else{
               nuevo.Siguiente=this.Primero;
               this.Primero=nuevo;                      
           }
    }

    @Override
    public void borrarInicio() {     
             if (!this.esVacia())
                  this.Primero=this.Primero.Siguiente;
    }
    
   @Override
    public void agregarFinal(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarFin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean buscarelemento(String nombre) {
          Nodo aux=this.Primero;
           while (aux!=null){
              if (aux.getNombre()==nombre){
                  return true;
              }
               aux=aux.Siguiente;            
        }     
         return false;
    }

    @Override
    public void vaciar() {
        this.Primero=null;
    }

    @Override
    public void mostrar() {
        Nodo aux=this.Primero;
        while (aux!=null){
               System.out.print(aux.getNombre() + " - ");
               aux=aux.Siguiente;            
        }
    }
    
    @Override
    public void agregarOrd(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarElemento(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarREC(Nodo l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     
    public Nodo getPrimero() {
        return Primero;
    }

    public void setPrimero(Nodo Primero) {
        this.Primero = Primero;
    }

    public Nodo getUltimo() {
        return Ultimo;
    }

    public void setUltimo(Nodo Ultimo) {
        this.Ultimo = Ultimo;
    }

    

   
}
