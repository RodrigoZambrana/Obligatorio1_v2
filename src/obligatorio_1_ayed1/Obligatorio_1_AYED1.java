package obligatorio_1_ayed1;

public class Obligatorio_1_AYED1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int cantUnidades = 0;
//        crearSistemaMensajes(cantUnidades);

        Prueba prueba1 = new Prueba();
        Sistema sistema = new Sistema(0);//recibe como parametro la cantidad de cuidades a gestionar para el ultimo ejercicio

        pruebasCasosOK(sistema, prueba1);
        //pruebasCasosError(sistema, prueba1);

    }

    public static void pruebasCasosOK(Sistema s, Prueba p) {
// casos Ok
        p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se crea sistema de mensajes");
       // p.ver(s.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se destruye sistema");

        // agregar carpetas 
        p.ver(s.AgregarCarpeta("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta Archivos en unidad C");
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
        p.ver(s.AgregarCarpeta("C:", "Documentos").resultado, Retorno.Resultado.OK, "Se creo la carpeta documentos en unidad C");
        p.ver(s.AgregarCarpeta("C:", "Mensajes").resultado, Retorno.Resultado.OK, "Se creo la carpeta mensajes en unidad C");
        p.ver(s.AgregarCarpeta("C:", "Otros Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta otros Archivos en unidad C");

        // listamos par ver si la estructura es correcta
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
    //listamos par ver si la estructura es correcta
        p.ver(s.ListarEstructura("C", "Archivos").resultado, Retorno.Resultado.OK, "Se listan los documentos de la carpeta Archivos");
         //agregamos mensajes a una carpeta
        p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega mensaje 1 en carpeta Archivos");
        p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega mensaje 2 en carpeta Archivos");
        p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrega mensaje 3 en carpeta Archivos");

        // listamos la carpeta Archivos para ver si estan los mensajes agregados.
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);

// agregamos un nuevo mensaje y posteriormente lo elimino 
//        p.ver(s.AgregarMensaje("C:", "Archivos", "mensajex").resultado, Retorno.Resultado.OK, "Se agrega mensajex en carpeta Archivos");
//        p.ver(s.EliminarMensaje("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se  elimina mensaje1 en carpeta Archivos ");
//        p.ver(s.EliminarMensaje("C:", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se  elimina mensaje3 en carpeta Archivos ");
        // p.ver(s.EliminarMensaje("C:","Archivos","mensajex").resultado, Retorno.Resultado.OK, "Se  elimina mensajex en carpeta Archivos ");
  
//    // listamos la carpeta nuevamente para ver si estan los arvhivos correctos.
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);

//agregamos una nueva línea a un mensaje2
//        p.ver(s.InsertarLinea("C:", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje2 en carpeta Archivos" + "\n");
//        p.ver(s.InsertarLinea("C:", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje2 en carpeta Archivos" + "\n");
//        p.ver(s.InsertarLinea("C:", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje2 en carpeta Archivos" + "\n");
         p.ver(s.InsertarLinea("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje1 en carpeta Archivos"+"\n");
         p.ver(s.InsertarLinea("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje1 en carpeta Archivos"+"\n");
         p.ver(s.InsertarLinea("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega linea en blanco a  mensaje1 en carpeta Archivos"+"\n");

        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);

//agregamos una nueva línea en posicion
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensaje2", 2).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 2 dentro de mensaje2 en carpeta Archivos" + "\n");
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensaje2", 1).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensaje2 en carpeta Archivos" + "\n");
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensaje2", 3).resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario" + "\n");
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensajex", 1).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensajex en carpeta Archivos" + "\n");
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensajex", 2).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensajex en carpeta Archivos" + "\n");
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensajex", 3).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensajex en carpeta Archivos" + "\n");
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensajex", 2).resultado, Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensajex en carpeta Archivos" + "\n");
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
//        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);

      p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensaje1",3).resultado,Retorno.Resultado.OK, "Se inserta linea en posicion 1 dentro de mensaje1 en carpeta Archivos"+"\n");
      p.ver(s.InsertarLineaEnPosicion("C:", "Archivos", "mensaje1",4).resultado,Retorno.Resultado.OK, "Se inserta linea en posicion 4 dentro de mensaje1 en carpeta Archivos"+"\n");
     
//agregamos palabras al diccionario
//        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK,"Se muestra las palabras en el diccionario" + "\n" +s.ImprimirDiccionario().valorString);
//        p.ver(s.IngresarPalabraDiccionario("algoritmos").resultado, Retorno.Resultado.OK, "Se agrega palabra algoritmos  al diccionario");  
//        p.ver(s.IngresarPalabraDiccionario("algoritmos1").resultado, Retorno.Resultado.OK, "Se agrega palabra algoritmos1  al diccionario");
//        p.ver(s.IngresarPalabraDiccionario("palabrax").resultado, Retorno.Resultado.OK, "Se agrega palabra palabrax  al diccionario" + "\n");
//  
//        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK,"Se muestra las palabras en el diccionario" + "\n" +s.ImprimirDiccionario().valorString);
//
//        p.ver(s.BorrarPalabraDiccionario("algoritmos1").resultado, Retorno.Resultado.OK, "Se borra palabra algoritmos1  del diccionario"+"\n");
//        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK,"Se muestra las palabras en el diccionario" + "\n" +s.ImprimirDiccionario().valorString);
////
//        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK, "Se imprimen las palabras ingresadas en el diccionario" + "\n" + s.ImprimirDiccionario().valorString);
//        p.ver(s.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Se imprimen las palabras que no se encuentran en el diccionario" + "\n" + s.ImprimirTextoIncorrecto().valorString);
//
       //  p.ver(s.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se destruye sistema");

//funcionalidades de busqueda de camino       
        // p.ver(s.BuscarCamino(s.mapa, "MVD", "NYC").resultado, Retorno.Resultado.OK,s.BuscarCamino(s.mapa, "MVD", "NYC").valorString);
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);

        p.imprimirResultadosPrueba();


    }
    
    public static void pruebasCasosError(Sistema s, Prueba p) {
        
 // CASOS DE ERROR
 //Se incia sistema
       p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se crea sistema de mensajes");
 //Agregar carpeta con nombre ya existente
        p.ver(s.AgregarCarpeta("C:", "Archivos").resultado, Retorno.Resultado.OK,"Se agrego la carpeta Archivos a la unidad C:"); 
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
        p.ver(s.AgregarCarpeta("C:", "Archivos").resultado, Retorno.Resultado.ERROR,s.AgregarCarpeta("C:", "Archivos").valorString);
        p.ver(s.ListarEstructura("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se muestra la estrucura actual del sistema" + "\n" + s.ListarEstructura("C:", "Archivos").valorString);
 //Agregar carpeta en unidad no existente existente
        p.ver(s.AgregarCarpeta("D:", "Archivos").resultado, Retorno.Resultado.ERROR, "Se intenta agregar carpeta en unidad no existente" + "\n" + s.AgregarCarpeta("D:", "Archivos").valorString);
 
//Eliminar carpeta no existente existente
        p.ver(s.EliminarCarpeta("C:", "Carpeta X").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar carpeta no existente" + "\n"+s.EliminarCarpeta("C:", "Carpeta X").valorString);

//Eliminar carpeta en unidad no existente existente
        p.ver(s.EliminarCarpeta("D:", "Carpeta X").resultado, Retorno.Resultado.ERROR,"Se intenta eliminar carpeta en unidad no existente" + "\n"+ s.EliminarCarpeta("D:", "Carpeta X").valorString);

        
//Agregar archivo con nombre ya existente

//Agregar archivo en carpeta no existente

//Agregar archivo  en unidad no existente


//Eliminar  archivo con nombre no existente

//Eliminar archivo en carpeta no existente

//Eliminar archivo en unidad no existente

//Inserta una nueva línea vacía en la posición no valida

//Borrar una línea vacía en la posición no valida.

//Borra r ocurrencias de una palabra que no existe

//Insertar una línea con la posición de la línea no es válida.

//Insertar una línea si la posición de la palabra no es válida.

//Si se superara la cantidad máxima de palabras por línea.

//Inserta una palabra en una línea  Si la posición de la línea no es válida.
//Inserta una palabra en una línea  Si la posición de la palabra no es válida.

//Borra la palabra una palabra en una línea  Si la posición de la línea no es válida.
//        
//Borra la palabra  una palabra en una línea  Si la posición de la línea no es válida.



     p.imprimirResultadosPrueba();
     
    
    }
    
    
    

}
