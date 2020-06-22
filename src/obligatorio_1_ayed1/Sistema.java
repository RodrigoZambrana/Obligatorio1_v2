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
    private ListaPalabras diccionario;
    public int[][] mapa = new int[5][5];

    public Sistema() {
        ListaUnidades lstUnidades = new ListaUnidades();
        this.lstUnidades = lstUnidades;
        ListaPalabras diccionario = new ListaPalabras();
        this.diccionario = diccionario;
        //this.mapa = mapa;
    }

//      //agregar mapa, diccionario y mapa
//      //agregar juego de prueba para el mapa
// 
//
//        public Sistema()
//        {
//          ListaUnidades lstUnidades = new ListaUnidades();
//          this.lstUnidades=lstUnidades;
//          
//        }
    @Override
    public Retorno crearSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lstUnidades.agregarFinal("C:");
        CargarDistancias(mapa);

        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        lstUnidades.vaciar(); 
        diccionario.vaciar();
        
        
        return ret;
    }

    @Override
    public Retorno AgregarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString="";
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas lc = nodoUnidad.getLc();
        if(!lc.buscarelemento(carpeta))
        lc.agregarFinal(carpeta, unidad);   
        else ret.valorString="La carpeta ya existe en la unidad";
        
        return ret;
    }

    /*FIXME 4*/
    @Override
    public Retorno EliminarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString="";
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad); 
        ListaCarpetas lc = nodoUnidad.getLc();
        if(lc.buscarelemento(carpeta)){
        lc.borrarElemento(carpeta);
        }else{
            ret.valorString="La carpeta no existe en la unidad";
        }
        return ret;
    }

    @Override
    public Retorno AgregarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje= carpetaBuscada.getLa().buscarelemento(mensaje);
        if(!encontreMensaje){
        carpetaBuscada.getLa().agregarInicio(mensaje);   
        }else{
            ret.valorString="El  mensaje ya existe en la carpeta";
        }
        return ret;
    }

    @Override
    public Retorno EliminarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje= carpetaBuscada.getLa().buscarelemento(mensaje);
        if(encontreMensaje){
        carpetaBuscada.getLa().borrarElemento(mensaje);
        }else{
            ret.valorString="El mensaje no existe en la carpeta";
        }
        return ret;
    }

    @Override
    public Retorno ListarEstructura(String unidad, String carpeta) { //listar estrucutra deberia recibir parametros¿ Estos parametros no serian necesarios cuando se crea el
        //sistema? Y cuando se lista simplemente se muestra lo que hay?
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoUnidad nodoUnidad = lstUnidades.getPrimero();
        while (nodoUnidad != null) {
            ret.valorString += "-" + nodoUnidad.getNombreUnidad() + "\n";
            NodoCarpeta nodoCarpeta = nodoUnidad.getLc().getPrimero();
            while (nodoCarpeta != null) {
                ret.valorString += "" + "+" + nodoCarpeta.getNombre() + "\n";
                // dif (nodoCarpeta.getLa() != null) { //si la carpeta contiene archivos, los lista
                    NodoArchivo nodoArchivo = nodoCarpeta.getLa().getPrimero();
                    while (nodoArchivo != null) {
                        ret.valorString += "" + "*" + nodoArchivo.getNombre() + "\n";
                        NodoLinea primero = nodoArchivo.getLi().getPrimero();
                        //int i=1;
                        while (primero!=null) {                            
                            ret.valorString +=primero.getDato()+":"+ "\n";
                            primero=primero.getSiguiente();
                        }
                        
                        nodoArchivo = nodoArchivo.getSiguiente();
                     
                    }
                //}
                nodoCarpeta = nodoCarpeta.getSiguiente();
            }
            nodoUnidad = nodoUnidad.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno InsertarLinea(String unidad, String carpeta, String mensaje) 
    {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString="";     
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje= carpetaBuscada.getLa().buscarelemento(mensaje);
        if(encontreMensaje){
        carpetaBuscada.getLa().obtenerArchivo(mensaje).getLi().agregarFinal("");
        ret.valorString="Se inserta linea en blanco";
        }else{
            ret.valorString="El  mensaje no  existe en la carpeta";
        }
        return ret;

    }

    @Override
    public Retorno InsertarLineaEnPosicion(String unidad, String carpeta, String mensaje,int posicionLinea) 
    {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaL=archivoBuscado.getLi();
        int cantLineas=listaL.cantElementos();
        
         NodoLinea primerLinea=listaL.getPrimero();
        NodoLinea nuevaLinea= new NodoLinea(posicionLinea);
        
        if(posicionLinea<=cantLineas){//la posicion a agregar es menor o igual al tamaño de la lista
            if(!listaL.esVacia()){
                
                if(posicionLinea==1){
                    listaL.agregarInicio(nuevaLinea);//agrego inicio
                }else if(posicionLinea==cantLineas+1){
                    listaL.agregarFinal(nuevaLinea);//agego final
                }
                else//recorro hasta encontrar pos
                {
                    for (int i = 1; i <=cantLineas ; i++) {
                        
                        if(i==posicionLinea)
                        {
                        if(primerLinea!=null){
                            nuevaLinea.setAnterior(primerLinea);
                            nuevaLinea.setSiguiente(primerLinea.getSiguiente());
                            primerLinea.getSiguiente().setAnterior(nuevaLinea);
                            primerLinea.setSiguiente(nuevaLinea);
                            
                        }else 
                        {
                        listaL.setUltimo(nuevaLinea);
                        }
                        ret.valorString="Se inserto una linea en la posicion"+posicionLinea;
                        return ret;
                        }
                        if(primerLinea!=null)
                        {
                        primerLinea=primerLinea.getSiguiente();
                        }
                    
                    }
                }
            
            }//esta vacia, agrego al inicio
            else
            {
                listaL.agregarInicio(nuevaLinea);
                ret.valorString="Se inserto una linea en la posicion"+posicionLinea;
                 return ret;
                
            }
            cantLineas++;
        
        
            }  else{//es mayor a la cantidad de elementos,agreggo al final
            
                listaL.agregarFinal(nuevaLinea);
                ret.valorString="Se inserto una linea en la posicion"+posicionLinea;
                return ret;
            }

        return ret;
    }

    @Override
    public Retorno BorrarLinea(String unidad, String carpeta, String mensaje,int posicionLinea) {
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

//    -------------------------------------------Aranca ejercicio de distancias------------------------------------------------------------------
    @Override
    public Retorno CargarDistancias(int[][] Ciudades) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        mapa[0][1] = 5;
        mapa[1][0] = 5;

        mapa[0][2] = 2;
        mapa[2][0] = 2;

        mapa[1][2] = 2;
        mapa[2][1] = 2;

        mapa[1][3] = 3;
        mapa[3][1] = 3;

        mapa[2][4] = 4;
        mapa[4][2] = 4;

        mapa[3][4] = 1;
        mapa[4][3] = 1;

        mapa[1][4] = 3;
        mapa[4][1] = 3;

        mapa[0][3] = 4;
        mapa[3][0] = 4;

        mapa[2][3] = 4;
        mapa[3][2] = 4;

        return ret;
    }

    @Override
    public Retorno BuscarCamino(int[][] M, String origen, String destino) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int suma = 9999;
        int columnas = M[0].length;
        String escala = "";
        int miOrigen = ciudadANumero(origen);
        int miDestino = ciudadANumero(origen);

        for (int i = 0; i < columnas; i++) {
            if (M[miOrigen][i] != 0 && M[miDestino][i] != 0) {

                if (M[miOrigen][i] + M[miDestino][i] < suma) {
                    suma = M[miOrigen][i] + M[miDestino][i];
                    escala = numeroACiudad(i);
                }
            }

        }

        ret.valorString = "El camino mas corto es:" + origen + "-" + escala + "-" + destino;

        return ret;
    }

    private int ciudadANumero(String Cuidad) {
        if (Cuidad.equals("MVD")) {
            return 0;
        }
        if (Cuidad.equals("POA")) {
            return 1;
        }
        if (Cuidad.equals("BA")) {
            return 2;
        }
        if (Cuidad.equals("SP")) {
            return 3;
        }
        if (Cuidad.equals("NYC")) {
            return 4;
        }
        if (Cuidad.equals("MIA")) {
            return 5;
        }
        if (Cuidad.equals("MAD")) {
            return 6;
        }

        return -1;
    }

    private String numeroACiudad(int nroCuidad) {
        if (nroCuidad == 0) {
            return "MVD";
        }
        if (nroCuidad == 1) {
            return "POA";
        }
        if (nroCuidad == 2) {
            return "BA";
        }
        if (nroCuidad == 3) {
            return "SP";
        }
        if (nroCuidad == 4) {
            return "NYC";
        }
        if (nroCuidad == 5) {
            return "MIA";
        }
        if (nroCuidad == 6) {
            return "MAD";
        }

        return "";
    }

}
