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
    int MAX_CANT_PALABRAS_X_LINEA = 4;
    public int[][] mapa = {{0,10,25,15,30,0},{10,0,20,0,0,0},{25,20,0,0,0,40},{15,0,0,0,0,45},{30,0,0,0,0,25},{0,0,40,45,25,0}};
    
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
    public Retorno BorrarOcurrenciasPalabraEnTexto(String unidad, String carpeta, String mensaje, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaLineas = archivoBuscado.getLi();
        if (!listaLineas.esVacia()) {
            NodoLinea primero = archivoBuscado.getLi().getPrimero();
            while (primero != null) {
                NodoPalabra auxPalabra = primero.getLp().getPrimero();
                //falta borrar inicio y borrar fin
                while (auxPalabra != null) {

                    if (auxPalabra.getPalabra() == palabraABorrar) {
                        auxPalabra.getAnterior().setSiguiente(auxPalabra.getSiguiente());
                        auxPalabra.getSiguiente().setAnterior(auxPalabra.getAnterior());
                    }
                    auxPalabra = auxPalabra.getSiguiente();
                }
                ret.valorString += "\n";
                primero = primero.getSiguiente();
            }

        } else {
            ret.valorString = "Texto vacio";
        }
        return ret;
    }

    @Override
    public Retorno ImprimirTexto(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaLineas = archivoBuscado.getLi();
        if (!listaLineas.esVacia()) {
            NodoLinea primero = archivoBuscado.getLi().getPrimero();
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

        } else {
            ret.valorString = "Texto vacio";
        }
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
            boolean agregue = false;
            while (auxLinea != null && !agregue) { //recorro las líneas
                if (auxLinea.getNumeroLinea() == posicionLinea) {
                    //si encuentro la línea,
                    //pregunto si la cantidad de palabras en la línea está al máximo o si la posición buscada es inválida:
                    if (!auxLinea.getLp().esVacia()) {
                        int cantidadPalabras = auxLinea.getLp().cantElementos();
                        if (posicionPalabra > cantidadPalabras + 1) {
                            ret.valorString = "Error: la posición de la palabra es inválida";
                        }
                        if (posicionPalabra == cantidadPalabras + 1) {
                            auxLinea.getLp().agregarFinal(palabraAIngresar);
                            agregue = true;
                        } else if (cantidadPalabras == this.MAX_CANT_PALABRAS_X_LINEA) {
                            ret.valorString = "Error: la lista de palabras está llena";
                            agregue = true;
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
                        agregue = true;
                        //auxLinea = null;
                    }
                } else {
                    auxLinea = auxLinea.getSiguiente();
                }
            }
            if (agregue == false) {
                //si no encuentro la línea:
                ret.valorString = "Error: la posición de la línea es inválida";
            }
        }
        return ret;
    }

    @Override
    public Retorno InsertarPalabraYDesplazar(String unidad, String carpeta, String mensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
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
            boolean agregue = false;
            while (auxLinea != null) { //recorro las líneas
                if (auxLinea.getNumeroLinea() == posicionLinea) {
                    //si encuentro la línea,
                    //pregunto si la cantidad de palabras en la línea está al máximo o si la posición buscada es inválida:
                    if (!auxLinea.getLp().esVacia()) {
                        int cantidadPalabras = auxLinea.getLp().cantElementos();
                        if (posicionPalabra > cantidadPalabras + 1) {
                            ret.valorString = "Error: la posición de la palabra es inválida";
                        }
                        if (posicionPalabra == cantidadPalabras + 1) {
                            auxLinea.getLp().agregarFinal(palabraAIngresar);
                            agregue = true;
                        } else if (cantidadPalabras == this.MAX_CANT_PALABRAS_X_LINEA) {
                            //int cantidadPalabras = auxLinea.getLp().cantElementos();

                            //while (cantidadPalabras == this.MAX_CANT_PALABRAS_X_LINEA) {
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

                                    auxLinea.siguiente.getLp().agregarInicio(auxLinea.getLp().getUltimo().getPalabra());
                                    NodoPalabra ultimoLineaDos = auxLinea.getLp().getUltimo().getAnterior();
                                    auxLinea.getLp().setUltimo(ultimoLineaDos);
                                    auxLinea.getLp().getUltimo().setSiguiente(null);
                                }
                                i++;
                                auxPalabra = auxPalabra.Siguiente;
                            }
                            auxLinea = auxLinea.siguiente;
                            posicionLinea++;
                            //cantidadPalabras = auxLinea.getLp().cantElementos();
                            //}
                            //agregue = true;
                        } else if (cantidadPalabras > this.MAX_CANT_PALABRAS_X_LINEA) {
                            auxLinea.siguiente.getLp().agregarInicio(auxLinea.getLp().getUltimo().getPalabra());
                            NodoPalabra ultimoLineaDos = auxLinea.getLp().getUltimo().getAnterior();
                            auxLinea.getLp().setUltimo(ultimoLineaDos);
                            auxLinea.getLp().getUltimo().setSiguiente(null);
                            auxLinea = auxLinea.siguiente;
                        }
                    } //está vacía; agrego al inicio
                    else {
                        auxLinea.getLp().agregarInicio(palabraAIngresar);
                        agregue = true;
                        //auxLinea = null;
                    }
                } else {
                    auxLinea = auxLinea.getSiguiente();

                }
            }
            if (agregue == false) {
                //si no encuentro la línea:
                ret.valorString = "Error: la posición de la línea es inválida";
            }
        }
        return ret;
    }

    @Override
    public Retorno BorrarPalabra(String unidad, String carpeta, String mensaje, int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaL = archivoBuscado.getLi();
        NodoLinea auxLinea = listaL.getPrimero();
        int i = 1;
        boolean encontre = false;
        //recorro líneas hasta encontrar la posicionLinea:
        while (auxLinea != null && !encontre) {
            if (i == posicionLinea) {
                //si es la primera posición, borro inicio:
                if (posicionPalabra == 1) {
                    auxLinea.getLp().borrarInicio();
                    encontre = true;
                } else {
                    NodoPalabra auxPalabra = auxLinea.getLp().getPrimero();
                    int j = 1;
                    //recorro las palabras
                    while (auxPalabra != null) {
                        if (j == posicionPalabra) {
                            //si es la última palabra, borro al final:
                            if (auxPalabra.getSiguiente() == null) {
                                auxLinea.getLp().borrarFin();
                            } //si no voy a borrar la primera ni la última:
                            else {
                                auxPalabra.getAnterior().setSiguiente(auxPalabra.getSiguiente());
                                auxPalabra.getSiguiente().setAnterior(auxPalabra.getAnterior());
                            }
                        } else {
                            ret.valorString = "Error: la posición de la palabra es inválida";
                        }
                        j++;
                        auxPalabra = auxPalabra.getSiguiente();
                    }
                }
            } else {
                //si no encuentro la línea:
                ret.valorString = "Error: la posición de la línea es inválida";
            }
            i++;
            auxLinea = auxLinea.siguiente;
        }
        return ret;
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnLinea(String unidad, String carpeta, String mensaje, int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ImprimirLinea(String unidad, String carpeta, String mensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        NodoArchivo archivoBuscado = lstUnidades.obtenerElemento(unidad).getLc().obtenerCarpeta(carpeta).getLa().obtenerArchivo(mensaje);
        ListaLineas listaLineas = archivoBuscado.getLi();
        if (!listaLineas.esVacia() && posicionLinea <= listaLineas.cantElementos()) {
            NodoLinea primeraLinea = archivoBuscado.getLi().getPrimero();
            boolean encontre = false;
            while (primeraLinea != null && !encontre) {
                if (primeraLinea.getNumeroLinea() == posicionLinea) {
                    ret.valorString += primeraLinea.getNumeroLinea() + ": ";
                    NodoPalabra auxPalabra = primeraLinea.getLp().getPrimero();
                    while (auxPalabra != null) {
                        ret.valorString += auxPalabra.getPalabra() + " ";
                        auxPalabra = auxPalabra.getSiguiente();
                    }
                    encontre = true;
                }
                primeraLinea = primeraLinea.getSiguiente();
            }

        } else {
            ret.valorString = "La linea proprocionada no no es valida";
        }

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
        mapa[0][1] = 10;
        mapa[1][0] = 10;

        mapa[0][2] = 25;
        mapa[2][0] = 25;

        mapa[0][3] = 15;
        mapa[3][0] = 15;

        mapa[0][4] = 30;
        mapa[4][0] = 30;

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
