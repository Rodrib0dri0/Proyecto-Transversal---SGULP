
package Vista;

import Conexion.Alumno;
import Conexion.Inscripcion;
import Persistencia.AlumnoData;
import Persistencia.InscripcionData;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class VistaListarInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    InscripcionData insD= new InscripcionData();
    
    public VistaListarInscripciones() {
        initComponents();
        cargarLista();
        armarCabecera();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCAlumno = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTable = new javax.swing.JTable();

        jCAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jCAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCAlumnoItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Lista de Inscripciones");

        jLabel1.setText("Alumno:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCAlumnoItemStateChanged
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jCAlumnoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTTable;
    // End of variables declaration//GEN-END:variables

    public void cargarLista() {
        AlumnoData ad = new AlumnoData();
        List<Alumno> lista = new ArrayList();
        lista = ad.cargarAlumnos();

        for (Alumno a : lista) {
            jCAlumno.addItem(a.toString());
        }
    }
    
    public void armarCabecera() {
        modelo.addColumn("ID Inscripción");
        modelo.addColumn("Materia ");
        modelo.addColumn("Nota");
        modelo.addColumn("Año de cursada");
        jTTable.setModel(modelo);
    }
    
    public void cargarTabla(){
        modelo.setRowCount(0);
        
        String nombreAlu = jCAlumno.getSelectedItem().toString();
        Alumno alumno = buscarAlumno(nombreAlu);
        
        List<Inscripcion> listaIns;

        listaIns = insD.cargarInscripcionesDeAlumno(alumno.getIdAlumno());
        
        for (Inscripcion i : listaIns) {
            modelo.addRow(new Object[]{i.getIdInscripto(),i.getMateria().getNombre(),i.getNota(),i.getAñoCursada()});
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
}
