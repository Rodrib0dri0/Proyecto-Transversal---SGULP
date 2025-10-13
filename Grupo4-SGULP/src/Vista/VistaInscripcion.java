package Vista;

import java.util.*;
import Conexion.Alumno;
import Conexion.Inscripcion;
import Conexion.Materia;
import Persistencia.AlumnoData;
import Persistencia.InscripcionData;
import Persistencia.MateriaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaInscripcion extends javax.swing.JInternalFrame {

    AlumnoData ad = new AlumnoData();
    InscripcionData insD = new InscripcionData();
    MateriaData md = new MateriaData();

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaInscripcion() {
        initComponents();
        jRIns.setSelected(true);
        cargarLista();
        armarCabecera();
        jBInscribir.setEnabled(false);
        mostrarMaterias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGInscripcion = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCAlumno = new javax.swing.JComboBox<>();
        jRIns = new javax.swing.JRadioButton();
        jRNoins = new javax.swing.JRadioButton();
        jBInscribir = new javax.swing.JButton();
        jBAnular = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTAño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTTabla);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Alumno:");

        jCAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCAlumnoItemStateChanged(evt);
            }
        });

        bGInscripcion.add(jRIns);
        jRIns.setText("Inscriptas");
        jRIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRInsActionPerformed(evt);
            }
        });

        bGInscripcion.add(jRNoins);
        jRNoins.setText("No inscriptas");
        jRNoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRNoinsActionPerformed(evt);
            }
        });

        jBInscribir.setText("Inscribir");
        jBInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInscribirActionPerformed(evt);
            }
        });

        jBAnular.setText("Anular inscripción");
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Inscripción a Materias");

        jLabel3.setText("Año de cursada:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jRIns)
                        .addGap(18, 18, 18)
                        .addComponent(jRNoins))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jBInscribir)
                        .addGap(42, 42, 42)
                        .addComponent(jBAnular)
                        .addGap(31, 31, 31)
                        .addComponent(jBSalir)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTAño, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRIns)
                    .addComponent(jRNoins))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBAnular)
                    .addComponent(jBSalir))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRInsActionPerformed
        // TODO add your handling code here:
        mostrarMaterias();
        jBInscribir.setEnabled(false);
        jBAnular.setEnabled(true);
    }//GEN-LAST:event_jRInsActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jRNoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRNoinsActionPerformed
        // TODO add your handling code here:
        mostrarMaterias();
        jBAnular.setEnabled(false);
        jBInscribir.setEnabled(true);
    }//GEN-LAST:event_jRNoinsActionPerformed

    private void jBInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInscribirActionPerformed
        // TODO add your handling code here:
        inscribir();
        mostrarMaterias();
    }//GEN-LAST:event_jBInscribirActionPerformed

    private void jCAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCAlumnoItemStateChanged
        // TODO add your handling code here:
        mostrarMaterias();
    }//GEN-LAST:event_jCAlumnoItemStateChanged

    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed
        // TODO add your handling code here:
        anularInscri();
        mostrarMaterias();
    }//GEN-LAST:event_jBAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGInscripcion;
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRIns;
    private javax.swing.JRadioButton jRNoins;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTAño;
    private javax.swing.JTable jTTabla;
    // End of variables declaration//GEN-END:variables

    public void cargarLista() {
        AlumnoData ad = new AlumnoData();
        List<Alumno> lista = new ArrayList();
        lista = ad.cargarAlumnos();

        for (Alumno a : lista) {
            jCAlumno.addItem(a.toString());
        }
    }

    public void anularInscri(){
        
        int fila = jTTabla.getSelectedRow();
        
        int id = Integer.parseInt(jTTabla.getValueAt(fila, 0).toString());
        
        insD.anular(id);
        
    }
    public void inscribir() {
        if (jTAño.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar año.");
        } else {
            int fila = jTTabla.getSelectedRow();
            if (fila >= 0) {
                int id = Integer.parseInt(jTTabla.getValueAt(fila, 0).toString());
                Materia mate = md.buscarMateria(id);

                String nombreAlu = jCAlumno.getSelectedItem().toString();
                Alumno alumno = buscarAlumno(nombreAlu);
                
                int año = Integer.parseInt(jTAño.getText());

                Inscripcion ins = new Inscripcion(alumno, mate, año);

                insD.Inscribir(ins);
                mostrarMaterias();
            }
        }
    }

    public Alumno buscarAlumno(String nombre) {
        AlumnoData ad = new AlumnoData();
        List<Alumno> lista = new ArrayList();
        lista = ad.cargarAlumnos();

        for (Alumno a : lista) {
            if ((a.getNombre() + " " + a.getApellido()).equals(nombre)) {
                return a;
            }
        }
        return null;
    }

    public void mostrarMaterias() {
        modelo.setRowCount(0);
        String nombreAlu = jCAlumno.getSelectedItem().toString();

        Alumno alumno = buscarAlumno(nombreAlu);

        List<Materia> materias;

        if (jRIns.isSelected()) {
            materias = insD.inscripto(alumno.getIdAlumno());
        } else {
            materias = insD.noInscripto(alumno.getIdAlumno());
        }

        for (Materia m : materias) {
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre()});
        }

    }

    public void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        jTTabla.setModel(modelo);
    }
}
