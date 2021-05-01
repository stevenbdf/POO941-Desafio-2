/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.formularios;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.material.escrito.*;
import sv.edu.udb.catalogos.*;
import sv.edu.udb.util.*;

/**
 *
 * @author Karina
 */
public class Principal extends javax.swing.JFrame {

    String col[] = {"Codigo", "Titulo", "Autor", "# de paginas", "ISBN", "Año de publicacion", "Unidades disponibles", "Editorial"};
    private DefaultTableModel libroModel = new DefaultTableModel(col, 0);
    private Libro libro = new Libro();
    private Editorial editorial = new Editorial();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.cargarLibros();
    }

    private void cargarLibros() {
        try {
            ResultSet rs = libro.obtenerLibros();

            while (rs.next()) {
                Object[] row = {rs.getString("codigo"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("numero_paginas"),
                    rs.getString("ISBN"), rs.getDate("anio_publicacion"), rs.getInt("unidades_disponibles"), rs.getString("editorial")};

                libroModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        libroTituloTXT = new javax.swing.JTextField();
        libroAutorTXT = new javax.swing.JTextField();
        libroNumPaginasTXT = new javax.swing.JTextField();
        libroISBNTXT = new javax.swing.JTextField();
        libroAnioPublicacionTXT = new javax.swing.JTextField();
        libroUnidadesDisponiblesTXT = new javax.swing.JTextField();
        libroEditorialComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        libroGuardarBoton = new javax.swing.JButton();
        jp2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab1.setBackground(new java.awt.Color(0, 153, 255));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("Libros");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 187, -1));

        tab2.setBackground(new java.awt.Color(51, 153, 255));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel2.setText("Revistas");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 159, -1, -1));

        tab3.setBackground(new java.awt.Color(0, 153, 255));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel3.setText("CD");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(tab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 218, 187, -1));

        tab4.setBackground(new java.awt.Color(0, 153, 204));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel4.setText("DVD");

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanel1.add(tab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, 187, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        jp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Libros");
        jp1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        tablaLibro.setModel(libroModel);
        jScrollPane1.setViewportView(tablaLibro);

        jp1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 740, 250));
        jp1.add(libroTituloTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, -1));
        jp1.add(libroAutorTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 140, -1));
        jp1.add(libroNumPaginasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 140, -1));
        jp1.add(libroISBNTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 140, -1));
        jp1.add(libroAnioPublicacionTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, -1));
        jp1.add(libroUnidadesDisponiblesTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 140, -1));

        libroEditorialComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jp1.add(libroEditorialComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 140, -1));

        jLabel9.setText("Titulo");
        jp1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel10.setText("Autor");
        jp1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel11.setText("Numero de Paginas");
        jp1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel12.setText("ISBN");
        jp1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jLabel13.setText("Año Publicacion");
        jp1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel14.setText("Unidades disponibles");
        jp1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel15.setText("Editorial");
        jp1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        libroGuardarBoton.setText("Guardar");
        libroGuardarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libroGuardarBotonMouseClicked(evt);
            }
        });
        jp1.add(libroGuardarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, -1));

        getContentPane().add(jp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 790, 580));

        jp2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Revistas");
        jp2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        getContentPane().add(jp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 790, 580));

        jp3.setPreferredSize(new java.awt.Dimension(790, 580));
        jp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("CDs");
        jp3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        getContentPane().add(jp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 790, 580));

        jp4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("DVDs");
        jp4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 43, -1, -1));

        getContentPane().add(jp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 790, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        // TODO add your handling code here:
        jp1.setVisible(true);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        tab1.setBackground(Color.white);
        tab2.setBackground(new Color(51, 153, 255));
        tab3.setBackground(new Color(51, 153, 255));
        tab4.setBackground(new Color(51, 153, 255));

    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        // TODO add your handling code here:
        jp2.setVisible(true);
        jp1.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        tab2.setBackground(Color.white);
        tab1.setBackground(new Color(51, 153, 255));
        tab3.setBackground(new Color(51, 153, 255));
        tab4.setBackground(new Color(51, 153, 255));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        // TODO add your handling code here:
        jp3.setVisible(true);
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp4.setVisible(false);
        tab3.setBackground(Color.white);
        tab2.setBackground(new Color(51, 153, 255));
        tab1.setBackground(new Color(51, 153, 255));
        tab4.setBackground(new Color(51, 153, 255));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        // TODO add your handling code here:
        jp4.setVisible(true);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp1.setVisible(false);
        tab4.setBackground(Color.white);
        tab2.setBackground(new Color(51, 153, 255));
        tab3.setBackground(new Color(51, 153, 255));
        tab1.setBackground(new Color(51, 153, 255));
    }//GEN-LAST:event_tab4MouseClicked

    private void libroGuardarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libroGuardarBotonMouseClicked
        // TODO add your handling code here:

        libro.crearLibro(
                libroTituloTXT.getText(),
                libroAutorTXT.getText(),
                Integer.parseInt(libroNumPaginasTXT.getText()),
                libroISBNTXT.getText(),
                Integer.parseInt(libroAnioPublicacionTXT.getText()),
                Integer.parseInt(libroUnidadesDisponiblesTXT.getText()),
                1
        );
        
        this.cargarLibros();
    }//GEN-LAST:event_libroGuardarBotonMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JTextField libroAnioPublicacionTXT;
    private javax.swing.JTextField libroAutorTXT;
    private javax.swing.JComboBox<String> libroEditorialComboBox;
    private javax.swing.JButton libroGuardarBoton;
    private javax.swing.JTextField libroISBNTXT;
    private javax.swing.JTextField libroNumPaginasTXT;
    private javax.swing.JTextField libroTituloTXT;
    private javax.swing.JTextField libroUnidadesDisponiblesTXT;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JTable tablaLibro;
    // End of variables declaration//GEN-END:variables
}