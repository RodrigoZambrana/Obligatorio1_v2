package obligatorio_1_ayed1;

public class NodoCarpeta {

    String unidad;/*FIXME ¿está bien que tenga éste atributo?*/
    String nombre;
    NodoCarpeta siguiente;
    NodoCarpeta anterior; /*FIXME 6*/
    ListaArchivos la;

    public NodoCarpeta(String nombre, String unidad) {
        this.unidad = unidad;/*FIXME 2*/
        this.nombre = nombre;
        this.la = new ListaArchivos();
        this.siguiente = null;
    }

 

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaArchivos getLa() {
        return la;
    }

    public void setLa(ListaArchivos la) {
        this.la = la;
    }

    public NodoCarpeta getSiguiente() {
        return siguiente;
    }
    
    
    public NodoCarpeta getAnterior() {
        return anterior;
    }

    public void setSiguiente(NodoCarpeta siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setAnterior(NodoCarpeta anterior) {
        this.anterior = anterior;
    }

   
}
