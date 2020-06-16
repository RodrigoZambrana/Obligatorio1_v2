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
public class Sistema implements ISistema {
     private ListaUnidades lstUnidades;
      private static Sistema instancia;
     
        public static Sistema Instancia()
        {
            if (instancia == null)
            {
                instancia = new Sistema();
               
            }

            return instancia;
        }

        //Constructor privado, para evitar que se pueda hacer un new Empresa.
        private Sistema()
        {
          ListaUnidades lstUnidades = new ListaUnidades();
          this.lstUnidades=lstUnidades;
        }
       

    @Override
    public Retorno crearSistemaMensajes() {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = new NodoUnidad("C:");
        lstUnidades.agregarInicio(nodoUnidad);
        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

     @Override
    public Retorno AgregarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad=lstUnidades.obtenerElemento(unidad);
        ListaCarpetas lc= nodoUnidad.getLc();
        lc.agregarInicio(carpeta);
        

        return ret;
    }

    @Override
    public Retorno EliminarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno AgregarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno EliminarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ListarEstructura(String unidad, String carpeta) { //listar estrucutra deberia recibir parametros¿ Estos parametros no serian necesarios cuando se crea el
        //sistema? Y cuando se lista simplemente se muestra lo que hay?
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString="";
       // ListaUnidades lu= new ListaUnidades(); esto es lo que haciamos inicialmente, pero no esta bien, ya que estariamos creando 
       //una nueva lista de unidades cada vez que se llame a listar estructura, en vez de solo mostrar los elementos de la ya creada cuando se inicia el sistema
       // ListaUnidades aux= new ListaUnidades();
        //Nodo elemento= aux.getPrimero();
        NodoUnidad nodoUnidad=lstUnidades.getPrimero();
        while (nodoUnidad!=null) {            
            ret.valorString+="-"+nodoUnidad.getNombreUnidad()+"\n";
            
            
            NodoCarpeta nodoCarpeta= nodoUnidad.getLc().getPrimero();
            
            while (nodoCarpeta!=null) {            
            ret.valorString+=""+"+"+nodoCarpeta.getNombre()+"\n";
            nodoCarpeta=nodoCarpeta.getSiguiente();
           
    }
             nodoUnidad=nodoUnidad.getSiguiente();
    }
        return ret;
    }

    @Override
    public Retorno InsertarLinea() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno InsertarLineaEnPosicion(int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarLinea(int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarTodo() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ImprimirTexto() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarPalabra(int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ImprimirLinea(int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno IngresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BorrarPalabraDiccionario(String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ImprimirDiccionario() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno CargarDistancias(int[][] Ciudades) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BuscarCamino(int[][] M, String origen, String destino) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

}
