/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package netcerbero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class VentanaHistorial extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private JTextArea areaTextoInfo;
    private JButton btnSalir;
    private JCheckBox chkDHCPv4;
    private JPanel panelPrincipal;
    private JScrollPane panelScroll;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public VentanaHistorial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        chkDHCPv4 = new javax.swing.JCheckBox();
        panelScroll = new javax.swing.JScrollPane();
        areaTextoInfo = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        this.setTitle("NetCerbero");

        this.setLocationRelativeTo(null);

        panelPrincipal.setBackground(new java.awt.Color(0, 0, 204));

        chkDHCPv4.setFont(new Font("Tahoma", 0, 12));
        chkDHCPv4.setForeground(new Color(255, 255, 255));
        chkDHCPv4.setText("Servicio DHCPv4");
        chkDHCPv4.setOpaque(false);
        chkDHCPv4.setSelected(true);

        areaTextoInfo.setColumns(20);
        areaTextoInfo.setRows(5);
        panelScroll.setViewportView(areaTextoInfo);

        btnSalir.setText("Salir");

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "Net Cerbero", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(chkDHCPv4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chkDHCPv4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelScroll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public void agregarTextoHistorial(String sTexto) {
        this.areaTextoInfo.setText(this.areaTextoInfo.getText() + "\n" + sTexto);
    }
    
    public boolean estaElServicioDHCPActivo(){
        return this.chkDHCPv4.isSelected();
    }
    
    public void inhabilitarChkServicioDHCP(){
        this.chkDHCPv4.setEnabled(false);
    }
    
    
    public void habilitarChkServicioDHCP(){
        this.chkDHCPv4.setEnabled(true);
    }

    //</editor-fold>
    public void centar() {
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension tamVentana = this.getSize();

        Dimension posicion= new Dimension();
        posicion.width=((tamPantalla.width-tamVentana.width)/2);
        posicion.height=((tamPantalla.height-tamVentana.height)/2);
        this.setLocation(posicion.width,posicion.height);
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }

    //<editor-fold defaultstate="collapsed" desc="Método Main">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        VentanaHistorial vh = new VentanaHistorial();

        vh.setVisible(true);

        for (int i = 0; i < 100; i++) {
            vh.agregarTextoHistorial("sTexto " + i);
        }
    }
    //</editor-fold>

}
