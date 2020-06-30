
package obligatorio_1_ayed1;


public class ListaCarpetas implements IListaCarpetas{
    
    NodoCarpeta Primero;
    NodoCarpeta Siguiente;
    NodoCarpeta Ultimo;
    ListaArchivos la;
    
    
    public ListaCarpetas() {
        this.Primero = null;
        this.Ultimo = null;
    }

    public NodoCarpeta getPrimero() {
        return Primero;
    }

    public void setPrimero(NodoCarpeta Primero) {
        this.Primero = Primero;
    }
    
    public NodoCarpeta getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoCarpeta Siguiente) {
        this.Siguiente = Siguiente;
    }

    
    public NodoCarpeta getUltimo() {
        return Ultimo;
    }

    public void setUltimo(NodoCarpeta Ultimo) {
        this.Ultimo = Ultimo;
    }

    public ListaArchivos getLa() {
        return la;
    }

    public void setLa(ListaArchivos la) {
        this.la = la;
    }
    
   


     @Override
    public boolean esVacia() {
            return (this.Primero==null);
    }

    @Override
    public void agregarInicio(String nombre, String unidad) {/*FIXME - Ahora también le paso unidad*/         
        NodoCarpeta nuevo = new NodoCarpeta(nombre,unidad);
        if (this.esVacia()) {
            this.Primero = nuevo;
            this.Ultimo = nuevo;
        } else {
            nuevo.siguiente = this.Primero;
            Primero.anterior = nuevo;
            this.Primero = nuevo;
    }
    }

    @Override
    public void agregarFinal(String Nombre,String unidad) {     
        NodoCarpeta nuevo=new NodoCarpeta(Nombre,unidad);
        if(this.esVacia()){
            this.Primero=nuevo;
            this.Ultimo=nuevo;            
        }else{
            this.Ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.Ultimo);
            this.Ultimo=nuevo;
            
        }

    }

    
    /*FIXME 5*/
    @Override
    public void borrarInicio() {
         if (!this.esVacia()) {
            if (this.Primero == this.Ultimo) {
                this.vaciar();
            } else {
                this.Primero = this.Primero.getSiguiente();
                this.Primero.setAnterior(null);
            }
        }
    }
    
    @Override
    public void borrarFin() {

        this.Ultimo = this.Ultimo.getAnterior();
        this.Ultimo.setSiguiente(null);

    }

    /*FIXME 1*/
     @Override
    public boolean buscarelemento(String nombre) {
        NodoCarpeta aux = this.Primero;
        while (aux != null) {
            if (aux.getNombre().equals(nombre)) {
                return true;
            }

            aux = aux.getSiguiente();
        }
        return false;

    }
    
    /*FIXME 3 - borrarElemento; obtenerCarpeta; borrarInicio; borrarFin;*/
    @Override
    public void borrarElemento(String nombre) {
        NodoCarpeta aux = obtenerCarpeta(nombre);
      if (this.Primero == aux) {
            this.borrarInicio();
        } else {
            if (this.Ultimo == aux) {
                this.borrarFin();
            }else{

            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());//<-esta linea da error
            }
        }

    }
    
    @Override
    public NodoCarpeta obtenerCarpeta(String nombre) {
        NodoCarpeta aux = this.Primero;
        while (aux != null && aux.getNombre()!= nombre) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public NodoCarpeta obtenercarpeta(String nombre) {
        NodoCarpeta aux=this.Primero;
           while (aux!=null){
              if (aux.getNombre()==nombre){
                  return aux;
              }
               aux=aux.siguiente;           
        }     
         return null;
    }
    

}
