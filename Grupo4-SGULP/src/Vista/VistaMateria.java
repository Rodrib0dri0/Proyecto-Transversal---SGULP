package Vista;

import Conexion.Materia;
import Persistencia.MateriaData;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

public class VistaMateria extends javax.swing.JInternalFrame {

    MateriaData md = new MateriaData();

    List<Materia> listaMaterias = new ArrayList();

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaMateria() {
        initComponents();
        armarCabecera();
        cargarTabla();
        cargarID();
        jBBuscar.setEnabled(false);
        jBActualizar.setEnabled(false);
        jBEliminar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCID = new javax.swing.JComboBox<>();
        jTNombre = new javax.swing.JTextField();
        jTAño = new javax.swing.JTextField();
        jRActivo = new javax.swing.JRadioButton();
        jRInactivo = new javax.swing.JRadioButton();
        jBGuardar = new javax.swing.JButton();
        jBLimpiar1 = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();

        jLabel1.setText("ID: ");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Año:");

        jLabel4.setText("Estado:");

        jCID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCIDItemStateChanged(evt);
            }
        });

        GrupoEstado.add(jRActivo);
        jRActivo.setText("Activo");

        GrupoEstado.add(jRInactivo);
        jRInactivo.setText("Inactivo");

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBLimpiar1.setText("Limpiar");
        jBLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiar1ActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Gestión de Materias");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Lista de Materias");

        jTTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTTable);

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jRActivo))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTAño, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jBGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(jBLimpiar1)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRInactivo)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jBActualizar)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBEliminar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBSalir)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jBSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRActivo)
                            .addComponent(jRInactivo))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBGuardar)
                            .addComponent(jBLimpiar1)
                            .addComponent(jBActualizar)
                            .addComponent(jBEliminar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        try {
            if (jTNombre.getText().isEmpty() || jTAño.getText().isEmpty() || (!jRActivo.isSelected() && !jRInactivo.isSelected())) {
                JOptionPane.showMessageDialog(null, "No deben quedar campos vacios.");
            } else {

                String nombre = jTNombre.getText();
                int año = Integer.parseInt(jTAño.getText());

                boolean estado;
                if (jRActivo.isSelected()) {
                    estado = true;
                } else {
                    estado = false;
                }

                Materia mat = new Materia(nombre, año, estado);

                md.insertarMateria(mat);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El año debe ser un número valido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
        cargarTabla();
        cargarID();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        try {
            if (jTNombre.getText().isEmpty() || jTAño.getText().isEmpty() || (!jRActivo.isSelected() && !jRInactivo.isSelected())) {
                JOptionPane.showMessageDialog(null, "No deben quedar campos vacios.");
            } else {

                int id = Integer.parseInt(jCID.getSelectedItem().toString());
                String nombre = jTNombre.getText();
                int año = Integer.parseInt(jTAño.getText());
                boolean estado;
                if (jRActivo.isSelected()) {
                    estado = true;
                } else {
                    estado = false;
                }

                Materia matActualizada = new Materia(nombre, año, estado);
                matActualizada.setIdMateria(id);
                md.actualizarMateria(matActualizada);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El año debe ser un número valido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
        cargarTabla();

    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int materiaId = Integer.parseInt(jCID.getSelectedItem().toString());

            md.eliminarMateria(materiaId);

            cargarTabla();
            limpiar();
            cargarID();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar.");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        try {
            int materiaId = Integer.parseInt(jCID.getSelectedItem().toString());

            Materia materia = md.buscarMateria(materiaId);

            if (materia != null) {
                jTNombre.setText(materia.getNombre());
                jTAño.setText(String.valueOf(materia.getAño()));
                if (materia.isEstado()) {
                    jRActivo.setSelected(true);
                } else {
                    jRInactivo.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Buscar.");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCIDItemStateChanged
        // TODO add your handling code here:
        if (jCID.getSelectedItem() == null || jCID.getSelectedItem().toString().trim().isEmpty()) {
            jBBuscar.setEnabled(false);
            jBActualizar.setEnabled(false);
            jBEliminar.setEnabled(false);
            jBGuardar.setEnabled(true);
        } else {
            jBBuscar.setEnabled(true);
            jBActualizar.setEnabled(true);
            jBEliminar.setEnabled(true);
            jBGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jCIDItemStateChanged

    private void jBLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiar1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jBLimpiar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoEstado;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar1;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRActivo;
    private javax.swing.JRadioButton jRInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTAño;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables

    public void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        modelo.addColumn("Estado");
        jTTable.setModel(modelo);
    }

    public void cargarID() {
        jCID.removeAllItems();
        jCID.addItem("");

        List<Materia> lista = new ArrayList();
        lista = md.cargarMaterias();

        for (Materia m : lista) {
            String idString = String.valueOf(m.getIdMateria());
            jCID.addItem(idString);
        }
    }

    public void cargarTabla() {
        modelo.setRowCount(0);

        listaMaterias = md.cargarMaterias();

        for (Materia m : listaMaterias) {
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAño(), m.isEstado()});
        }
    }

    public void limpiar() {
        jTNombre.setText("");
        jTAño.setText("");
        jCID.setSelectedIndex(0);
        GrupoEstado.clearSelection();
    }
}
