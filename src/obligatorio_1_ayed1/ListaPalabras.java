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
public class ListaPalabras implements IListaPalabras{
    NodoPalabra Primero;
    NodoPalabra Ultimo;

     @Override
    public void vaciar() {
        this.Primero=null;
        this.Ultimo=null;
    }
    
    
}
