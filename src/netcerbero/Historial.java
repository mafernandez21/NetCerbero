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
    private ArrayList<Item> core;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Historial() {
        this.core = new ArrayList();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    private void basurero() {
        Item item;
        for (int i = this.core.size() - 1; i >= 0; i--) {
            item = this.core.get(i);
            if (item.getTTD() < 1) {
                this.core.remove(i);
            }
        }
    }

    private void actualizarTTD() {
        Item item;
        try {
            for (int i = this.core.size() - 1; i >= 0; i--) {
                item = this.core.get(i);
                item.setTTD(item.getTTD() - 1);
            }
        } catch (IndexOutOfBoundsException ex) {
        } finally {
            this.basurero();
        }
    }

    public boolean put(Object item) {
        try {
            if (item != null) {
                if (!this.core.isEmpty()) {
                    this.actualizarTTD();
                }
                Item aux = new Item(item, Item.TTD_DEFAULT);
                this.core.add(aux);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public boolean put(Object item, int ttd) {
        try {
            if (item != null) {
                if (!this.core.isEmpty()) {
                    this.actualizarTTD();
                }
                Item aux = new Item(item, ttd);
                this.core.add(aux);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public Object get() {
        return this.core.get(this.core.size() - 1).get();
    }

    public Object get(int idx) {
        return this.core.get(idx).get();
    }

    @Override
    public String toString() {
        Item item;
        String s = "";
        try {
            for (int i = this.core.size() - 1; i >= 0; i--) {
                item = this.core.get(i);
                s += item.toString() + "\n";
            }
        } catch (IndexOutOfBoundsException ex) {
        }
        return s;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Método Main">
    public static void main(String[] args) {
        //TODO-Aquí va la lógica para iniciar la clase
        Historial v = new Historial();
        for (int i = 0; i < 100; i++) {
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
            return "Item{" + "item=" + item.toString() + ", ttd=" + ttd + '}';
        }

    }

}
