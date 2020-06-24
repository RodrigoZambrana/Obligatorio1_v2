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
    int MAX_CANT_PALABRAS_X_LINEA = 6;
    public int[][] mapa = new int[5][5];

    public Sistema(int CantCuidades) {
        this.lstUnidades = new ListaUnidades();
        this.diccionario = new ListaPalabras();
    }

    public ListaUnidades getLstUnidades() {
        return lstUnidades;
    }

    public void setLstUnidades(ListaUnidades lstUnidades) {
        this.lstUnidades = lstUnidades;
    }

    public ListaPalabras getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(ListaPalabras diccionario) {
        this.diccionario = diccionario;
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }

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
        ret.valorString = "";
        if (lstUnidades.buscarelemento(unidad)) {
            NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
            ListaCarpetas lc = nodoUnidad.getLc();
            if (!lc.buscarelemento(carpeta)) {
                lc.agregarFinal(carpeta, unidad);
            } else {
                ret.valorString = "La carpeta ya existe en la unidad";
            }

        } else {
            ret.valorString = "La unidad no existe en el sistema";
        }

        return ret;
    }

    /*FIXME 4*/
    @Override
    public Retorno EliminarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        if (lstUnidades.buscarelemento(unidad)) {
            NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
            ListaCarpetas lc = nodoUnidad.getLc();
            if (lc.buscarelemento(carpeta)) {
                lc.borrarElemento(carpeta);
            } else {
                ret.valorString = "La carpeta no existe en la unidad";
            }
        } else {
            ret.valorString = "La unidad no existe en el sistema";
        }
        return ret;
    }

    @Override
    public Retorno AgregarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje = carpetaBuscada.getLa().buscarelemento(mensaje);
        if (!encontreMensaje) {
            carpetaBuscada.getLa().agregarFinal(mensaje);
        } else {
            ret.valorString = "El  mensaje ya existe en la carpeta";
        }
        return ret;
    }

    @Override
    public Retorno EliminarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje = carpetaBuscada.getLa().buscarelemento(mensaje);
        if (encontreMensaje) {
            carpetaBuscada.getLa().borrarElemento(mensaje);
        } else {
            ret.valorString = "El mensaje no existe en la carpeta";
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
                    while (primero != null) {
                        ret.valorString += primero.getNumeroLinea() + ": ";
                        NodoPalabra auxPalabra = primero.getLp().getPrimero();
                        while (auxPalabra != null) {
                            ret.valorString += auxPalabra.getPalabra() + " ";
                            auxPalabra = auxPalabra.getSiguiente();
                        }
                        ret.valorString += "\n";
                        primero = primero.getSiguiente();
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
    public Retorno InsertarLinea(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoUnidad nodoUnidad = lstUnidades.obtenerElemento(unidad);
        ListaCarpetas carpetasEnUnidad = nodoUnidad.getLc();
        NodoCarpeta carpetaBuscada = carpetasEnUnidad.obtenercarpeta(carpeta);
        boolean encontreMensaje = carpetaBuscada.getLa().buscarelemento(mensaje);
        if (encontreMensaje) {
            carpetaBuscada.getLa().obtenerArchivo(mensaje).getLi().agregarFinal();
            ret.valorString = "Se inserta linea en blanco";
        } else {
            ret.valorString = "El  mensaje no  existe en la carpeta";
        }
        return ret;

    }

    @Override
    public Retorno InsertarLineaEnPosicion(String unidad, String carpeta, String mensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaL = archivoBuscado.getLi();
        int cantLineas = listaL.cantElementos();

        if (!listaL.esVacia()) {
            if (posicionLinea <= cantLineas) {//la posicion a agregar es menor o igual al tamaño de la lista
                if (posicionLinea == 1) {
                    listaL.agregarInicio();//agrego al inicio
                } else {
                    NodoLinea aux = listaL.getPrimero();
                    boolean encontre = false;
                    while (aux != null && !encontre) {
                        if (aux.getNumeroLinea() == posicionLinea) {
                            NodoLinea nuevaLinea = new NodoLinea();
                            nuevaLinea.anterior = aux.anterior;
                            aux.anterior.siguiente = nuevaLinea;
                            aux.anterior = nuevaLinea;
                            nuevaLinea.siguiente = aux;
                            encontre = true;
                            ret.valorString = "Se inserta línea en la posición " + posicionLinea;
                            listaL.numerar();
                        }
                        aux = aux.siguiente;
                    }
                }
            } else if (posicionLinea == cantLineas + 1) {
                listaL.agregarFinal();//agrego al final
            }
        } //está vacía, agrego al inicio
        else {
            listaL.agregarInicio();
            ret.valorString = "Se inserto una linea en la posicion" + posicionLinea;
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno BorrarLinea(String unidad, String carpeta, String mensaje, int posicionLinea) { //ver borrar elemento
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaL = archivoBuscado.getLi();
        int cantLineas = listaL.cantElementos();

        if (!listaL.esVacia()) {//lista no vacia
            if (posicionLinea <= cantLineas) {//posicion esta entre la cantidad de lineas
                if (posicionLinea == 1) {
                    listaL.borrarInicio();//borro al inicio
                    listaL.numerar();
                } else if (posicionLinea == cantLineas) {
                    listaL.borrarFin();
                } else {//recorro y borro en la posicion

                    NodoLinea aux = listaL.getPrimero();
                    boolean encontre = false;
                    while (aux != null && !encontre) {
                        if (aux.getNumeroLinea() == posicionLinea) {//revisar

                            //borrar elemento
                            aux.getAnterior().setSiguiente(aux.getSiguiente());
                            aux.getSiguiente().setAnterior(aux.getAnterior());

                            encontre = true;
                            ret.valorString = "Se inserta línea en la posición " + posicionLinea;
                            listaL.numerar();
                        }
                        aux = aux.siguiente;
                    }
                }
            } else {
                if (posicionLinea == cantLineas) {//es la ultima posicion. Borro al final
                    listaL.borrarFin();
                    
                } else if (posicionLinea > cantLineas) {
                    ret.valorString = "La linea no existe en el texto";
                }
            }

        } else {
            ret.valorString = "El archivo proporcionado no contiene lineas";
        }

        return ret;
    }

    @Override
    public Retorno BorrarTodo(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaLineas = archivoBuscado.getLi();
        listaLineas.vaciar();

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
    public Retorno InsertarPalabraEnLinea(String unidad, String carpeta, String mensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {

        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";

        if (posicionPalabra < 1) {
            ret.valorString = "Error: la posición de la palabra es inválida";
            //return ret;
        } else {
            //primero: ubico la línea:
            NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
            ListaLineas listaL = archivoBuscado.getLi();
            NodoLinea auxLinea = listaL.getPrimero();
            while (auxLinea != null) { //recorro las lienas
                if (auxLinea.getNumeroLinea() == posicionLinea) {
                    //si encuentro la línea,
                    //pregunto si la cantidad de palabras en la línea está al máximo o si la posición buscada es inválida:
                    if (!auxLinea.getLp().esVacia()) {
                        int cantidadPalabras = auxLinea.getLp().cantElementos();
                        if (posicionPalabra > cantidadPalabras + 1) {
                            ret.valorString = "Error: la posición de la palabra es inválida";
                        } if(posicionPalabra == cantidadPalabras + 1){
                           auxLinea.getLp().agregarFinal(palabraAIngresar);
                           auxLinea = null;
                        }else if (cantidadPalabras == this.MAX_CANT_PALABRAS_X_LINEA) {
                            ret.valorString = "Error: la lista de palabras está llena";
                        } else {                               
                           //segundo: recorro lista de palabras hasta ubicarme en posicionPalabra
                            int i = 1;
                            boolean encontre = false;
                            NodoPalabra auxPalabra = auxLinea.getLp().getPrimero();
                            while (auxPalabra != null && !encontre) {
                                if (i == posicionPalabra) {
                                    NodoPalabra nuevaPalabra = new NodoPalabra(palabraAIngresar);
                                    nuevaPalabra.Anterior = auxPalabra.Anterior;
                                    auxPalabra.Anterior.Siguiente = nuevaPalabra;
                                    auxPalabra.Anterior = nuevaPalabra;
                                    nuevaPalabra.Siguiente = auxPalabra;
                                    encontre = true;
                                    listaL.numerar();
                                }
                                 i++;
                                auxPalabra = auxPalabra.Siguiente;
                               
                            }
                        }
                    } //está vacía; agrego al inicio
                    else {
                        auxLinea.getLp().agregarInicio(palabraAIngresar);
                        auxLinea = null;

                    }
                } else {

                    auxLinea = auxLinea.getSiguiente();

                }
                //si no encuentro la línea:
                ret.valorString = "Error: la posición de la línea es inválida";
                
            }

        }
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
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        if (!diccionario.buscarelemento(palabraAIngresar)) {
            //this.diccionario.agregarOrd(palabraAIngresar);
            diccionario.agregarOrd(palabraAIngresar);
        } else {
            ret.valorString = palabraAIngresar + "ya existe en el diccionario.";
        }

        return ret;

    }

    @Override
    public Retorno BorrarPalabraDiccionario(String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        if (diccionario.buscarelemento(palabraABorrar)) {
            diccionario.borrarElemento(palabraABorrar);
        } else {
            ret.valorString = palabraABorrar + "no existe en el diccionario.";
        }

        return ret;
    }

    @Override
    public Retorno ImprimirDiccionario() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        if (!diccionario.esVacia()) {
            NodoPalabra primeraPalabra = diccionario.getPrimero();
            while (primeraPalabra != null) {
                ret.valorString += "-" + primeraPalabra.getPalabra() + "\n";
                primeraPalabra = primeraPalabra.getSiguiente();
            }
        } else {
            ret.valorString = "Diccionario vacio";
        }
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
