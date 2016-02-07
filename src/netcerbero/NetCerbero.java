/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package netcerbero;

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
        vistaPrincipal vp=new vistaPrincipal();
        vp.setVisible(true);
        String arg[]=null;
        Historial.main(arg);
        
    }
    
}
