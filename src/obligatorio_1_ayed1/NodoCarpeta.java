package obligatorio_1_ayed1;

public class NodoCarpeta {

    String unidad;
    String nombre;
    ListaArchivos la;
    NodoCarpeta siguiente;

    public NodoCarpeta(String nombre) {
        this.unidad = unidad;
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

    public void setSiguiente(NodoCarpeta siguiente) {
        this.siguiente = siguiente;
    }
}
