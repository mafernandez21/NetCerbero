/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package net.floodlightcontroller.netcerbero;

import netcerbero.VentanaHistorial;

/**
 *
 * @author Martín Alejandro
 */
public class NetCerbero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaHistorial vh=new VentanaHistorial();
        vh.centar();
        vh.mostrar();
        
    }
    
}
