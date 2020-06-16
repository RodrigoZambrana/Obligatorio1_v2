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
public interface ISistema {
    
 Retorno crearSistemaMensajes();
 Retorno destruirSistemaMensajes();
 Retorno AgregarCarpeta(String unidad, String carpeta);
 Retorno EliminarCarpeta(String unidad, String carpeta);
 Retorno AgregarMensaje(String unidad, String carpeta, String mensaje);
 Retorno EliminarMensaje(String unidad,String carpeta, String mensaje);
 Retorno ListarEstructura(String unidad, String carpeta);
 Retorno InsertarLinea(); 
 Retorno InsertarLineaEnPosicion(int posicionLinea); 
 Retorno BorrarLinea(int posicionLinea);
 Retorno BorrarTodo(); 
 Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar);
 Retorno ImprimirTexto();
 Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar);
 Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar);
 Retorno BorrarPalabra(int posicionLinea, int posicionPalabra);
 Retorno BorrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar);
 Retorno ImprimirLinea(int posicionLinea);
 Retorno IngresarPalabraDiccionario(String palabraAIngresar);  
 Retorno BorrarPalabraDiccionario(String palabraABorrar);
 Retorno ImprimirDiccionario();
 Retorno ImprimirTextoIncorrecto();
 Retorno CargarDistancias(int[][] Ciudades);
 Retorno BuscarCamino ( int [][] M, String origen, String destino);
 
 }   
    
    
    
    
    
    
    
    
    
    
//    public Retorno crearSistemaMensajes();//la letra dice que debe recibir cantidad de ciudades por parámetro
//    public Retorno destruirSistemaMensajes();
//    public Retorno agregarCarpeta(String unidad, String carpeta);
//    public Retorno eliminarCarpeta(String unidad, String carpeta);
//    public Retorno agregarMensaje(String unidad, String carpeta, String mensaje);
//    public Retorno eliminarMensaje(String unidad, String carpeta, String mensaje);
//    public Retorno listarEstructura(String unidad, String carpeta);
//    public Retorno insertarLinea();
//    public Retorno insertarLineaEnPosicion(int posicionLinea);
//    public Retorno borrarLinea(int posicionLinea);
//    public Retorno borrarTodo();
//    public Retorno borrarOcurrenciasPalabraEnTexto(String palabraABorrar);
//    public Retorno imprimirTexto();
//    public Retorno insertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar);
//    public Retorno insertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar);
//    public Retorno borrarPalabra(int posicionLinea, int posicionPalabra);
//    public Retorno borrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar);
//    public Retorno imprimirLinea(int posicionLinea);
//    public Retorno ingresarPalabraDiccionario(String palabraAIngresar);
//    public Retorno borrarPalabraDiccionario(String palabraABorrar);
//    public Retorno imprimirDiccionario();
//    public Retorno imprimirTextoIncorrecto();

