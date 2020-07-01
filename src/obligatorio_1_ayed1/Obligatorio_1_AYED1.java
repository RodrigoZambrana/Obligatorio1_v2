package obligatorio_1_ayed1;
//

public class Obligatorio_1_AYED1 {
//

    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema(0);//EL NUMERO REPRESENTA LA CANT DE CUIDADES A GESTIONAR
        Prueba p = new Prueba();
        pruebaEstructura(s, p);//(todos OK)
        //pruebatopes(s, p);//(todos OK)
        // pruebaDiccionario(s,p);
//        pruebaOperacionesPalabras(s, p);
//        pruebaSinErrores(s, p);
//        pruebaErroresCrearCarpeta(s, p);

    }

    public static void pruebaEstructura(Sistema s, Prueba p) {
//        
// Retorno crearSistemaMensajes();
        p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se crea sistema de mensajes");

// Retorno AgregarCarpeta(String unidad, String carpeta);//
//Casos OK
        p.ver(s.AgregarCarpeta("C", "Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta Archivos en unidad C");
        p.ver(s.AgregarCarpeta("C", "Documentos").resultado, Retorno.Resultado.OK, "Se creo la carpeta documentos en unidad C");
        p.ver(s.AgregarCarpeta("C", "Mensajes").resultado, Retorno.Resultado.OK, "Se creo la carpeta mensajes en unidad C");
        p.ver(s.AgregarCarpeta("C", "Otros Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta Otros Archivos en unidad C");

//casos ERROR- unidad no existe
//        p.ver(s.AgregarCarpeta("C", "Otros Archivos").resultado, Retorno.Resultado.ERROR, "Se intenta crear la carpeta Otros Archivos en unidad C, que ya existe");
//        p.ver(s.AgregarCarpeta("D", "Otros Archivos").resultado, Retorno.Resultado.ERROR, "Se intenta crear la carpeta Otros Archivos en unidad D, que no existe");

// listamos par ver si la estructura es correcta
        //p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);

// Retorno EliminarCarpeta(String unidad, String carpeta);
//Casos OK
//        p.ver(s.EliminarCarpeta("C", "Documentos").resultado, Retorno.Resultado.OK, "Se borra carpeta Documentos");
//        p.ver(s.EliminarCarpeta("C", "Otros Archivos").resultado, Retorno.Resultado.OK, "Se borra carpeta Otros Archivos");
//////casos ERROR-carpeta no existe 
//        p.ver(s.EliminarCarpeta("C", "Carpeta X").resultado, Retorno.Resultado.ERROR, "Se intento borrar carpeta X que no existe");
//        p.ver(s.EliminarCarpeta("D", "Carpeta X").resultado, Retorno.Resultado.ERROR, "Se intento borrar carpeta X en unidad que no existe");

//
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// Retorno AgregarMensaje(String unidad, String carpeta, String mensaje);
////Casos (OK)
        p.ver(s.AgregarMensaje("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega mensaje 1 en carpeta Archivos");
        p.ver(s.AgregarMensaje("C", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega mensaje 2 en carpeta Archivos");
        p.ver(s.AgregarMensaje("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrega mensaje 3 en carpeta Archivos");
        p.ver(s.AgregarMensaje("C", "Archivos", "mensaje4").resultado, Retorno.Resultado.OK, "Se agrega mensaje 4 en carpeta Archivos");
//casos ERROR -Agegar mensaje a Carpeta que no existe
//        p.ver(s.AgregarMensaje("C", "Carpeta X", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intenta agregar mensaje a Carpeta X, que no existe");
//        p.ver(s.AgregarMensaje("D", "Archivos", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intenta agregar mensaje a Carpeta X, en unidad que no existe");
//        p.ver(s.AgregarMensaje("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intenta agregar mensaje 1 que ya existe en carpeta Archivos");

////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// Retorno EliminarMensaje(String unidad,String carpeta, String mensaje);
////casos OK
//        p.ver(s.EliminarMensaje("C", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se intenta eliminar mensaje 2 en carpeta Archivos que no existe");
//        p.ver(s.EliminarMensaje("C", "Archivos", "mensaje4").resultado, Retorno.Resultado.OK, "Se intenta eliminar mensaje 4 en carpeta Archivos que no existe");
////
////casos ERROR        
//        p.ver(s.EliminarMensaje("C", "Carpeta X", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar mensaje a Carpeta X, que no existe");
//        p.ver(s.EliminarMensaje("D", "Archivos", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar mensaje a Carpeta X, en unidad D que no existe");
//        p.ver(s.EliminarMensaje("C", "Archivos", "mensaje6").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar mensaje 6 que no existe en carpeta Archivos");

//
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// // funcionalidad referente a archivo de mensaje, lineas
//// Retorno InsertarLinea(String unidad, String carpeta, String mensaje);
////casos OK
        p.ver(s.InsertarLinea("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrego una linea 1 al archivo mensaje1");
        p.ver(s.InsertarLinea("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrego una linea 2 al archivo mensaje1");
        p.ver(s.InsertarLinea("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrego una linea 3 al archivo mensaje1");
        p.ver(s.InsertarLinea("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrego una linea 4 al archivo mensaje1");
        //p.ver(s.InsertarLinea("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrego una linea 1 al archivo mensaje1");
        //p.ver(s.InsertarLinea("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrego una linea 2 al archivo mensaje1");
        //p.ver(s.InsertarLinea("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrego una linea 3 al archivo mensaje1");
        //p.ver(s.InsertarLinea("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrego una linea 4 al archivo mensaje1");
//
////casos ERROR
        //p.ver(s.InsertarLinea("C", "Archivos", "mensaje4").resultado, Retorno.Resultado.ERROR, "Se intenta agregar una linea a archivo que no existe");
//
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// Retorno InsertarLineaEnPosicion(String unidad, String carpeta, String mensaje,int posicionLinea); //(OK)
////casos OK
        //p.ver(s.InsertarLineaEnPosicion("C", "Archivos", "mensaje1", 2).resultado, Retorno.Resultado.OK, "Se agrego una linea en la posicion 2 al archivo mensaje1");
        //p.ver(s.InsertarLineaEnPosicion("C", "Archivos", "mensaje1", 5).resultado, Retorno.Resultado.OK, "Se agrego una linea en la posicion 5 al archivo mensaje1");

//casos ERROR
        //p.ver(s.InsertarLineaEnPosicion("C", "Archivos", "mensaje1", 10).resultado, Retorno.Resultado.ERROR, "Se intenta agregar linea en posicion no valida");
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos"ﬁ).resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// Retorno BorrarLinea(String unidad, String carpeta, String mensaje,int posicionLinea);
//        //casos OK
        //p.ver(s.BorrarLinea("C", "Archivos", "mensaje1", 6).resultado, Retorno.Resultado.OK, "Se borra linea 6");
        //p.ver(s.BorrarLinea("C", "Archivos", "mensaje1", 3).resultado, Retorno.Resultado.OK, "Se borra linea 3");
////casos ERROR
        //p.ver(s.BorrarLinea("C", "Archivos", "mensaje1", 20).resultado, Retorno.Resultado.ERROR, "Se INTENTA BORRAR LINEA QUE NO EXISTE");
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//
//// Retorno BorrarTodo(String unidad, String carpeta, String mensaje); //()
////casos OK
        //p.ver(s.BorrarTodo("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se borra toda la informacion de mensaje 3");
//        //casos ERROR
        //p.ver(s.BorrarTodo("C", "Archivos", "mensaje20").resultado, Retorno.Resultado.ERROR, "Se intenta borrar todo de un mensaje que no existe");
//
////  listamos par ver si la estructura es correcta
        //p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);

//// Retorno BorrarOcurrenciasPalabraEnTexto(String unidad, String carpeta, String mensaje,String palabraABorrar);
////casos OK
        p.ver(s.BorrarOcurrenciasPalabraEnTexto("C", "Archivos", "mensaje1", "palabra1").resultado, Retorno.Resultado.OK, "Se borra ocurrencias de palabra en el texto");
        //p.ver(s.BorrarOcurrenciasPalabraEnTexto("C", "Archivos", "mensaje1", "insertar").resultado, Retorno.Resultado.OK, "Se borra ocurrencias de insertar en el texto");
        ////casos ERROR
        //p.ver(s.BorrarOcurrenciasPalabraEnTexto("C", "Archivos", "mensaje1", "palabraX").resultado, Retorno.Resultado.ERROR, "Se intenta borra ocurrencias de palabra que no existe en el texto");

        /// Retorno ImprimirTexto(String unidad, String carpeta, String mensaje);//()
////casos OK
        //p.ver(s.ImprimirTexto("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se imprime el contenido de mensaje 1" + "\n" + s.ImprimirTexto("C", "Archivos", "mensaje1").valorString);
        //p.ver(s.ImprimirTexto("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se imprime el contenido de mensaje 3" + "\n" + s.ImprimirTexto("C", "Archivos", "mensaje3").valorString);
//
////casos ERROR
        //p.ver(s.ImprimirTexto("C", "Archivos", "mensaje20").resultado, Retorno.Resultado.ERROR, "Se intenta imprimir el contenido de mensaje que no existe");
//

//// Retorno InsertarPalabraEnLinea(String unidad, String carpeta, String mensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);//()
////casos OK  REIVSAR
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 1, "palabra1").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 2, "palabra2").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 3, "palabra1").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 2, 1, "palabra1").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 2, 2, "palabra2").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 2, 3, "palabra1").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        
        //p.ver(s.BorrarOcurrenciasPalabraEnTexto("C", "Archivos", "mensaje1", "palabra1").resultado, Retorno.Resultado.OK, "Se borra ocurrencias de palabra en el texto");
        
//        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 2, 2, "palabra5").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 4, 1, "palabra6").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos"+ "\n" + s.ListarEstructura("C", "Archivos").valorString);
////casos ERROR
//////        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 1, "otra").resultado, Retorno.Resultado.ERROR, "Se intenta insertar palabra en linea no valida");
////        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 2, "nueva").resultado, Retorno.Resultado.ERROR, "Se intenta insertar palabra en posicionpalabra no valida");
//        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 2, 3, "palabra").resultado, Retorno.Resultado.ERROR, "Se inserta palabra en linea que ya esta llena");
//
////  listamos par ver si la estructura es correcta
//        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);
//// Retorno InsertarPalabraYDesplazar(String unidad, String carpeta,String mensaje,int posicionLinea, int posicionPalabra, String palabraAIngresar);//()
////casos OK
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 1, 1, "desplaza1").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 1, 1, "desplaza2").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 1, 1, "desplaza3").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 1, 2, "desplaza4").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 2, 1, "desplaza5").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 2, 1, "desplaza5").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 2, 1, "desplaza6").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 2, 1, "desplaza7").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        
        
        //p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos"+ "\n" + s.ListarEstructura("C", "Archivos").valorString);
        //p.ver(s.InsertarPalabraYDesplazar("C", "Archivos", "mensaje1", 5, 1, "desplaza8").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
        //p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos"+ "\n" + s.ListarEstructura("C", "Archivos").valorString);
////casos ERROR
//// Retorno BorrarPalabra(String unidad, String carpeta, String mensaje, int posicionLinea, int posicionPalabra);//()
////casos OK
        //p.ver(s.BorrarPalabra("C", "Archivos", "mensaje1", 1, 2).resultado, Retorno.Resultado.OK, "Se borra palabra");
        //p.ver(s.BorrarPalabra("C", "Archivos", "mensaje1", 1, 4).resultado, Retorno.Resultado.OK, "Se borra palabra");
//
////casos ERROR- REVISAR
        //p.ver(s.BorrarPalabra("C", "Archivos", "mensaje1", 8, 5).resultado, Retorno.Resultado.ERROR, "Se intenta borrar palabra en linea no valida");
//        p.ver(s.BorrarPalabra("C", "Archivos", "mensaje1", 1, 5).resultado, Retorno.Resultado.ERROR, "Se intenta borrar palabra en linea no valida");
//        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 4, "otra").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");
//        p.ver(s.InsertarPalabraEnLinea("C", "Archivos", "mensaje1", 1, 5, "Emanuel").resultado, Retorno.Resultado.OK, "Se inserta palabra en linea");

//// Retorno BorrarOcurrenciasPalabraEnLinea(String unidad, String carpeta, String mensaje,int posicionLinea, String palabraABorrar);//()
////casos OK
        //p.ver(s.BorrarOcurrenciasPalabraEnLinea("C", "Archivos", "mensaje1", 2, "palabra1").resultado, Retorno.Resultado.OK, "SE BORRA PALABRA");
        //p.ver(s.BorrarOcurrenciasPalabraEnLinea("C", "Archivos", "mensaje1", 1, "unaX").resultado, Retorno.Resultado.OK, "SE BORRA PALABRA");

////casos ERROR
//// Retorno ImprimirLinea(String unidad, String carpeta, String mensaje,int posicionLinea);//()
        ////casos OK
        //p.ver(s.ImprimirLinea("C", "Archivos", "mensaje1", 1).resultado, Retorno.Resultado.OK, "se impirme linea" + "\n" + s.ImprimirLinea("C", "Archivos", "mensaje1", 1).valorString);
//
////casos ERROR
        //p.ver(s.ImprimirLinea("C", "Archivos", "mensaje1", 8).resultado, Retorno.Resultado.ERROR, "se intenta impirmir linea que no es valida");

//// 
//// //Diccionario
//// Retorno IngresarPalabraDiccionario(String palabraAIngresar); 

////casos OK
//        p.ver(s.IngresarPalabraDiccionario("Deploy").resultado, Retorno.Resultado.OK, "Ingresando palabra Deploy a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Frontend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Backend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Emanuel").resultado, Retorno.Resultado.OK, "Ingresando palabra Emanuel a diccionario");

////casos ERROR
  //p.ver(s.IngresarPalabraDiccionario("Emanuel").resultado, Retorno.Resultado.ERROR, "Se intenta agregegar palabra que ya existe");

//// Retorno BorrarPalabraDiccionario(String palabraABorrar);//()
   //p.ver(s.BorrarPalabraDiccionario("Backend").resultado, Retorno.Resultado.OK, "Eliminando palabra Frontend a diccionario");//ver
////casos OK
//
////casos ERROR
//// Retorno ImprimirDiccionario();//()
        //p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK, "Diccionario impreso correctamente" + "\n" + s.ImprimirDiccionario().valorString);
//
////casos OK
////casos ERROR
//// Retorno ImprimirTextoIncorrecto(String unidad, String carpeta, String mensaje);//()
       //p.ver(s.ImprimirTextoIncorrecto("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se imprime el contenido que no esta en el Diccionario"+ "\n"+ s.ImprimirTextoIncorrecto("C", "Archivos", "mensaje1").valorString);
//
//// Busqueda de Camino
        //p.ver(s.BuscarCamino(s.mapa, "MVD", "NYC").resultado, Retorno.Resultado.OK, s.BuscarCamino(s.mapa, "MVD", "NYC").valorString);
//
//// Destruimos sistema de mensaje   
//        p.ver(s.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se destruye sistema");
// listamos la carpeta nuevamente para ver si estan los arvhivos correctos. 
        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos" + "\n" + s.ListarEstructura("C", "Archivos").valorString);

        p.imprimirResultadosPrueba();
    }

}
