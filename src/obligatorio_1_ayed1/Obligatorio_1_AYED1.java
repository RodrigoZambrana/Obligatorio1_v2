
package obligatorio_1_ayed1;

public class Obligatorio_1_AYED1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int cantUnidades = 0;
//        crearSistemaMensajes(cantUnidades);
        
        Prueba prueba1= new Prueba();
        Sistema sistema =new Sistema();
        
        prueba1(sistema, prueba1);
        

    }
    
    public static void prueba1(Sistema s, Prueba p){
    // casos Ok
    p.ver(s.crearSistemaMensajes().resultado,Retorno.Resultado.OK,"Se crea sistema de mensajes");
    
//    // agregar carpetas 
      p.ver(s.AgregarCarpeta("C:", "Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta Archivos en unidad C"); 
      p.ver(s.AgregarCarpeta("C:", "Documentos").resultado, Retorno.Resultado.OK, "Se creo la carpeta documentos en unidad C");   
      p.ver(s.AgregarCarpeta("C:", "Mensajes").resultado, Retorno.Resultado.OK, "Se creo la carpeta mensajes en unidad C");
      p.ver(s.AgregarCarpeta("C:", "Otros Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta otros Archivos en unidad C");
   // listamos par ver si la estructura es correcta
      p.ver(s.ListarEstructura("C:","Archivos").resultado,Retorno.Resultado.OK,"Se muestra la estrucura actual del sistema"+"\n"+s.ListarEstructura("C:", "Archivos").valorString);
//   // listamos par ver si la estructura es correcta
     p.ver(s.ListarEstructura("C","Archivos").resultado,Retorno.Resultado.OK,"Se listan los documentos de la carpeta Archivos");    
    // agregamos mensajes a una carpeta
      p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega mensaje 1 en carpeta Archivos");
      //p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega mensaje 2 en carpeta Archivos");
      //p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrega mensaje 3 en carpeta Archivos");
 
      // listamos la carpeta Archivos para ver si estan los mensajes agregados.
      p.ver(s.ListarEstructura("C:","Archivos").resultado,Retorno.Resultado.OK,"Se muestra la estrucura actual del sistema"+"\n"+s.ListarEstructura("C:", "Archivos").valorString);
      
// agregamos un nuevo mensaje y posteriormente lo elimino 
      p.ver(s.AgregarMensaje("C:", "Archivos", "mensajex").resultado, Retorno.Resultado.OK, "Se agrega mensaje x en carpeta Archivos");
      p.ver(s.EliminarMensaje("C:","Archivos","mensajex").resultado, Retorno.Resultado.OK, "Se  elimina mensaje x en carpeta Archivos ");
//   
//    // listamos la carpeta nuevamente para ver si estan los arvhivos correctos.
      p.ver(s.ListarEstructura("C:","Archivos").resultado,Retorno.Resultado.OK,"Se muestra la estrucura actual del sistema"+"\n"+s.ListarEstructura("C:", "Archivos").valorString);       


//agregamos una nueva línea a un mensaje
      //p.ver()

//    // CASOS DE ERROR
      p.ver(s.AgregarCarpeta("C:", "Archivos").resultado, Retorno.Resultado.ERROR,s.AgregarCarpeta("C:", "Archivos").valorString);   
      p.ver(s.EliminarCarpeta("C:", "Carpeta X").resultado, Retorno.Resultado.ERROR, s.EliminarCarpeta("C:", "Carpeta X").valorString);
      p.ver(s.AgregarMensaje("C:", "Archivos", "mensaje1").resultado, Retorno.Resultado.ERROR,  s.AgregarMensaje("C:","Archivos", "mensaje1").valorString);
      p.ver(s.EliminarMensaje("C:","Archivos","mensaje4").resultado, Retorno.Resultado.ERROR,  s.EliminarMensaje("C:", "Archivos","mensaje4").valorString);
//    
      p.ver(s.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se destruye sistema" );

    // p.ver(s.BuscarCamino(s.mapa, "MVD", "NYC").resultado, Retorno.Resultado.OK,s.BuscarCamino(s.mapa, "MVD", "NYC").valorString);
      p.ver(s.ListarEstructura("C:","Archivos").resultado,Retorno.Resultado.OK,"Se muestra la estrucura actual del sistema"+"\n"+s.ListarEstructura("C:", "Archivos").valorString);
    
      p.imprimirResultadosPrueba();
    
    //iMPLEMENTACION DE DICCIONARIO, AGREGAR PALABRAS AL DICCIOARIO.lINEA DE PALABRAS
}  
    
    
}
