/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package netcerbero;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class Historial {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ArrayList<Item> historial;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Historial() {
        this.historial = new ArrayList();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    private void basurero() {
        Item item;
        for (int i = this.historial.size() - 1; i >= 0; i--) {
            item = this.historial.get(i);
            if (item.getTTD() < 1) {
                this.historial.remove(i);
            }
        }
    }

    private void actualizarTTD() {
        Item item;
        try {
            for (int i = this.historial.size() - 1; i >= 0; i--) {
                item = this.historial.get(i);
                item.setTTD(item.getTTD() - 1);
            }
        } catch (IndexOutOfBoundsException ex) {
        } finally {
            this.basurero();
        }
    }

    /**
     * La función put cada vez que ingresa un item a el historial, decrementa el
     * tiempo TTD (Time To Death) de los items existentes, luego ingresa el
     * nuevo item con un TTD por defecto (10).
     *
     * @param obj Objeto a ser ingresado al historial con TTD por defecto.
     * @return VERDADERO si el ingreso fué exitoso, caso contrario devuelve
     * FALSO
     */
    public boolean put(Object obj) {
        try {
            if (obj != null) {
                if (!this.historial.isEmpty()) {
                    this.actualizarTTD();
                }
                Item aux = new Item(obj, Item.TTD_DEFAULT);
                this.historial.add(aux);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    /**
     * La función put cada vez que ingresa un item a el historial, decrementa el
     * tiempo TTD (Time To Death) de los items existentes, luego ingresa el
     * nuevo item con un TTD definido al momento del ingreso.
     *
     * @param obj Objeto a ser ingresado al historial con TTD por defecto.
     * @param ttd Time To Death TTD
     * @return VERDADERO si el ingreso fué exitoso, caso contrario devuelve
     * FALSO
     */
    public boolean put(Object obj, int ttd) {
        try {
            if (obj != null) {
                if (!this.historial.isEmpty()) {
                    this.actualizarTTD();
                }
                Item aux = new Item(obj, ttd);
                this.historial.add(aux);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    /**
     * Devuelve el último objeto guardado en el historial con un TTD superior a 1
     * @return Objeto guardado en el historial.
     */
    public Object get() {
        return this.historial.get(this.historial.size() - 1).get();
    }

    /**
     * Devuelve un objeto guardado en la posición idx del historial con un TTD
     * superior a 1.
     * @param idx Índice de búsqueda
     * @return Objeto guardado en el historial en la posición idx.
     */
    public Object get(int idx) {
        return this.historial.get(idx).get();
    }

    @Override
    public String toString() {
        Item item;
        String s = "{";
        try {
            for (int i = this.historial.size() - 1; i >= 0; i--) {
                item = this.historial.get(i);
                s += item.toString() + ",";
            }
        } catch (IndexOutOfBoundsException ex) {
        }
        s=s.substring(0,s.length()-1);
        s+="}";
        return s;
    }

    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Método Main">
    public static void main(String[] args) {
        //TODO-Aquí va la lógica para iniciar la clase
        Historial v = new Historial();
        for (int i = 0; i < 10; i++) {
            String o = "Objeto" + i;
            System.out.println("Insertando Objeto");
            v.put(o, 100);
            System.out.println(v.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }
    //</editor-fold>

    private class Item {

        public static final int TTD_DEFAULT = 10;
        private Object item;
        private int ttd;

        public Item() {
            this.item = null;
            this.ttd = 0;
        }

        public Item(Object item, int ttd) {
            this.item = item;
            this.ttd = ttd;
        }

        public Object get() {
            return this.item;
        }

        public int getTTD() {
            return this.ttd;
        }

        public void setTTD(int ttd) {
            this.ttd = ttd;
        }

        @Override
        public String toString() {
            return "[item=" + item.toString() + ",ttd=" + ttd + "]";
        }

    }

}
