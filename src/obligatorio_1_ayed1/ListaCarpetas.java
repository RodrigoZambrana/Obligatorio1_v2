
package obligatorio_1_ayed1;


public class ListaCarpetas implements IListaCarpetas{
    
     NodoCarpeta Primero;
    NodoCarpeta Ultimo;
    ListaArchivos la;

    public NodoCarpeta getPrimero() {
        return Primero;
    }

    public void setPrimero(NodoCarpeta Primero) {
        this.Primero = Primero;
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
    
   

    public ListaCarpetas() {
        this.Primero = null;
        this.Ultimo = null;
    }

     @Override
    public boolean esVacia() {
            return (this.Primero==null);
    }

    @Override
    public void agregarInicio(String nombre) {
           NodoCarpeta nuevo= new NodoCarpeta(nombre);
           if (this.esVacia())
               this.Primero=nuevo;
           else{
               nuevo.siguiente=this.Primero;
               this.Primero=nuevo;                      
           }
    }

    @Override
    public void agregarFinal(int dato, String Nombre) {

    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarelemento(int dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public NodoCarpeta obtenercarpeta(int dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
